package com.ra.controller.admin;

import com.ra.model.dto.request.ProductRequest;
import com.ra.model.dto.response.UserResponse;
import com.ra.model.entity.Product;
import com.ra.model.entity.Role;
import com.ra.model.entity.User;
import com.ra.service.auth.IRoleService;
import com.ra.service.auth.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/v1/admin")
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;
    @GetMapping("/users")
    public ResponseEntity<?> getAll(
            @RequestParam(defaultValue = "5",name = "limit") int limit,
            @RequestParam(defaultValue = "0",name = "page") int page,
            @RequestParam(defaultValue = "userName",name = "sort") String sort,
            @RequestParam(defaultValue = "asc",name = "order") String order
    ){
        Pageable pageable;
        if(order.equals("asc")){
            pageable = PageRequest.of(page,limit, Sort.by(sort).ascending());
        } else {
            pageable = PageRequest.of(page,limit, Sort.by(sort).descending());
        }
        Page<UserResponse> users = userService.getAll(pageable);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping("/search/{fullName}")
    public ResponseEntity<?> getByFullName(@PathVariable String fullName) {
        List<User> users = userService.findByFullName(fullName);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping("/roles")
    public ResponseEntity<?> getAllPermission() {
        List<Role> roles = roleService.getAll();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @PutMapping("users/{id}")
    public ResponseEntity<?> unlockOrLockUser(@PathVariable Long id){
        LocalDateTime now = LocalDateTime.now();
        User user = userService.findById(id);
        if ( user != null){
            user.setStatus(!user.getStatus());
            user.setUpdatedAt(now);
            User userNew = userService.save(user);
            return new ResponseEntity<>(userNew, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }
}
