package tn.esprit.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Entities.Stock;
import tn.esprit.Services.IStockService;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    IStockService iStockService;

    @GetMapping("/getall")
    public List<Stock> retrieveAllStocks(){
        return iStockService.retrieveAllStocks();
    }

    @PostMapping("/addstock")
    public Stock addStock(@RequestBody Stock s){
        return iStockService.addStock(s);
    }
    @PostMapping("/update")
    public Stock updateStock(@RequestBody Stock u) {
        return iStockService.updateStock(u);
    }
    @GetMapping("/getStock")
    public Stock retrieveStock(@PathVariable("id") Long idStock) {
        return iStockService.retrieveStock(idStock);
    }

    @GetMapping ("/ListProduits")
    public String retrieveStatusStock() {
        return iStockService.retrieveStatusStock() ;

    }







}
