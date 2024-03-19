package com.ra.repository;

import com.ra.model.entity.Address;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
@Transactional

public interface IAddressRepository extends JpaRepository<Address,Long> {
    @Modifying
    @Query(value = "DELETE FROM Address a WHERE a.user.id= ?1")


    void clearAllByUserId(Long userId);
}
