package tn.esprit.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.Entities.CategorieClient;
import tn.esprit.Entities.Client;

import java.util.Date;

public interface ClientRepository extends JpaRepository <Client,Long> {

      // Long deleteByIdClient();
        @Query
        ("SELECT sum(f.montantFacture) FROM Facture f where f.clients.CategC=:categorieClient and f.dateFacture between :startDate" + " and :endDate and f.active=true")
public float getChiffreAffaireParCategorieClient(@Param("categorieClient") CategorieClient categorieClient,
                                                 @Param("startDate") Date startDate, @Param("endDate") Date endDate);


}
