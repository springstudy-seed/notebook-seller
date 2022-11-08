package seed.notebookseller.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import seed.notebookseller.domain.Store;

@RequiredArgsConstructor
@RestController
public class StoreController {
    private final StoreService storeService;
    @PostMapping("/api/store")
    public boolean createStore(Store store){
        storeService.createStore(store);
        return true;
    }

}
