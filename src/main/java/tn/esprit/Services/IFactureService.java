package tn.esprit.Services;

import org.springframework.stereotype.Service;
import tn.esprit.Entities.Facture;

import java.util.List;

public interface IFactureService {

    List<Facture> retrieveAllFactures();
    void cancelFacture(Long id);

    Facture retrieveFacture(Long id);

    List<Facture> getFacturesByClient(Long idClient);

    Facture addFacture(Facture f, Long idClient);

}
