package com.ra.controller.auth;

import com.ra.model.dto.request.UserLogin;
import com.ra.model.dto.request.UserRegister;
import com.ra.model.dto.response.CategoryResponse;
import com.ra.model.dto.response.JwtResponse;
import com.ra.model.dto.response.UserResponse;
import com.ra.service.auth.IUserService;
import com.ra.service.category.ICategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {
    @Autowired
    private IUserService userService;
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid UserRegister userRegister) {
        return new ResponseEntity<>(userService.register(userRegister), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLogin userLogin) {
        JwtResponse jwtResponse = userService.login(userLogin);
        return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
    }

}
