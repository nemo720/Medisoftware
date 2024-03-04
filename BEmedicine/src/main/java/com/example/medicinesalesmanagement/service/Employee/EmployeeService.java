package com.example.medicinesalesmanagement.service.Employee;

import com.example.medicinesalesmanagement.model.ERole;
import com.example.medicinesalesmanagement.model.Employee;
import com.example.medicinesalesmanagement.model.Role;
import com.example.medicinesalesmanagement.model.request.CreateUserRequest;
import com.example.medicinesalesmanagement.repository.IEmployeeRepository;
import com.example.medicinesalesmanagement.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    IEmployeeRepository iEmployeeRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private IRoleRepository roleRepository;
    @Override
    public List<Employee> findEmployeeByNameContaining(String name) {
        return iEmployeeRepository.findEmployeeByNameContaining(name);
    }

    @Override
    public List<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }

    @Override
    public void save(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public Employee findById(Integer id) {
        return iEmployeeRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        iEmployeeRepository.deleteById(id);
    }

    @Override
    public void register(CreateUserRequest request) {
        // TODO Auto-generated method stub
        Employee user = new Employee();
        user.setUserName(request.getUsername());
        user.setPassword(encoder.encode(request.getPassword()));
        Set<String> strRoles = request.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "mod":
                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }
        user.setRole(roles);
        iEmployeeRepository.save(user);
    }
}
