package storePractice.store.web.controller;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import storePractice.store.domain.Store;
import storePractice.store.service.StoreService;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class StoreController {

    private StoreService storeService;

    @DeleteMapping(value = "/api/store/{store}")
    public void delete(@PathVariable Long storeId){
        storeService.deleteStore(storeId);
    }


    @PostMapping(value = "/api/store")
    public void save(@RequestBody Store store){
        Store.builder()
                .Id(store.getId())
                .name(store.getName())
                .location(store.getLocation())
                .member(store.getMember())
                .storeItem(store.getStoreItem())
                .build();

        storeService.saveStore(store);
    }
    @GetMapping("/api/store/")
    public ResponseEntity<List<Store>> findByName(String name){
        List<Store> stores = storeService.findByName(name);
        if(stores.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(stores, HttpStatus.OK);
    }

}
