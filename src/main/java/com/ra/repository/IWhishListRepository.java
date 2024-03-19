package com.ra.repository;

import com.ra.model.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWhishListRepository extends JpaRepository<WishList,Long> {
}
