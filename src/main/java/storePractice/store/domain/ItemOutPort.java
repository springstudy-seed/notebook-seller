package storePractice.store.domain;

import java.util.List;

public interface ItemOutPort {
    public List<Item> findByName(String name);

    public List<Item> findByItemType(ItemType itemType);

    public List<Item>findAll();

}
