package com.ra.repository;

import com.ra.model.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface IOrderDetailRepository  {
//    @Query("select od from OrderDetail od where od.orders.orderId = :orderId")
//    List<OrderDetail> findByOrderId(Long orderId);
}