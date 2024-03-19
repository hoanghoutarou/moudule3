package com.ra.model.dto.response;

import com.ra.model.entity.Address;
import com.ra.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AddressResponse {
    private Long addressId;
    private String fullAddress;
    private String phone;
    private String receiveName;
    private User user;

    public AddressResponse(Address address) {
        this.addressId = address.getAddressId();
        this.fullAddress = address.getFullAddress();
        this.phone = address.getPhone();
        this.receiveName = address.getReceiveName();
        this.user = address.getUser();
    }
}
