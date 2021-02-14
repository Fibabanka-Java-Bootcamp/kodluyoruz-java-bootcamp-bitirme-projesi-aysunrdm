package org.kodluyoruz.mybank.Transfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service("transferService")
@Transactional
public class TransferServiceImpl implements TransferService{

        @Autowired(required=true)
        @Qualifier("transferRepository")
        private TransferRepository transferRepository;

        @Transactional
        public TransferEntity addTransfer(TransferEntity transfer) {

            System.out.println("Transfer Service create invoked:"+transfer.getTransferType());
            transfer = transferRepository.addTransfer(transfer);
            return transfer;
        }
        @Transactional
        public TransferEntity updateTransfer(TransferEntity transfer) {

            System.out.println("Transfer Service Update invoked:" + transfer.getTransferType());
            transfer = transferRepository.updateTransfer(transfer);
            return transfer;
        }

        public TransferEntity getTransfer(Long transferId) {
            return transferRepository.getTransfer(transferId);
        }

        public List<TransferEntity> getAllTransfers() {
            return (List<TransferEntity>) transferRepository.getTransfers();
        }

        @Transactional
        public void deleteTransfer(Long transferId) {
            transferRepository.deleteTransfer(transferId);
        }


}
