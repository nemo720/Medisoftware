package com.example.medicinesalesmanagement.service.TypeMember;

import com.example.medicinesalesmanagement.model.TypeMember;
import com.example.medicinesalesmanagement.repository.ITypeMemberRepository;
import com.example.medicinesalesmanagement.service.TypeMember.ITypeMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeMemberService implements ITypeMemberService {
    @Autowired
    ITypeMemberRepository iTypeMemberRepository;
    @Override
    public List<TypeMember> findAll() {
        return iTypeMemberRepository.findAll();
    }

    @Override
    public TypeMember findById(Integer id) {
        return iTypeMemberRepository.findById(id).orElse(null);
    }
}
