package storePractice.store.service;

import storePractice.store.domain.Item;
import storePractice.store.domain.ItemType;
import storePractice.store.domain.Order;
import storePractice.store.domain.OrderItem;

import java.util.List;

public interface OrderService {
    public Order createOrder(String name);
}
