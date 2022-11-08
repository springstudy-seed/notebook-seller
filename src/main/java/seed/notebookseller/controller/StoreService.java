package seed.notebookseller.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seed.notebookseller.domain.Store;
import seed.notebookseller.domain.StoreRepository;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;
    public Store createStore(Store store){
        Store save = storeRepository.save(store);
        return save;
    }
}
