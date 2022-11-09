package seed.notebookseller.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seed.notebookseller.domain.Deposit;

@Service
@RequiredArgsConstructor
public class DepositService {
    private final DepositRepository depositRepository;

    public Deposit createDeposit(Deposit deposit){return depositRepository.save(deposit);
    }
}