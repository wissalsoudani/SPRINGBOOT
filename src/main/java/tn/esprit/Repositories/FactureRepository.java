package tn.esprit.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.Entities.Facture;

import java.util.List;

public interface FactureRepository extends JpaRepository<Facture,Long> {
    @Modifying
    @Query("update Facture f set f.active = 0 where f.idFacture = :id")
    @Transactional
    void cancelFacture(@Param(value = "id") Long idFacture);

    List<Facture> findByClients_IdClient(Long idClient);

}
