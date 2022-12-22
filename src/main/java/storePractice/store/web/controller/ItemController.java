package storePractice.store.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import storePractice.store.domain.Item;
import storePractice.store.service.ItemServiceImpl;

import java.util.List;


@Controller
public class ItemController {
    private ItemServiceImpl itemService;

    @DeleteMapping(value = "api/items/{itemId}}")
    public void delete(@PathVariable Long itemId) {
        itemService.deleteItem(itemId);
    }

    @PostMapping(value = "api/items")
    public Item create(@RequestBody Item item) {
        Item.builder()
                .id(item.getId())
                .name(item.getName())
                .itemType(item.getItemType())
                .cpuCapacity(item.getCpuCapacity())
                .hardDisk(item.getHardDisk())
                .build();

        return itemService.createItem(item);

    }

    @GetMapping(value = "api/items/${name}")
    public ResponseEntity<List<Item>> getByName(@RequestParam String name){
        List<Item> items = itemService.getByName(name);
        if(items.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping(value = "/api/items/type")
    public ResponseEntity<List<Item>> getByType(String type){
        List<Item> items = itemService.getByType(type);
        if (items.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(items,HttpStatus.OK);
    }

    @GetMapping(value = "/api/items/price")
    public ResponseEntity<List<Item>> getByBetweenPrice(Integer minPrice, Integer maxPrice){
        List<Item> items = itemService.getByBetweenPrice(minPrice,maxPrice);
        if (items.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(items,HttpStatus.OK);
    }
}
