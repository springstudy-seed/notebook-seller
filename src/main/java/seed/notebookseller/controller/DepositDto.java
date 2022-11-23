package seed.notebookseller.controller;

import lombok.*;
import seed.notebookseller.domain.Deposit;
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepositDto {
    private Long deposit;
    private Long storeId;
    private Long notebookId;


    public Deposit toEntity(Long deposit){
        return Deposit.builder()
                .deposit(deposit)
                .build();
    }
}
