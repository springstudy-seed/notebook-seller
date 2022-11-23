package storePractice.store.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import storePractice.store.domain.Item;
import storePractice.store.domain.ItemRepository;
import storePractice.store.domain.ItemType;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public Item createItem(Item item){
        return itemRepository.save(item);
    }

    public void deleteItem(Long itemId){
        itemRepository.delete(itemId);
    }

    public List<Item> getByName(String name) {
        List<Item> items = itemRepository.findByName(name);
        if(items.equals(null)){
            return null;
        }
        return items;
    }

    public List<Item> getByType(String type) {
        ItemType itemType = ItemType.valueOf(type);
        List<Item> items = itemRepository.findByItemType(itemType);
        if (items.equals(null)){
            return null;
        }
        return items;
    }

    public List<Item> getByBetweenPrice(Integer minPrice, Integer maxPrice) {
        List<Item> all = itemRepository.findAll();
        return all.stream()
                .filter(item -> (item.getPrice() > minPrice && item.getPrice() < maxPrice)).collect(Collectors.toList());
    }
}
