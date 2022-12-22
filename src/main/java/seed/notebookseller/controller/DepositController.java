package seed.notebookseller.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import seed.notebookseller.domain.Deposit;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class DepositController {
    private final DepositService depositService;

    @PostMapping("/api/deposits")
    public ResponseEntity<Deposit> createDeposit(@RequestBody DepositDto depositDto){
        Deposit createdDeposit=depositService.createDeposit(depositDto);
        URI uri=ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("{id}/")
                        .buildAndExpand(createdDeposit.getId())
                        .toUri();
        return ResponseEntity.created(uri)
                .body(createdDeposit);
    }

    @PatchMapping("/api/deposits/{id}")
    public Long buyNotebookByCustomer(@PathVariable("id") Long depositId, Long countBuyNotebook){
        return depositService.buyNoteBookByCustomer(depositId, countBuyNotebook);
    }
    @PatchMapping("/api/deposits/{id}/host")
    public Long buyNotebookByHost(@PathVariable("id") Long depositId, Long countBuyNotebook){
        return depositService.buyNoteBookByHost(depositId, countBuyNotebook);
    }
}
