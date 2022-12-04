package tn.esprit.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.Entities.Client;
import tn.esprit.Entities.Produit;
import tn.esprit.Entities.Stock;
import tn.esprit.Repositories.ProduitRepository;
import tn.esprit.Repositories.StockRepository;
import java.util.Collection;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class IStockServiceImp implements IStockService{

       @Autowired
        StockRepository stockRepository;
        ProduitRepository produitRepository;

    @Override
    public List<Stock> retrieveAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public Stock addStock(Stock s) {
        return stockRepository.save(s);
    }

    @Override
    public Stock updateStock(Stock u) {
        return stockRepository.save(u);
    }

    @Override
    public Stock retrieveStock(Long id) {
        return stockRepository.findById(id).orElse(null);

    }

//mochkla taa bean produit
    @Scheduled(fixedRate = 60000)
    @Override
    public String retrieveStatusStock() {
         stockRepository.findStockByQteStockLessThanQteMin().forEach(produit -> log.info(produit.getCodeProduit()));

                   /* .map(Stock::getProduits)
                    .flatMap(Collection::stream)
                    .forEach(produit -> log.info(stockRepository.getStockByQteStockLessThanAndQteMin()));*/
            return ("la liste des stocks est: ");
        }
    }


