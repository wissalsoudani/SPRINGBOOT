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

   // @Scheduled(cron ="* * 22 * * ?")
   @Scheduled(fixedRate = 60000)
    @Override
    public String retrieveStatusStock() {
            List<Produit> produitList =  stockRepository.getStockProduits() ;
            produitList.stream().forEach(produit -> System.out.println(produit.getLibelleProduit()));
            return null ;
        }






    }





