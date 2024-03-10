package com.dxccode.orderservice.services;
import com.dxccode.orderservice.model.OrderInfo;
import com.dxccode.orderservice.model.OrderInfoDto;
import com.dxccode.orderservice.repo.FoodRepository;
import com.dxccode.orderservice.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final FoodRepository foodRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, FoodRepository foodRepository) {
        this.orderRepository = orderRepository;
        this.foodRepository = foodRepository;
    }


//    public Page<OrderInfo> saveOrdersByRestaurantId(String restaurantId, List<OrderInfo> orderInfoList, Pageable pageable) {
//        for (OrderInfo orderInfo : orderInfoList) {
//            orderInfo.setRestaurantId(restaurantId);
//        }
//        List<OrderInfo> savedOrders = orderRepository.saveAll(orderInfoList);
//        return new PageImpl<>(savedOrders, pageable, savedOrders.size());
//    }

    public List<OrderInfo> saveOrdersByRestaurantId(String restaurantId, List<OrderInfo> orderInfoList) {
        for (OrderInfo orderInfo : orderInfoList) {
            orderInfo.setRestaurantId(restaurantId);
        }
        return orderRepository.saveAll(orderInfoList);
    }

    @Override
    public List<OrderInfo> saveOrderInfos(List<OrderInfo> orderInfoList) {
        List<OrderInfo> savedOrders = orderRepository.saveAll(orderInfoList);
        return savedOrders;
    }

//    @Override
//    public List<OrderInfo> showOrdersByRestaurant(String restaurantId) {
//        List<OrderInfo> orders = orderRepository.findByRestaurantId(restaurantId);
//        return orders;
//    }
//

//    @Override
//    public List<OrderInfo> saveOrderInfos(List<OrderInfo> orderInfoList) {
//        List<OrderInfo> savedOrderInfoList = new ArrayList<>();
//        for (OrderInfo orderInfo : orderInfoList) {
//            savedOrderInfoList.add(orderRepository.save(orderInfo));
//        }
//        return savedOrderInfoList;
//    }

    @Override
    public List<OrderInfo> showOrdersByRestaurant(String restaurantId) {
        return orderRepository.findByRestaurantId(restaurantId);
    }

//    @Override
//    public Page<OrderInfo> saveOrderInfos(List<OrderInfo> orderInfoList, Pageable pageable) {
//        List<OrderInfo> savedOrderInfoList = new ArrayList<>();
//        for (OrderInfo orderInfo : orderInfoList) {
//            savedOrderInfoList.add(orderRepository.save(orderInfo));
//        }
//        return new PageImpl<>(savedOrderInfoList, pageable, savedOrderInfoList.size());
//    }
//    @Override
//    public Page<OrderInfo> showOrdersByRestaurant(String restaurantId, Pageable pageable) {
//        return orderRepository.findByRestaurantId(restaurantId, pageable);
//    }

    @Override
    public OrderInfo findFirstByOrderId(String orderId) {
        return orderRepository.findFirstByOrderId(orderId);
    }

    @Override
    public void updateOrderStatus(String orderId, OrderInfo.OrderStatus orderStatus) {
        OrderInfo orderInfo = findFirstByOrderId(orderId);
        orderInfo.setOrderStatus(orderStatus);
        orderRepository.save(orderInfo);
    }

    @Override
    public void deleteOrder(String orderId) {
        orderRepository.deleteByOrderId(orderId);
    }

    @Override
    public OrderInfoDto showOrderConfirmation(String orderId) {
        // Your implementation here
        return null;
    }
}

