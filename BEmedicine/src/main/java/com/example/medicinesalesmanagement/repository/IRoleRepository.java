package com.example.medicinesalesmanagement.repository;


import com.example.medicinesalesmanagement.model.ERole;
import com.example.medicinesalesmanagement.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(ERole name);
}
