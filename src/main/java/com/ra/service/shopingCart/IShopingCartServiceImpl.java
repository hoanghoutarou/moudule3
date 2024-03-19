package com.ra.service.shopingCart;

import com.ra.model.dto.response.AddressResponse;
import com.ra.model.dto.response.ShopingCartResponse;
import com.ra.model.entity.Address;
import com.ra.model.entity.ShopingCart;
import com.ra.repository.IShopingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IShopingCartServiceImpl implements IShopingCartService{
    @Autowired
    private IShopingCartRepository shopingCartRepository;
    @Override
    public Page<ShopingCartResponse> getAll(Pageable pageable) {
        Page<ShopingCart> shopingCarts = shopingCartRepository.findAll(pageable);
        return shopingCarts.map(ShopingCartResponse::new);
    }

    @Override
    public ShopingCart save(ShopingCart shopingCart) {
        return shopingCartRepository.save(shopingCart);
    }

    @Override
    public ShopingCart findById(Long id) {
        return shopingCartRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteProductInCart(Long id) {
        shopingCartRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        shopingCartRepository.deleteAll();
    }
}
