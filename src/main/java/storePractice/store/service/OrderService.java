package storePractice.store.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import storePractice.store.domain.*;
import storePractice.store.domain.OrderItemRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;

    private final OrderItemRepository orderItemRepository;

    public Order createOrder(String name) {
        // item 객체를 주워와야 함

        Item item = itemRepository.findByName(name).orElseThrow(() -> new IllegalArgumentException("있는걸 찾으라고!!"));
        //         item 으로 OrderItem을 조회

        List<OrderItem> byItem = orderItemRepository.findByItem(item);

        Order order = orderRepository.findByOrderItem(byItem).orElseThrow(() -> new IllegalArgumentException("해당하는 주문 없음"));
        return orderRepository.save(order);

    }
}