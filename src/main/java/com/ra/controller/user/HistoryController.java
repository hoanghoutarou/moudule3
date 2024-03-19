package com.ra.controller.user;

import com.ra.model.dto.response.AddressResponse;
import com.ra.model.dto.response.OrderResponse;
import com.ra.model.entity.Address;
import com.ra.model.entity.Orders;
import com.ra.service.orderI.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user/history")
public class HistoryController {
    @Autowired
    private IOrderService orderService;
    @GetMapping("")
    public ResponseEntity<?> getAll(
            @RequestParam(defaultValue = "5",name = "limit") int limit,
            @RequestParam(defaultValue = "0",name = "page") int page,
            @RequestParam(defaultValue = "orderId",name = "sort") String sort,
            @RequestParam(defaultValue = "asc",name = "order") String order
    ){
        Pageable pageable ;
        if(order.equals("asc")){
            pageable = PageRequest.of(page,limit, Sort.by(sort).ascending());
        } else {
            pageable = PageRequest.of(page,limit, Sort.by(sort).descending());
        }
        Page<OrderResponse> orders = orderService.getAll(pageable);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
    @GetMapping("/{serialNumber}")
    public ResponseEntity<?> getBySerial(@PathVariable String serialNumber) {
        Orders orderUpdate = orderService.findBySerialNumber(serialNumber);
        if (orderUpdate == null) {
            return new ResponseEntity<>("không tìm thấy đơn hàng của bạn",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(orderUpdate, HttpStatus.OK);
    }

}
