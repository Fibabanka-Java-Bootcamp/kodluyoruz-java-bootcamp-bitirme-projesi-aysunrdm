package org.kodluyoruz.mybank.Transfer;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("transferRepository")
@Transactional
public class TransferRepositoryImpl implements TransferRepository {


        @PersistenceContext
        public EntityManager entityManager;

        @Transactional(readOnly=false)
        public TransferEntity addTransfer(TransferEntity transferEntity) {

            entityManager.persist(transferEntity);
            return transferEntity;
        }

        @Transactional(readOnly=false)
        public TransferEntity updateTransfer(TransferEntity transferEntity) {
            entityManager.merge(transferEntity);
            return transferEntity;
        }

        @Transactional(readOnly=false)
        public void deleteTransfer(Long transferId) {

            TransferEntity transferEntity = getTransfer(transferId);
            entityManager.remove(transferEntity);
        }

        @Transactional(readOnly=true)
        public TransferEntity getTransfer(Long transferId) {
            String sql = "select transfer from TransferEntity transfer where transfer.transferId=" + transferId;
            try{
                return (TransferEntity) entityManager.createQuery(sql).getSingleResult();
            }catch(Exception e){
            }
            return null;
        }

        @Transactional(readOnly=true)
        public List getTransfers() {

            return entityManager.createQuery("select transfer from TransferEntity transfer").getResultList();
        }


}
