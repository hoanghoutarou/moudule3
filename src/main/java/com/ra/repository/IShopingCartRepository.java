package com.ra.repository;

import com.ra.model.entity.ShopingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IShopingCartRepository extends JpaRepository<ShopingCart,Long> {
}
