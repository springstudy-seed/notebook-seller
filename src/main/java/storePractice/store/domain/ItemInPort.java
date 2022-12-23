package storePractice.store.domain;

import java.util.List;
import java.util.stream.Collectors;

public interface ItemInPort {
    public Item save(Item item);
    public void delete(Long itemId);
}
