package storePractice.store.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
    @Modifying
    @Query("delete from Store s where s.Id=:storeId")
    void delete(@Param("storeId")Long storeId);

    List<Store> findByName(String name);

    Optional<Store> findById(Long id);
}
