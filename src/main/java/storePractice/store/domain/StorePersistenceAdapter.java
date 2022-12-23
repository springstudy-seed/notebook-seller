package storePractice.store.domain;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class StorePersistenceAdapter implements StoreInPort, StoreOutPort {
    private StoreRepository storeRepository;

    public Store save(Store store){
        return storeRepository.save(store);
    }

    public void delete(Store store){
        storeRepository.delete(store);
    }

    @Override
    public List<Store> findByName(String name) {
        return storeRepository.findByName(name);
    }
}
