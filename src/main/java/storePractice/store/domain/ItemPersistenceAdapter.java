package storePractice.store.domain;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ItemPersistenceAdapter implements ItemOutPort, ItemInPort{
    private final ItemRepository itemRepository;
    public Item save(Item item){
        return itemRepository.save(item);
    }

    public void delete(Long itemId){
        itemRepository.delete(itemId);
    }

    public List<Item> findByName(String name){
        return itemRepository.findByName(name);
    }

    public List<Item> findByItemType(ItemType itemType){
        return itemRepository.findByItemType(itemType);
    }

    public List<Item>findAll(){
        return itemRepository.findAll();
    }

}
