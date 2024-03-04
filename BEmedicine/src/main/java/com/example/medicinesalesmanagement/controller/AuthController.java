package com.example.medicinesalesmanagement.controller;


import com.example.medicinesalesmanagement.dto.EmployeeDto;
import com.example.medicinesalesmanagement.model.Role;
import com.example.medicinesalesmanagement.model.request.CreateUserRequest;
import com.example.medicinesalesmanagement.model.request.LoginRequest;
import com.example.medicinesalesmanagement.model.response.MessageResponse;
import com.example.medicinesalesmanagement.model.response.UserInfoResponse;
import com.example.medicinesalesmanagement.security.jwt.JwtUtils;
import com.example.medicinesalesmanagement.security.service.UserDetailsImpl;
import com.example.medicinesalesmanagement.service.Employee.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*",maxAge = 3600)
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                        loginRequest.getPassword()));
        if(!authentication.isAuthenticated())return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

//        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE)
                .body(new UserInfoResponse(userDetails.getId(),
                        userDetails.getUsername(),
                        roles));
        // return ResponseEntity.ok(jwtCookie);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody CreateUserRequest request){

        employeeService.register(request);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

//    @PostMapping("/logout")
//    @Operation(summary="Đăng xuất")
//    public ResponseEntity<?> logoutUser() {
//      ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
//      return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
//          .body(new MessageResponse("You've been logout!"));
//    }
}
