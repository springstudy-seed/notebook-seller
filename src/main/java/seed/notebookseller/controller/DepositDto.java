package seed.notebookseller.controller;

import lombok.*;
import seed.notebookseller.domain.Deposit;
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepositDto {
    private Long deposit;
    private Long store_id;
    private Long notebook_id;


    public Deposit toEntity(Long deposit){
        return Deposit.builder()
                .deposit(deposit)
                .build();
    }
}
