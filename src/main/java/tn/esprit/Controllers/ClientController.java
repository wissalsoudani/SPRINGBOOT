package tn.esprit.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Entities.CategorieClient;
import tn.esprit.Entities.Client;
import tn.esprit.Entities.Facture;
import tn.esprit.Services.IClientService;
import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    IClientService iClientService;

    @GetMapping("/getall")
    public List<Client> retrieveAllClients(){
        return iClientService.retrieveAllClients();
    }

    @PostMapping("/add")
    public Client addClient(@RequestBody Client c){
        return iClientService.addClient(c);
    }

    @DeleteMapping("/delete")
    public void deleteClient(@PathParam("id")Long idClient){
         iClientService.deleteClient(idClient);
    }

    @PostMapping("/update")
    public Client updateClient(@RequestBody Client c){
        return iClientService.addClient(c);
    }

    @GetMapping("/getClient")
    public Client retrieveClient(@PathParam("id") Long idClient){
        return iClientService.retrieveClient( idClient);
    }


    @GetMapping( "/getChiffreAffaireParCategorieClient/{categorieClient}/{startDate}/{endDate}")
    public float getChiffreAffaireParCategorieClient(@PathVariable("categorieClient") CategorieClient categorieClient,
                                                     @PathVariable(name = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                                     @PathVariable(name = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {

        return iClientService.getChiffreAffaireParCategorieClient(categorieClient, startDate, endDate);
    }

}
