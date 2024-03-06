package com.example.medicinesalesmanagement.service.Member;

import com.example.medicinesalesmanagement.model.Member;
import com.example.medicinesalesmanagement.repository.IMemberRepository;
import com.example.medicinesalesmanagement.service.Member.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MemberService implements IMemberService {
    @Autowired
    IMemberRepository iMemberRepository;
    @Override
    public List<Member> findMemberByNumberPhoneContaining(String numberPhone) {
        return iMemberRepository.findMemberByNumberPhoneContaining(numberPhone);
    }

    @Override
    public List<Member> findAll() {
        return iMemberRepository.findAll();
    }

    @Override
    public void save(Member member) {
        iMemberRepository.save(member);
    }

    @Override
    public Member findById(Integer id) {
        return iMemberRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        iMemberRepository.deleteById(id);
    }

    @Override
    public List<Member> findMemberByTypeMember(Integer id) {
        return iMemberRepository.findMemberByTypeMember(id);
    }

    @Override
    public List<Member> findMemberByTypeMemberAndNumberPhoneContaining(String numberPhone, Integer id) {
        return iMemberRepository.findMemberByTypeMemberAndNumberPhoneContaining("%" + numberPhone + "%",id);
    }
}
