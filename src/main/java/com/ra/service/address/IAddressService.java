package com.ra.service.address;

import com.ra.model.dto.response.AddressResponse;
import com.ra.model.dto.response.ProductResponse;
import com.ra.model.entity.Address;
import com.ra.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAddressService {
    List<Address> getAll(Long userId);

    Page<AddressResponse> getAll(Pageable pageable);
    Address save(Address address);
    Address findById(Long id);
    void deleteAllByUserID(Long userId);
    void delete(Long id);
}
