package seed.notebookseller.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import seed.notebookseller.domain.Deposit;
@Getter
public class DepositDto {
    private Long deposit;
    private Long store_id;
    private Long notebook_id;


    public DepositDto() {
    }

    public Deposit toEntity(){

        Deposit deposit1 = new Deposit(this.deposit,this.store_id,this.notebook_id);
    }
}
