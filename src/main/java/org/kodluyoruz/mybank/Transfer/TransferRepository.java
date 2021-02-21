package org.kodluyoruz.mybank.Transfer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransferRepository extends JpaRepository<TransferEntity, Long> {

    default <S extends TransferEntity> Optional<S> findOne(Long example) {
        return Optional.empty();
    }

    void deleteById(Long transferId);

}
