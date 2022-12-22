package storePractice.store.domain;

import java.util.List;
import java.util.Optional;

public interface OrderOutPort {

    public Optional<Order> findByOrderItem(List<OrderItem> orderItem);
}
