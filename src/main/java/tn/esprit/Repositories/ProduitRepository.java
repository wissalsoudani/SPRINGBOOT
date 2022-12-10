package tn.esprit.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.Entities.Produit;

import java.util.Date;
import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit,Long> {
//Long deleteByIdProduit();
@Query("SELECT sum(df.prixTotal*df.qte) FROM DetailFacture df where df.produit=:produit and df.facture.dateFacture between :startDate"+ " and :endDate and df.facture.active=true")
public float getRevenuBrutProduit(@Param("produit") Produit produit, @Param("startDate") Date startDate,
                                  @Param("endDate") Date endDate);

}
