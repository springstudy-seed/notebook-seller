package storePractice.store.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import storePractice.store.domain.*;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService{
    private final ItemInPort itemInPort;
    private final ItemOutPort itemOutPort;
    public Item createItem(Item item){
        return itemInPort.save(item);
    }

    public void deleteItem(Long itemId){
        itemInPort.delete(itemId);
    }

    public List<Item> getByName(String name) {
        List<Item> items = itemOutPort.findByName(name);
        if(items.equals(null)){
            return null;
        }
        return items;
    }

    public List<Item> getByType(String type) {
        ItemType itemType = ItemType.valueOf(type);
        List<Item> items = itemOutPort.findByItemType(itemType);
        if (items.equals(null)){
            return null;
        }
        return items;
    }

    public List<Item> getByBetweenPrice(Integer minPrice, Integer maxPrice) {
        List<Item> all = itemOutPort.findAll();
        return all.stream()
                .filter(item -> (item.getPrice() > minPrice && item.getPrice() < maxPrice)).collect(Collectors.toList());
    }
}
