package org.kodluyoruz.mybank.Transfer;

import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.kodluyoruz.mybank.Account.AccountEntity;
import org.kodluyoruz.mybank.Account.AccountRepository;
import org.kodluyoruz.mybank.Account.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.hibernate.resource.transaction.spi.TransactionStatus.COMMITTED;

@Service("transferService")
@Transactional
public class TransferServiceImpl implements TransferService {

    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountServiceImpl accountServiceImpl;

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


    @Transactional
    public void transferMoney(TransferInfo transferInfo) {

        AccountEntity fromAccountEntity = accountRepository.findByIban(transferInfo.getFromIbanNo());
        AccountEntity toAccountEntity = accountRepository.findByIban(transferInfo.getToIbanNo());
        Long amount = transferInfo.getAmount();
        String currency = transferInfo.getCurrency();

        if (!accountServiceImpl.savingAccount(fromAccountEntity.getAccountId())) {

            if (!transferInfo.getFromIbanNo().isEmpty() && !transferInfo.getToIbanNo().isEmpty() &&

                    transferInfo.getAmount() != null && !transferInfo.getCurrency().isEmpty()) {

                if (fromAccountEntity.getBalance().compareTo(1L) == 1 && fromAccountEntity.getBalance().compareTo(amount.longValue()) == 1) {
                    fromAccountEntity.setBalance(fromAccountEntity.getBalance() - amount);
                    accountRepository.save(fromAccountEntity);
                    toAccountEntity.setBalance(toAccountEntity.getBalance() + amount);
                    accountRepository.save(toAccountEntity);

                    String transferType = "EFT";
                    String transferCode = "555";
                    BigDecimal transferAmount = BigDecimal.valueOf(amount);
                    TransactionStatus transferStatus = COMMITTED;
                    String transactionDescription = "Hesaplar Arası Transfer";
                    String sourceName = fromAccountEntity.getIban();
                    String destinationName = toAccountEntity.getIban();
                    LocalDateTime transferDatetime = new Timestamp(System.currentTimeMillis()).toLocalDateTime();

                    transferRepository.save(new TransferEntity(0L, transferType, transferCode, transferAmount,
                            transferStatus, sourceName, destinationName, transactionDescription, transferDatetime));
                }

            }
        }
    }
}


