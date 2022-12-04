package tn.esprit.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.Entities.Produit;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit,Long> {
//Long deleteByIdProduit();

}
