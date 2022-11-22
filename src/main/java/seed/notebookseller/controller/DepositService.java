package seed.notebookseller.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seed.notebookseller.domain.*;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class DepositService {
    private final DepositRepository depositRepository;
    private final StoreRepository storeRepository;
    private final NotebookRepository notebookRepository;

    public Deposit createDeposit(DepositDto depositDto) {

        Store storeStore = storeRepository.findById(depositDto.getStore_id()).get();

        Notebook notebookNotebook = notebookRepository.findById(depositDto.getNotebook_id()).get();

        Deposit deposit = new Deposit(depositDto.getDeposit(), notebookNotebook, storeStore);

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