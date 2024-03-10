package com.dxccode.orderservice.services;

import com.dxccode.orderservice.model.OrderInfo;
        import com.dxccode.orderservice.model.OrderInfoDto;
        import org.springframework.data.domain.Page;
        import org.springframework.data.domain.Pageable;

        import java.util.List;

public interface OrderService {
    List<OrderInfo> saveOrdersByRestaurantId(String restaurantId, List<OrderInfo> orderInfoList);

   // Page<OrderInfo> saveOrderInfos(List<OrderInfo> orderInfoList, Pageable pageable);

    List<OrderInfo> saveOrderInfos(List<OrderInfo> orderInfoList);
    //Page<OrderInfo> showOrdersByRestaurant(String restaurantId, Pageable pageable);
    List<OrderInfo> showOrdersByRestaurant(String restaurantId);

    OrderInfo findFirstByOrderId(String orderId);

    void updateOrderStatus(String orderId, OrderInfo.OrderStatus orderStatus);

    void deleteOrder(String orderId);

    OrderInfoDto showOrderConfirmation(String orderId);
}
