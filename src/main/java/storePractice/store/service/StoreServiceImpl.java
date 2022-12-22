package storePractice.store.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import storePractice.store.domain.Store;
import storePractice.store.domain.StoreInPort;
import storePractice.store.domain.StoreOutPort;
import storePractice.store.domain.StoreRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class StoreServiceImpl {
    private final StoreInPort storeInPort;
    private final StoreOutPort storeOutPort;
    public void saveStore(Store store){
        storeInPort.save(store);
    }

    public void deleteStore(String name){
        Store store = storeOutPort.findByName(name).get(0);
        storeInPort.delete(store);
    }

    public List<Store> findByName(String name) {
        List<Store> stores = storeOutPort.findByName(name);
        if(stores.isEmpty()){
            return null;
        }
        return stores;
    }
}
