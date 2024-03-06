package com.example.medicinesalesmanagement.repository;

import com.example.medicinesalesmanagement.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMemberRepository extends JpaRepository<Member,Integer> {
    List<Member> findMemberByNumberPhoneContaining(String numberPhone);
    @Query(value = "select * from member where type_member_id like :type_member_id",nativeQuery = true)
    List<Member> findMemberByTypeMember(@Param("type_member_id")Integer id);
    @Query(value = "select m.id_member, m.name, m.number_phone, m.type_member_id " +
            "from member m " +
            "join type_member t " +
            "on m.type_member_id = t.type_member_id " +
            "where m.number_phone like :number_phone and t.type_member_id like :type_number_id",nativeQuery = true)
    List<Member> findMemberByTypeMemberAndNumberPhoneContaining(@Param("number_phone")String numberPhone,
                                                                @Param("type_number_id")Integer id);
}
