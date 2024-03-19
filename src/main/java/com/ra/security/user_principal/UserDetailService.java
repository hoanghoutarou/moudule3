package com.ra.security.user_principal;

import com.ra.model.entity.User;
import com.ra.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    private IUserRepository IUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = IUserRepository.findByUserName(username);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            UserPrincipal userPrincipal = UserPrincipal.builder().
                    user(user).authorities(user.getRoles().stream().map(
                            item->new SimpleGrantedAuthority(item.getName())
                    ).toList()).build();
            return userPrincipal;
        }
        return null;
    }
}
