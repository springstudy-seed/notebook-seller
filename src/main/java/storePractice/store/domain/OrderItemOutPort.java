package storePractice.store.domain;

import java.util.List;

public interface OrderItemOutPort {

    public List<OrderItem> findByItem(Item item);
}
