package com.example.medicinesalesmanagement.service.DetailType;

import com.example.medicinesalesmanagement.model.DetailType;
import com.example.medicinesalesmanagement.repository.IDetailTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailTypeService implements IDetailTypeService{
    @Autowired
    IDetailTypeRepository iDetailTypeRepository;
    @Override
    public void save(DetailType detailType) {
        iDetailTypeRepository.save(detailType);
    }
}
