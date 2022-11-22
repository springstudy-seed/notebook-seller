package seed.notebookseller.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import seed.notebookseller.domain.Deposit;

@RestController
@RequiredArgsConstructor
public class DepositController {
    private final DepositService depositService;

    @PostMapping("/api/deposits")
    public boolean createDeposit(DepositDto depositDto){
        depositService.createDeposit(depositDto);
        return true;
    }

    @PatchMapping("/api/deposits/{id}")
    public Long buyNotebookByCustomer(@PathVariable("id") Long depositId, Long countBuyNotebook){
        return depositService.buyNoteBookByCustomer(depositId, countBuyNotebook);
    }
    @PatchMapping("/api/deposits/host/{id}")
    public Long buyNotebookByHost(@PathVariable("id") Long depositId, Long countBuyNotebook){
        return depositService.buyNoteBookByHost(depositId, countBuyNotebook);
    }



}
