import {format} from 'date-fns'
import { Bar, BarChart, CartesianGrid, Legend, ResponsiveContainer, Tooltip, XAxis, YAxis } from 'recharts'
import {useEffect, useState} from "react";
import axios from "axios";

export function DanhThuMonth(){
    const [collects,setCollects] = useState();
    const [spends,setSpends] = useState();
    useEffect(() => {
        findAllCollects();
        findAllSpends();
    }, []);
    const findAllCollects = async () => {
        try{
            let temp = await axios.get("http://localhost:8080/api/bill/list");
            setCollects(temp.data);
        }catch (e){
            console.log(e);
        }
    }
    const findAllSpends = async () => {
        try{
            let temp = await axios.get("http://localhost:8080/api/inputWarehouse/list");
            setSpends(temp.data);
        }catch (e){
            console.log(e);
        }
    }

    if(!spends || !collects) return null;

// format the number
    const formatCurrency = (value) =>
        new Intl.NumberFormat('en', { style: 'currency', currency: 'VND' }).format(
            value
        );


    // format data

    const formatCollects = collects.map(collect => {
        return {
            date: format(collect.dateCreate, 'dd/MM/yyyy'),
            totalPrice: collect.totalPayment,
            totalPayment: 0
        }
    })

    const formatSpends = spends.map(spend=>{
        return{
            date: format(spend.inputDay, 'dd/MM/yyyy'),
            totalPayment: spend.totalPayment,
            totalPrice: 0
        }
    })


    const formatData = formatCollects.concat(formatSpends).reduce((acc, cur)=>{
        const key = cur.date;
        if(acc[key]){
            acc[key] = {...acc[key], totalPrice:  Math.ceil(acc[key].totalPrice + cur.totalPrice), totalPayment: Math.ceil(acc[key].totalPayment + cur.totalPayment)}
        }else{
            acc[key] = {date: key, totalPrice: cur.totalPrice, totalPayment: cur.totalPayment}
        }
        return acc;
    }, {})

    const data = Object.values(formatData)

    return (
        <>
            <div style={{padding: '100px'}}>
                <ResponsiveContainer width='100%' height={500}>
                    <BarChart data={data}>
                        <CartesianGrid strokeDasharray="4 4" />
                        <Legend/>
                        <XAxis dataKey='date'/>
                        <YAxis  tickFormatter={(value)=> `${value}`}/>
                        <Tooltip/>
                        <Bar dataKey='totalPrice' fill="#8884d8"/>
                        <Bar dataKey='totalPayment' fill="#82ca9d"/>
                    </BarChart>
                </ResponsiveContainer>
            </div>

        </>
    )
}