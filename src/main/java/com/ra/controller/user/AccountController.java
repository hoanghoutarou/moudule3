package com.ra.controller.user;

import com.ra.model.dto.request.CategoryRequest;
import com.ra.model.entity.Category;
import com.ra.model.entity.User;
import com.ra.model.entity.WishList;
import com.ra.security.user_principal.UserPrincipal;
import com.ra.service.auth.IUserService;
import com.ra.service.auth.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/v1/user/accounts")
public class AccountController {
    @Autowired
    private IUserService userService;
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        User userUpdate = userService.findById(id);
        return new ResponseEntity<>(userUpdate, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUserAccount(@RequestBody User user, @PathVariable Long id) {
        user.setId(id);
        LocalDateTime now = LocalDateTime.now();
        user.setUserName(user.getUserName());
        user.setPassword(user.getPassword());
        user.setFullName(user.getFullName());
        user.setEmail(user.getEmail());
        user.setPhone(user.getPhone());
        user.setAddress(user.getAddress());
        user.setUpdatedAt(now);
        User userUpdate = userService.save(user);
        return new ResponseEntity<>(userUpdate, HttpStatus.OK);
    }
    public static Long getUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        return userPrincipal.getUser().getId();
    }
}
