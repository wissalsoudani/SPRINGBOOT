package tn.esprit.Services;
import tn.esprit.Entities.Stock;
import java.util.List;

public interface IStockService {

    List<Stock> retrieveAllStocks();

    Stock addStock(Stock s);

    Stock updateStock(Stock u);

    Stock retrieveStock(Long id);

    String retrieveStatusStock();
}
