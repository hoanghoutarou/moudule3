package com.ra.model.dto.response;

import com.ra.model.entity.Product;
import com.ra.model.entity.ShopingCart;
import com.ra.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ShopingCartResponse {
    private Long shopingCartId;
    private int orderQuantity;
    private User user;
    private Product product;

    public ShopingCartResponse(ShopingCart shopingCart) {
        this.shopingCartId = shopingCart.getShopingCartId();
        this.orderQuantity = shopingCart.getOrderQuantity();
        this.user = shopingCart.getUser();
        this.product = shopingCart.getProduct();
    }
}
