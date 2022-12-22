package storePractice.store.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import storePractice.store.domain.*;
import storePractice.store.domain.OrderItemRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository;
    private final ItemOutPort itemOutPort;
    private final OrderItemRepository orderItemRepository;

    public Order createOrder(String name) {
        // item 객체를 주워와야 함

        Item item = itemOutPort.findByName(name).get(0);
        if(item == null) {
            throw new IllegalArgumentException("상품이 없습니다.");
        }
        //         item 으로 OrderItem을 조회

        List<OrderItem> orderItem = orderItemRepository.findByItem(item);

        Order order = orderRepository.findByOrderItem(orderItem).orElseThrow(() -> new IllegalArgumentException("해당하는 주문 없음"));
        return orderRepository.save(order);

    }
}