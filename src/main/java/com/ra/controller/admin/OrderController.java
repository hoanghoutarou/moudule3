package com.ra.controller.admin;

import com.ra.model.dto.request.OrderRequest;
import com.ra.model.dto.request.ProductRequest;
import com.ra.model.dto.response.OrderResponse;
import com.ra.model.entity.Address;
import com.ra.model.entity.Orders;
import com.ra.model.entity.Product;
import com.ra.service.orderI.IOrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

//@RestController
//@RequestMapping("/v1/admin/orders")
public class OrderController {
//    @Autowired
//    private IOrderService orderService;
//    @GetMapping("")
//    public ResponseEntity<?> getAll(
//            @RequestParam(defaultValue = "5",name = "limit") int limit,
//            @RequestParam(defaultValue = "0",name = "page") int page,
//            @RequestParam(defaultValue = "orderId",name = "sort") String sort,
//            @RequestParam(defaultValue = "asc",name = "order") String order
//    ){
//        Pageable pageable ;
//        if(order.equals("asc")){
//            pageable = PageRequest.of(page,limit, Sort.by(sort).ascending());
//        } else {
//            pageable = PageRequest.of(page,limit, Sort.by(sort).descending());
//        }
//        Page<OrderResponse> orders = orderService.getAll(pageable);
//        return new ResponseEntity<>(orders, HttpStatus.OK);
//    }
//    @GetMapping("/{id}")
//    public ResponseEntity<?> getById(@PathVariable Long id) {
//        Orders orderUpdate = orderService.findById(id);
//        return new ResponseEntity<>(orderUpdate, HttpStatus.OK);
//    }
//    @PutMapping("/{id}/status")
//    public ResponseEntity<?> updateStatus(@RequestBody @Valid OrderRequest orderRequest , @PathVariable Long id) {
//        Orders orders = orderService.findById(id);
//        LocalDateTime now = LocalDateTime.now();
//        orders.setOrderId(id);
//        orders.setCreatedAt(now);
//        Orders ordersUpdate = orderService.save(orders);
//        return new ResponseEntity<>(ordersUpdate, HttpStatus.OK);
//    }
}
