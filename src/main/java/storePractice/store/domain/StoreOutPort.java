package storePractice.store.domain;

import java.util.List;

public interface StoreOutPort {

    public List<Store> findByName(String name);
}
