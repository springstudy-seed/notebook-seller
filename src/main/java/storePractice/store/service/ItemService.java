package storePractice.store.service;

import storePractice.store.domain.Item;

import java.util.List;

public interface ItemService {
    public void deleteItem(Long itemId);

    public Item createItem(Item item);

    public List<Item> getByName(String name);

    public List<Item> getByType(String type);

    public List<Item> getByBetweenPrice(Integer minPrice, Integer maxPrice);
}
