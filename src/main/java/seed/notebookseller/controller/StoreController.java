package seed.notebookseller.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import seed.notebookseller.domain.DepositByStoreDto;
import seed.notebookseller.domain.Store;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class StoreController {
    private final StoreService storeService;

    @PostMapping("/api/stores")
    public ResponseEntity<Store> createStore(@RequestBody Store store) {

        Store createdStore = storeService.createStore(store);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(createdStore.getId())
                .toUri();
        return ResponseEntity.created(uri)
                .body(createdStore);
    }

    @GetMapping("/api/stores/{id}/deposits")
    public List<DepositByStoreDto> findDepositByStore(@PathVariable("id") Long storeId) {
        return storeService.findDepositByStore(storeId);
    }
}
