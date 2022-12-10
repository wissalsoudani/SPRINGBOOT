package tn.esprit.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.Entities.Produit;
import tn.esprit.Entities.Stock;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock,Long> {

    @Query("SELECT s.produits FROM Stock s where s.qteStock < s.qteMin ")
    public List<Produit> getStockProduits();
}
