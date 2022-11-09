package seed.notebookseller.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seed.notebookseller.domain.*;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepositService {
    private final DepositRepository depositRepository;
    private final StoreRepository storeRepository;
    private final NotebookRepository notebookRepository;

    public Deposit createDeposit(DepositDto depositDto){

        Store storeStore = storeRepository.findById(depositDto.getStore_id()).get();

        Notebook notebookNotebook = notebookRepository.findById(depositDto.getNotebook_id()).get();

        Deposit deposit = new Deposit(depositDto.getDeposit(), notebookNotebook, storeStore);

        return depositRepository.save(deposit);
    }
}