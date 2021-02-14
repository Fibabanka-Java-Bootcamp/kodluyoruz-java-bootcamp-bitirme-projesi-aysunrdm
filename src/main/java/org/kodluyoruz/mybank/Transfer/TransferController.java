package org.kodluyoruz.mybank.Transfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.logging.Logger;
import java.util.List;


@RestController
@RequestMapping("/transfer")
public class TransferController {

        Logger LOG = Logger.getLogger(TransferController.class.getName());

        @Autowired(required=true)
        @Qualifier("transferService")
        private TransferService transferService;

        @GetMapping("/{transferId}")
        public TransferEntity getTransfers(@PathVariable("transferId") Long transferId){

            return transferService.getTransfer(transferId);
        }
        @RequestMapping(value="/all",method= RequestMethod.GET)
        public List<TransferEntity> allTransfers(){
            List<TransferEntity> list = transferService.getAllTransfers();
            return list;
        }
        @RequestMapping(value="/update",method=RequestMethod.POST)
        public TransferEntity editTransfer(@RequestBody TransferEntity transfer){
            transfer = transferService.updateTransfer(transfer);
            return transfer;

        }
        @RequestMapping(value="/add",method=RequestMethod.POST)
        public TransferEntity addTransfer(@RequestBody TransferEntity transfer){
            transfer = transferService.addTransfer(transfer);
            return transfer;
        }

}
