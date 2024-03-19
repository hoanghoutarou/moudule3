package com.ra.controller.user;

import com.ra.model.dto.response.WhishListResponse;
import com.ra.model.entity.Address;
import com.ra.model.entity.WishList;
import com.ra.service.wishList.IWishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user/whish-list")
public class WhishListController {
    @Autowired
    private IWishListService wishListService;
    @GetMapping("")
    public ResponseEntity<?> getAll(
            @RequestParam(defaultValue = "5",name = "limit") int limit,
            @RequestParam(defaultValue = "0",name = "page") int page,
            @RequestParam(defaultValue = "wishListId",name = "sort") String sort,
            @RequestParam(defaultValue = "asc",name = "order") String order
    ){
        Pageable pageable ;
        if(order.equals("asc")){
            pageable = PageRequest.of(page,limit, Sort.by(sort).ascending());
        } else {
            pageable = PageRequest.of(page,limit, Sort.by(sort).descending());
        }
        Page<WhishListResponse>  wishList = wishListService.getAll(pageable);
        return new ResponseEntity<>(wishList, HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody WishList wishList) {
        wishList.setUser(wishList.getUser());
        wishList.setProduct(wishList.getProduct());
        WishList wishListNew = wishListService.save(wishList);
        return new ResponseEntity<>(wishListNew, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        WishList wishListUpdate = wishListService.findById(id);
        return new ResponseEntity<>(wishListUpdate, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody WishList wishList ,@PathVariable Long id) {
        wishList.setWishListId(id);
        wishList.setProduct(wishList.getProduct());
        wishList.setUser(wishList.getUser());
        WishList wishListUpdate = wishListService.save(wishList);
        return new ResponseEntity<>(wishListUpdate, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        wishListService.delete(id);
        return new ResponseEntity<>("Đã xóa", HttpStatus.NO_CONTENT);
    }
}
