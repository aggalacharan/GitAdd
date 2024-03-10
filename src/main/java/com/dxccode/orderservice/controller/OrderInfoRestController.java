package com.dxccode.orderservice.controller;

import com.dxccode.orderservice.model.OrderInfo;
import com.dxccode.orderservice.model.OrderInfoDto;
import com.dxccode.orderservice.services.OrderService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RestController
@RequestMapping("/v1")
public class OrderInfoRestController {

        private  OrderService orderService;
        @Autowired
        public OrderInfoRestController(OrderService orderService) {
            this.orderService = orderService;
        }


    @PostMapping("/restaurant/{restaurantId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<List<OrderInfo>> saveOrdersByRestaurantId(@PathVariable String restaurantId,
            @RequestBody List<OrderInfo> orderInfoList) {
        List<OrderInfo> savedOrders = (List<OrderInfo>) orderService.saveOrdersByRestaurantId(restaurantId, orderInfoList);
        return ResponseEntity.ok().body(savedOrders);
    }


    @PostMapping("/all")
    public ResponseEntity<List<OrderInfo>> saveOrders(@RequestBody List<OrderInfo> orderInfoList) {
        List<OrderInfo> savedOrders = orderService.saveOrderInfos(orderInfoList);
        return ResponseEntity.ok().body(savedOrders);
    }


  @GetMapping("/{restaurantId}/order")
  public List<OrderInfo> viewOrdersByRestaurant(@PathVariable String restaurantId) {
     return orderService.showOrdersByRestaurant(restaurantId);
  }


    @GetMapping("/order/{orderId}")
        public OrderInfoDto viewOrderConfirmation(@PathVariable String orderId) {
            OrderInfo orderInfo = orderService.findFirstByOrderId(orderId);
            if (orderInfo != null && orderInfo.getOrderStatus().equals(OrderInfo.OrderStatus.Paid)) {
                return orderService.showOrderConfirmation(orderId);
            }
            return null;
        }

        @PutMapping("/order/{orderId}")
        public void updateOrderStatus(@PathVariable String orderId, @RequestBody OrderInfo.OrderStatus orderStatus){
            orderService.updateOrderStatus(orderId, orderStatus);
        }

        @DeleteMapping("/order/{orderId}")
        public void deleteOrder(@PathVariable String orderId) {
            orderService.deleteOrder(orderId);
        }
}