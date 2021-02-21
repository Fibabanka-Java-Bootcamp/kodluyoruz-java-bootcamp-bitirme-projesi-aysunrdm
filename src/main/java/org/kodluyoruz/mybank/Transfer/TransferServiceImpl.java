package org.kodluyoruz.mybank.Transfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("transferService")
@Transactional
public class TransferServiceImpl implements TransferService {

    @Autowired
    private TransferRepository transferRepository;

    @Transactional
    public TransferEntity createTransfer(TransferDTO transfer) {

        System.out.println("Transfer Service Create invoked...");

        TransferEntity transferEntity = new TransferEntity();

        transferEntity.setTransferType(transfer.getTransferType());
        transferEntity.setTransferCode(transfer.getTransferCode());
        transferEntity.setTransferAmount(transfer.getTransferAmount());
        transferEntity.setTransferStatus(transfer.getTransferStatus());
        transferEntity.setSourceName(transfer.getSourceName());
        transferEntity.setDestinationName(transfer.getDestinationName());
        transferEntity.setTransactionDescription(transfer.getTransactionDescription());
        return transferRepository.save(transferEntity);
    }


    @Transactional
    public List<TransferEntity> findAll() {
        return transferRepository.findAll();
    }


    @Transactional
    public TransferEntity updateTransfer(Long transferId, TransferDTO request) {

        TransferEntity updatedTransfer = Optional.ofNullable(transferRepository.findOne(transferId)).map(transferEntity -> {

            TransferEntity transfer = new TransferEntity();

            transfer.setTransferId(request.getTransferId());
            transfer.setTransferType(request.getTransferType());
            transfer.setTransferCode(request.getTransferCode());
            transfer.setTransferAmount(request.getTransferAmount());
            transfer.setTransferStatus(request.getTransferStatus());
            transfer.setSourceName(request.getSourceName());
            transfer.setDestinationName(request.getDestinationName());
            transfer.setTransactionDescription(request.getTransactionDescription());
            return transfer;

        }).get();

        return transferRepository.save(updatedTransfer);
    }

    @Transactional
    public void deleteTransfer(Long transferId) {
        transferRepository.deleteById(transferId);
    }

}
