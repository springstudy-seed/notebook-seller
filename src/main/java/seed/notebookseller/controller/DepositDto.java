package seed.notebookseller.controller;

import lombok.*;
import seed.notebookseller.domain.Deposit;
import seed.notebookseller.domain.Notebook;
import seed.notebookseller.domain.Store;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepositDto {

    private Long storeId;
    private Long notebookId;
    private Long depositCount;

    public Deposit toEntity(Store store, Notebook notebook,DepositDto depositDto){
        return Deposit.builder()
                .store(store)
                .notebook(notebook)
                .deposit(depositDto.getDepositCount())
                .build();
    }
}
