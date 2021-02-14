package org.kodluyoruz.mybank.Transfer;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface TransferService {

        public TransferEntity addTransfer(TransferEntity transfer);
        public TransferEntity updateTransfer(TransferEntity transfer);
        public TransferEntity getTransfer(Long transferId);
        public List<TransferEntity> getAllTransfers();
        public void deleteTransfer(Long transferId);

}
