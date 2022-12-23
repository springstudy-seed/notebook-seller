package storePractice.store.domain;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class OrderPersistenceAdapter implements OrderInPort, OrderOutPort{
    private final OrderRepository orderRepository;

    public Order save(Order order){
        return orderRepository.save(order);
    }

    public Optional<Order> findByOrderItem(List<OrderItem> orderItem){
        return orderRepository.findByOrderItem(orderItem);
    }
}
