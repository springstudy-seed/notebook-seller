package storePractice.store.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import storePractice.store.domain.Order;
import storePractice.store.service.OrderService;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    @PostMapping("/api/order")
    public ResponseEntity<Order> createOrder(String name){
        Order order = orderService.createOrder(name);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}