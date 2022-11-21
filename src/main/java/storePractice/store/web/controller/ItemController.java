package storePractice.store.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import storePractice.store.domain.Item;
import storePractice.store.service.ItemService;



@Controller
public class ItemController {
    private ItemService itemService;

    @DeleteMapping(value = "api/items/{itemId}}")
    public void delete(@PathVariable Long itemId) {
        itemService.deleteItem(itemId);
    }

    @PostMapping(value = "api/items")
    public Item create(@RequestBody Item item) {
        Item.builder()
                .Id(item.getId())
                .name(item.getName())
                .itemType(item.getItemType())
                .cpuCapacity(item.getCpuCapacity())
                .hardDisk(item.getHardDisk())
                .build();
        return itemService.createItem(item);

    }
}
