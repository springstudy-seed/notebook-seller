package seed.notebookseller.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import seed.notebookseller.domain.Store;
import seed.notebookseller.domain.StoreRepository;

@SpringBootTest
class StoreServiceTest {
    @Autowired
    StoreService storeService;
    @Autowired
    StoreRepository storeRepository;

    @Test
    void 가게_생성() {
        //given : 데이터
        Store store = Store.builder()
                .id(1L)
                .location("북구 용봉로77")
                .name("김수민")
                .build();
        //when : 기능
        Store saveStore = storeService.createStore(store);
        //then : 기대하는 값
        Assertions.assertTrue(saveStore.equals(store));
    }
}