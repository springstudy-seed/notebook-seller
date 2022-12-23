package storePractice.store.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
    @Modifying
    @Query("delete from Item i where i.id=:itemId")
    void delete(@Param("itemId")Long itemId);

    List<Item> findByName(String name);

    List<Item> findByItemType(ItemType type);
}