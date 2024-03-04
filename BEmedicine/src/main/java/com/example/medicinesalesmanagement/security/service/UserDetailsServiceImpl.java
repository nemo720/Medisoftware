package com.example.medicinesalesmanagement.security.service;


import com.example.medicinesalesmanagement.model.Employee;
import com.example.medicinesalesmanagement.repository.IEmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;




@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IEmployeeRepository userRepository;


    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        Employee user = userRepository.findByUserName(username)
        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        // if(user != null && user.isEnabled()){
            
        //     return UserDetailsImpl.build(user);
        // }else{
        //     throw new UsernameNotFoundException("User Not Found with username: " + username);
        // }

        return UserDetailsImpl.build(user);

        
    }
    
}