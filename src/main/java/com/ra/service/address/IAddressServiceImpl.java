package com.ra.service.address;

import com.ra.model.dto.response.AddressResponse;
import com.ra.model.entity.Address;
import com.ra.repository.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IAddressServiceImpl implements IAddressService {
    @Autowired
    private IAddressRepository addressRepository;

    @Override
    public List<Address> getAll(Long userId) {
        return addressRepository.findAll();
    }

    @Override
    public Page<AddressResponse> getAll(Pageable pageable) {
        Page<Address> addresses = addressRepository.findAll(pageable);
        return addresses.map(AddressResponse::new);
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address findById(Long id) {
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteAllByUserID(Long userId) {
        addressRepository.clearAllByUserId(userId);
    }


    @Override
    public void delete(Long id) {
        addressRepository.deleteById(id);
    }
}
