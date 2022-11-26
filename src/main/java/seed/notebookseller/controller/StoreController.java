package seed.notebookseller.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import seed.notebookseller.domain.DepositByStoreDto;
import seed.notebookseller.domain.Store;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class StoreController {
    private final StoreService storeService;
    @PostMapping("/api/store")
    public Store createStore(Store store){
        return storeService.createStore(store);
    }

    @GetMapping("/api/stores/{id}/deposits")
    public List<DepositByStoreDto> findDepositByStore(@PathVariable ("id") Long storeId){
        return storeService.findDepositByStore(storeId);
    }
}
