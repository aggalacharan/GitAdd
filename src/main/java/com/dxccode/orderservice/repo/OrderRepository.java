package com.dxccode.orderservice.repo;

import com.dxccode.orderservice.model.OrderInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface OrderRepository extends JpaRepository<OrderInfo,Long>{
//    Page<OrderInfo> findByRestaurantId(String restaurantId, Pageable pageable);
//    Page<OrderInfo> findByUserName(String userName, Pageable pageable);


    List<OrderInfo> findListByRestaurantId(String restaurantId);

    List<OrderInfo> findListByUserName(String userName);
    OrderInfo findFirstByOrderId(String orderId);
    void deleteByOrderId(String orderId);

    List<OrderInfo> findByRestaurantId(String restaurantId);
}
