package org.kodluyoruz.mybank.Transfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/transfer", produces = "application/json")
public class TransferController {

    @Autowired
    private TransferService transferService;


    @PostMapping(value = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public TransferEntity createTransfer(@RequestBody TransferDTO request) {
        return transferService.createTransfer(request);
    }

    @GetMapping(value = "/list")
    public List<TransferEntity> listAllTransfers() {
        return transferService.findAll();
    }


    @PutMapping(value = "/update/{transferId}")
    public TransferEntity updateTransfer(@PathVariable Long transferId, @RequestBody TransferDTO request) {
        return transferService.updateTransfer(transferId, request);
    }


    @DeleteMapping("/delete/{transferId}")
    private void deleteTransfer(@PathVariable("transferId") Long transferId) {
        transferService.deleteTransfer(transferId);
    }

}
