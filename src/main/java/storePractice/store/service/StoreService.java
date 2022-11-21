package storePractice.store.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import storePractice.store.domain.Store;
import storePractice.store.domain.StoreRepository;


@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;

    public void saveStore(Store store){
        storeRepository.save(store);
    }

    public void deleteStore(Long storeId){
        Store store = storeRepository.findById(storeId)
                        .orElseThrow(()->new IllegalArgumentException("서점이 존재하지 않습니다"));
        storeRepository.delete(store);
    }
}
