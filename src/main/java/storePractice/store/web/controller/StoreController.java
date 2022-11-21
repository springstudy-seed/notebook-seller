package storePractice.store.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import storePractice.store.domain.Store;
import storePractice.store.service.StoreService;


@Controller
@RequiredArgsConstructor
public class StoreController {

    private StoreService storeService;

    @GetMapping(value = "api/stores/{store}")
    public void delete(@PathVariable Long storeId){
        storeService.deleteStore(storeId);
    }


    @PostMapping(value = "api/stores")
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
}
