package seed.notebookseller.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seed.notebookseller.domain.*;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class DepositService {
    private static final String NOT_FOUND_STORE="해당하는 가게가 없습니다";
    private static final String NOT_FOUND_NOTEBOOK="해당하는 노트북이 없습니다";
    private final DepositRepository depositRepository;
    private final StoreRepository storeRepository;
    private final NotebookRepository notebookRepository;

    @Transactional
    public Deposit createDeposit(DepositDto depositDto) {

        Store storeStore = storeRepository.findById(depositDto.getStoreId())
                .orElseThrow(()->new RuntimeException(NOT_FOUND_STORE));

        Notebook notebookNotebook = notebookRepository.findById(depositDto.getNotebookId())
                .orElseThrow(()-> new IllegalArgumentException(NOT_FOUND_NOTEBOOK));

        Deposit deposit=depositDto.toEntity(storeStore,notebookNotebook,depositDto);
        return depositRepository.save(deposit);
    }

    @Transactional
    public Long buyNoteBookByCustomer(Long depositId, Long buyCount) {
        Deposit deposit = depositRepository.findById(depositId)
                .orElseThrow(() -> new IllegalArgumentException("해당 제고는 없음"));

        return deposit.minusDeposit(buyCount);
    }

    @Transactional
    public Long buyNoteBookByHost(Long depositId, Long buyCount) {
        Deposit deposit = depositRepository.findById(depositId).get();

        return deposit.plusDeposit(buyCount);
    }


}