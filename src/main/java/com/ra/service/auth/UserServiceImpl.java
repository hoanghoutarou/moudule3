package com.ra.service.auth;

import com.ra.model.dto.request.UserLogin;
import com.ra.model.dto.request.UserRegister;
import com.ra.model.dto.response.JwtResponse;
import com.ra.model.dto.response.UserResponse;
import com.ra.model.entity.Product;
import com.ra.model.entity.Role;
import com.ra.model.entity.User;
import com.ra.repository.ICategoryRepository;
import com.ra.repository.IRoleRepository;
import com.ra.repository.IUserRepository;
import com.ra.security.jwt.JwtProvider;
import com.ra.security.user_principal.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IRoleRepository IRoleRepository;
    @Autowired
    private AuthenticationProvider authenticationProvider;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public String register(UserRegister userRegister) {
        if(userRepository.existsByUserName(userRegister.getUserName())) {
            throw new RuntimeException("username is exists");
        }

        Set<Role> roles = new HashSet<>();
        roles.add(roleService.findByRoleName("ROLE_USER"));

        User users = User.builder()
                .fullName(userRegister.getFullName())
                .userName(userRegister.getUserName())
                .password(passwordEncoder.encode(userRegister.getPassword()))
                .email(userRegister.getEmail())
                .address(userRegister.getAddress())
                .phone(userRegister.getPhone())
                .createdAt(userRegister.getCreatedAt())
                .updatedAt(userRegister.getUpdatedAt())
                .status(true)
                .roles(roles)
                .build();
        userRepository.save(users);
        return "Success";
    }

    @Override
    public JwtResponse login(UserLogin userLogin) {
        Authentication authentication;
        try {
            authentication = authenticationProvider.
                    authenticate(new UsernamePasswordAuthenticationToken(userLogin.getUserName(),userLogin.getPassword()));
        } catch (AuthenticationException exception){
            throw new RuntimeException("username or password sai cmnr");
        }
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        // tạo ra 1 token
        String token = jwtProvider.generateToken(userPrincipal);


        // covernt sang doi tung UserResoine
        return JwtResponse.builder().
                fullName(userPrincipal.getUser().getFullName())
                .username(userPrincipal.getUser().getUserName())
                .email(userPrincipal.getUser().getEmail())
                .id(userPrincipal.getUser().getId()).token(token).
                roles(userPrincipal.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet())).
                build();
    }

    @Override
    public Page<UserResponse> getAll(Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable);
        return users.map(UserResponse::new);
    }

    @Override
    public Page<UserResponse> getAllUserPhone(Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable);

        return users.map(UserResponse::new);
    }

    @Override
    public List<User> findByFullName(String fullName) {
        return userRepository.findAllByFullNameContainingIgnoreCase(fullName);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateAcc(UserRegister userRegister, Long id) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        if(userRepository.existsByUserName(userRegister.getUserName())) {
            throw new RuntimeException("username is exists");
        }

        Set<Role> roles = findById(id).getRoles();

        User users = User.builder()
                .id(id)
                .fullName(userRegister.getFullName())
                .userName(userRegister.getUserName())
                .password(passwordEncoder.encode(userRegister.getPassword()))
                .email(userRegister.getEmail())
                .phone(userRegister.getPhone())
                .address(userRegister.getAddress())
                .status(true)
                .roles(roles)
                .build();
        return userRepository.save(users);
    }


    @Override
    public void deletePermision(Long id) {

    }
}
