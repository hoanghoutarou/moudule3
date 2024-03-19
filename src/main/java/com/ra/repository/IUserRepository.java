package com.ra.repository;

import com.ra.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IUserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUserName(String userName);
    boolean existsByUserName(String username);
    List<User> findAllByFullNameContainingIgnoreCase(String fullName);

//    @Query("UPDATE User u SET u.updated_at= now()")
//    void updateLogTimeByUserName(String userName);

}
