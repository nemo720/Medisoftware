package com.example.medicinesalesmanagement.controller;

import com.example.medicinesalesmanagement.dto.MemberDto;
import com.example.medicinesalesmanagement.dto.MemberUpdateDto;
import com.example.medicinesalesmanagement.model.Member;
import com.example.medicinesalesmanagement.model.TypeMember;
import com.example.medicinesalesmanagement.service.Member.IMemberService;
import com.example.medicinesalesmanagement.service.TypeMember.ITypeMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/member")
public class MemberController {
    @Autowired
    IMemberService iMemberService;
    @Autowired
    ITypeMemberService iTypeMemberService;
    @GetMapping("/listSearchNumberPhone")
    public ResponseEntity<List<Member>> findAll(@RequestParam String numberPhone){
        List<Member> memberList = iMemberService.findMemberByNumberPhoneContaining(numberPhone);
        if(memberList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(memberList,HttpStatus.OK);
    }
    @GetMapping("/list")
    public ResponseEntity<List<Member>> findAll(){
        List<Member> memberList = iMemberService.findAll();
        if(memberList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(memberList,HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Member> create(@RequestBody MemberDto memberDto){
        if(memberDto == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        Member member = new Member();
        member.setName(memberDto.getName());
        member.setNumberPhone(memberDto.getNumberPhone());
        TypeMember typeMember = iTypeMemberService.findById(memberDto.getId_typeMember());
        member.setTypeMember(typeMember);

        iMemberService.save(member);
        return new ResponseEntity<>(member,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Member> detail(@PathVariable Integer id){
        Member member = iMemberService.findById(id);
        if(member == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(member,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Member> update(@PathVariable Integer id,@RequestBody MemberUpdateDto memberUpdateDto){
        Member member1 = iMemberService.findById(id);
        if(member1 == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Member member = new Member();
        member.setId_member(memberUpdateDto.getId_member());
        member.setName(memberUpdateDto.getName());
        member.setNumberPhone(memberUpdateDto.getNumberPhone());
        TypeMember typeMember = iTypeMemberService.findById(memberUpdateDto.getTypeMember().getType_member_id());
        member.setTypeMember(typeMember);

        iMemberService.save(member);
        return new ResponseEntity<>(member,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Member> delete(@PathVariable Integer id){
        Member member = iMemberService.findById(id);
        if(member == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iMemberService.delete(id);
        return new ResponseEntity<>(member,HttpStatus.NO_CONTENT);
    }
    @GetMapping("/listByTypeMember/{id}")
    public ResponseEntity<List<Member>> findMemberByTypeMember(@PathVariable Integer id){
        List<Member> memberList = iMemberService.findMemberByTypeMember(id);
        if(memberList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(memberList,HttpStatus.OK);
    }
    @GetMapping("/listByTypeMemberAndNumberPhoneContaining/{id}")
    public ResponseEntity<List<Member>> findMemberByTypeMemberAndNumberPhoneContaining(@PathVariable Integer id,
                                                                                       @RequestParam String numberPhone){
        List<Member> memberList = iMemberService.findMemberByTypeMemberAndNumberPhoneContaining(numberPhone,id);
        if(memberList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(memberList,HttpStatus.OK);
    }
}
