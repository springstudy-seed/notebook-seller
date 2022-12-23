package storePractice.store.domain;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class OrderItemPersistenceAdapter implements OrderItemOutPort {

    private final OrderItemRepository orderItemRepository;

    public List<OrderItem> findByItem(Item item){
        return orderItemRepository.findByItem(item);
    }
}
