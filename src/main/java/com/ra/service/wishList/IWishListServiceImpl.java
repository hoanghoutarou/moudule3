package com.ra.service.wishList;

import com.ra.model.dto.response.AddressResponse;
import com.ra.model.dto.response.WhishListResponse;
import com.ra.model.entity.Address;
import com.ra.model.entity.WishList;
import com.ra.repository.IAddressRepository;
import com.ra.repository.IWhishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class IWishListServiceImpl implements IWishListService{
    @Autowired
    private IWhishListRepository whishListRepository;
    @Override
    public Page<WhishListResponse> getAll(Pageable pageable) {
        Page<WishList> wishLists = whishListRepository.findAll(pageable);
        return wishLists.map(WhishListResponse::new);
    }

    @Override
    public WishList save(WishList wishList) {
        return whishListRepository.save(wishList);
    }

    @Override
    public WishList findById(Long id) {
        return whishListRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        whishListRepository.deleteById(id);
    }
}
