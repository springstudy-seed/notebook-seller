package storePractice.store.service;

import storePractice.store.domain.Store;

import java.util.List;

public interface StoreService {
    public void saveStore(Store store);
    public void deleteStore(Long storeId);
    public List<Store> findByName(String name);
}
