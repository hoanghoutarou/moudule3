package com.ra.model.dto.response;

import com.ra.model.entity.Product;
import com.ra.model.entity.User;
import com.ra.model.entity.WishList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class WhishListResponse {
    private Long wishListId;
    private User user;
    private Product product;

    public WhishListResponse(WishList wishList) {
        this.wishListId = wishList.getWishListId();
        this.user = wishList.getUser();
        this.product = wishList.getProduct();
    }
}
