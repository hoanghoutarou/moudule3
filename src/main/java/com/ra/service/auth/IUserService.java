package com.ra.service.auth;

import com.ra.model.dto.request.UserLogin;
import com.ra.model.dto.request.UserRegister;
import com.ra.model.dto.response.JwtResponse;
import com.ra.model.dto.response.UserResponse;
import com.ra.model.entity.Category;
import com.ra.model.entity.Product;
import com.ra.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
    String register(UserRegister userRegister);
    JwtResponse login(UserLogin userLogin);
    Page<UserResponse> getAll(Pageable pageable);
    Page<UserResponse> getAllUserPhone(Pageable pageable);
    List<User> findByFullName(String fullName);
    User findById(Long id);

    User save(User user);
    User updateAcc(UserRegister userRegister, Long id);


    void deletePermision(Long id);

}
