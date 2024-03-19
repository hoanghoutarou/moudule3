package com.ra.service.wishList;


import com.ra.model.dto.response.WhishListResponse;
import com.ra.model.entity.WishList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IWishListService {
    Page<WhishListResponse> getAll(Pageable pageable);
    WishList save(WishList wishList);
    WishList findById(Long id);
    void delete(Long id);
}
