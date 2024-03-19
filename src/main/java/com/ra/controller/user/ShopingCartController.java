package com.ra.controller.user;

import com.ra.model.dto.request.ProductRequest;
import com.ra.model.dto.request.ShopingCartRequest;
import com.ra.model.dto.response.ProductResponse;
import com.ra.model.dto.response.ShopingCartResponse;
import com.ra.model.entity.Address;
import com.ra.model.entity.Orders;
import com.ra.model.entity.Product;
import com.ra.model.entity.ShopingCart;
import com.ra.service.address.IAddressService;
import com.ra.service.orderI.IOrderDetailService;
import com.ra.service.orderI.IOrderService;
import com.ra.service.product.IProductService;
import com.ra.service.shopingCart.IShopingCartService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.ra.controller.user.AccountController.getUserId;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/user/shopping-cart")
public class ShopingCartController {
    @Autowired
    private IShopingCartService shopingCartService;
    @Autowired
    private IAddressService addressService;
    @Autowired
    private IOrderService orderService;
//    @Autowired
//    private IOrderDetailService orderDetailService;
    @GetMapping("")
    public ResponseEntity<?> getAll(
            @RequestParam(defaultValue = "5",name = "limit") int limit,
            @RequestParam(defaultValue = "0",name = "page") int page,
            @RequestParam(defaultValue = "shopingCartId",name = "sort") String sort,
            @RequestParam(defaultValue = "desc",name = "order") String order
    ){
        Pageable pageable ;
        if(order.equals("asc")){
            pageable = PageRequest.of(page,limit, Sort.by(sort).ascending());
        } else {
            pageable = PageRequest.of(page,limit, Sort.by(sort).descending());
        }
        Page<ShopingCartResponse> shopingCarts = shopingCartService.getAll(pageable);
        return new ResponseEntity<>(shopingCarts, HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<?> AddProduct(@RequestBody @Valid ShopingCartRequest shopingCartRequest) {
        ShopingCart shopingCart = new ShopingCart();
        shopingCart.setUser(shopingCartRequest.getUser());
        shopingCart.setProduct(shopingCartRequest.getProduct());
        shopingCart.setOrderQuantity(shopingCartRequest.getOrderQuantity());
        ShopingCart shopingCartNew = shopingCartService.save(shopingCart);
        return new ResponseEntity<>(shopingCartNew, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrderQuantity(@RequestBody @Valid ShopingCartRequest shopingCartRequest ,@PathVariable Long id) {
        ShopingCart shopingCart = shopingCartService.findById(id);
        shopingCart.setOrderQuantity(shopingCartRequest.getOrderQuantity());
        ShopingCart shopingCartUpdate = shopingCartService.save(shopingCart);
        return new ResponseEntity<>(shopingCartUpdate, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        shopingCartService.deleteProductInCart(id);
        return new ResponseEntity<>("Đã xóa", HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("")
    public ResponseEntity<?> deleteAll() {
        shopingCartService.deleteAll();
        return new ResponseEntity<>("Đã xóa", HttpStatus.NO_CONTENT);
    }
//    @PostMapping("/checkout")
//    public ResponseEntity<String> checkOut() {
//        Long userId = getUserId();
//        List<ShopingCart> shopingCarts = shopingCartService.getAll(userId);
//
//        List<Address> listAddress = addressService.getAll(userId);
//
//        Address address = listAddress.get(0);
//
//        if (shopingCarts.isEmpty()) {
//            return new ResponseEntity<>("giỏ hàng trống", HttpStatus.BAD_REQUEST);
//        }
//
//        double totalPrice = shopingCarts.stream()
//                .mapToDouble(shopingCart -> shopingCart.getProduct().getUnitPrice())
//                .sum();
//
//        Orders order = orderService.add(address, totalPrice);
//
//        for (ShopingCart shopingCart: shopingCarts) {
//            int orderQuantity = shopingCart.getOrderQuantity();
//            Product product = shopingCart.getProduct();
//            orderDetailService.add(product, order, orderQuantity);
//        }
//
//        return new ResponseEntity<>("đặt hàng thành công!", HttpStatus.OK);
//    }
}
