package com.ra.service.shopingCart;

import com.ra.model.dto.response.ShopingCartResponse;
import com.ra.model.entity.ShopingCart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IShopingCartService {
    Page<ShopingCartResponse> getAll(Pageable pageable);
    ShopingCart save(ShopingCart shopingCart);
    ShopingCart findById(Long id);
    void deleteProductInCart(Long id);
    void deleteAll();

}
