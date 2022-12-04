package tn.esprit.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.Entities.Produit;
import tn.esprit.Entities.Stock;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock,Long> {

    List<Produit>findStockByQteStockLessThanQteMin();

}
