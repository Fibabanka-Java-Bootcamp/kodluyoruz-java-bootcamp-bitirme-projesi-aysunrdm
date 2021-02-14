package org.kodluyoruz.mybank.Transfer;

import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TransferRepository {

        public TransferEntity addTransfer(TransferEntity transferEntity);
        public TransferEntity updateTransfer(TransferEntity transferEntity);
        public void deleteTransfer(Long transferId);
        public TransferEntity getTransfer(Long transferId);
        public List<TransferEntity> getTransfers();
}
