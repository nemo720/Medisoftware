package com.example.medicinesalesmanagement.controller;

import com.example.medicinesalesmanagement.model.TypeMember;
import com.example.medicinesalesmanagement.service.TypeMember.ITypeMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/typeMember")
public class TypeMemberController {
    @Autowired
    ITypeMemberService iTypeMemberService;
    @GetMapping("/list")
    public ResponseEntity<List<TypeMember>> findAll(){
        List<TypeMember> typeMemberList = iTypeMemberService.findAll();
        if(typeMemberList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(typeMemberList,HttpStatus.OK);
    }
}
