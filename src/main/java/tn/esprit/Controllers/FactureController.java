package tn.esprit.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Entities.Facture;
import tn.esprit.Services.IFactureService;
import javax.websocket.server.PathParam;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/facture")
public class FactureController {

    @Autowired
    IFactureService iFactureService;

    @GetMapping("/getall")
    public List<Facture> retrieveAllFactures() {
        return iFactureService.retrieveAllFactures();
    }

    @PostMapping("/cancelFacture")
    public void cancelFacture(Long id) {
        iFactureService.cancelFacture(id);
    }

    @GetMapping("/getFacture")
    public Facture retrieveFacture(@PathParam("id") Long id) {
        return iFactureService.retrieveFacture(id);
    }

    @GetMapping("factureBYclient/{idClient}")
    public List<Facture> getFacturesByClient(@PathVariable Long idClient) {
        return iFactureService.getFacturesByClient(idClient);
    }
    @PostMapping("/addFactureTOclient")
    public Facture addFacture(@RequestBody Facture f, @PathParam("id") Long idClient){
        return iFactureService.addFacture(f,idClient);
    }
}
