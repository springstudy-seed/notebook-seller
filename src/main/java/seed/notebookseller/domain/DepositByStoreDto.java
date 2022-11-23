package seed.notebookseller.domain;

import lombok.Builder;

@Builder
public class DepositByStoreDto {
    private Long storeId;
    private Long notebookId;
    private Long deposit;
    private String storeName;
    private NoteBookType os;
}
