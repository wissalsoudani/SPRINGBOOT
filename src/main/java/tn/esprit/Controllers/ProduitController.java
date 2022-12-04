package tn.esprit.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Entities.Produit;
import tn.esprit.Services.IProduitService;
import javax.websocket.server.PathParam;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/produit")
public class ProduitController {

    IProduitService iProduitService;


    @GetMapping("/hello/{classname}")
    public String sayHello(@PathVariable String classname){
        return "hello "+classname;
    }

    @PostMapping("/add")
    public Produit addProduit(@RequestBody Produit p){

        return iProduitService.addProduit(p);
    }

    @PutMapping("/update")
    public Produit updateProduit(@RequestBody Produit p){
        return iProduitService.updateProduit(p);
    }

    @GetMapping("/getall")
    public List<Produit> retrieveAllEquipes(){
        return iProduitService.getAllProduits();
    }

    @DeleteMapping("/delete")
    public void deleteProduit(@PathParam("id") Long idProduit){
        iProduitService .deleteProduit(idProduit);
    }


    @GetMapping("/getProduit")
    public Produit retrieveProduit(@PathParam("id") Long idProduit){
        return iProduitService.getById(idProduit);
    }

    @PostMapping("/assignPtoS/{idProduit}/{idStock}")
    void assignProduitToStock(@PathVariable Long idProduit, @PathVariable Long idStock){
      iProduitService.assignProduitToStock(idProduit,idStock);
    }




}












