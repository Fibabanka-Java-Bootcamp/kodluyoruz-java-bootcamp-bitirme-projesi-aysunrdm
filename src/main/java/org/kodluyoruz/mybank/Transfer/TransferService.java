package org.kodluyoruz.mybank.Transfer;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransferService {

    TransferEntity createTransfer(TransferDTO transfer);

    TransferEntity updateTransfer(Long transferId, TransferDTO request);

    void deleteTransfer(Long transferId);

    List<TransferEntity> findAll();

    void transferMoney(TransferInfo transferInfo);

    // void transferMoneyByCurrency(TransferInfo transferInfo, ExchangeRate exchangeRate);
}
