package seed.notebookseller.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import seed.notebookseller.domain.Deposit;

@RestController
@RequiredArgsConstructor
public class DepositController {
    private final DepositService depositService;

    @PostMapping("/api/deposit")
    public boolean createDeposit(Deposit deposit){
        depositService.createDeposit(deposit);
        return true;
    }
}
