package storePractice.store.domain;

import java.util.List;

public interface StoreInPort {

    public Store save(Store store);

    public void delete(Store store);
}
