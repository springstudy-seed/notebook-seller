package storePractice.store.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import storePractice.store.domain.Item;
import storePractice.store.domain.ItemRepository;

import java.util.Optional;

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
}
