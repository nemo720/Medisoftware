package com.example.medicinesalesmanagement.service.TypeMember;

import com.example.medicinesalesmanagement.model.TypeMember;

import java.lang.reflect.Type;
import java.util.List;

public interface ITypeMemberService {
    List<TypeMember> findAll();
    TypeMember findById(Integer id);
}
