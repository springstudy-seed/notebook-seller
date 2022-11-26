package seed.notebookseller.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seed.notebookseller.domain.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    @Transactional
    public Store createStore(Store store) {
        Store save = storeRepository.save(store);
        return save;
    }

    @Transactional
    public List<DepositByStoreDto> findDepositByStore(Long storeId){
        List<DepositByStoreDto>depositByStoreDtoList=new ArrayList<>();

        Store store=storeRepository.findById(storeId) //select * from store where store.id=storeid;
                .orElseThrow(()->new RuntimeException("해당 가게는 없습니다"));
        List<Deposit> depositList= store.getDepositList();

        for(Deposit deposit:depositList){
            DepositByStoreDto depositByStoreDto=DepositByStoreDto.builder()
                    .storeId(store.getId())
                    .storeName(store.getName())
                    .deposit(deposit.getDeposit())
                    .notebookId(deposit.getNotebook().getId())
                    .os(deposit.getNotebook().getNoteBookType())
                    .build();
            depositByStoreDtoList.add(depositByStoreDto);
        }
        return depositByStoreDtoList;
    }
}

