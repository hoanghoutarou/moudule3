package com.ra.controller.user;


import com.ra.model.dto.response.AddressResponse;
import com.ra.model.entity.Address;
import com.ra.service.address.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/user/addresses")
public class AddressController {
    @Autowired
    private IAddressService addressService;
    @GetMapping("")
    public ResponseEntity<?> getAll(
            @RequestParam(defaultValue = "5",name = "limit") int limit,
            @RequestParam(defaultValue = "0",name = "page") int page,
            @RequestParam(defaultValue = "AddressId",name = "sort") String sort,
            @RequestParam(defaultValue = "asc",name = "order") String order
    ){
        Pageable pageable ;
        if(order.equals("asc")){
            pageable = PageRequest.of(page,limit, Sort.by(sort).ascending());
        } else {
            pageable = PageRequest.of(page,limit, Sort.by(sort).descending());
        }
        Page<AddressResponse> addresses = addressService.getAll(pageable);
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody  Address address) {
        address.setFullAddress(address.getFullAddress());
        address.setPhone(address.getPhone());
        address.setReceiveName(address.getReceiveName());
        address.setUser(address.getUser());
        Address addressNew = addressService.save(address);
        return new ResponseEntity<>(addressNew, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Address addressUpdate = addressService.findById(id);
        return new ResponseEntity<>(addressUpdate, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Address address ,@PathVariable Long id) {
        address.setAddressId(id);
        address.setFullAddress(address.getFullAddress());
        address.setPhone(address.getPhone());
        address.setReceiveName(address.getReceiveName());
        address.setUser(address.getUser());
        Address addressUpdate = addressService.save(address);
        return new ResponseEntity<>(addressUpdate, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        addressService.delete(id);
        return new ResponseEntity<>("Đã xóa", HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/deleteAll/{userId}")
    public ResponseEntity<?> deletebyUserId(@PathVariable Long userId) {

        addressService.deleteAllByUserID(userId);
        return new ResponseEntity<>("Đã xóa", HttpStatus.NO_CONTENT);
    }
}
