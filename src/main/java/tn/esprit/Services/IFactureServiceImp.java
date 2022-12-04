package tn.esprit.Services;


import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.Entities.Client;
import tn.esprit.Entities.Facture;
import tn.esprit.Repositories.ClientRepository;
import tn.esprit.Repositories.FactureRepository;

import java.util.List;
@AllArgsConstructor
@Service
public class IFactureServiceImp implements IFactureService {

    FactureRepository factureRepository;
    ClientRepository clientRepository;
    @Override
    public List<Facture> retrieveAllFactures() {
        return factureRepository.findAll();
    }


    @Override
    public void cancelFacture(Long id) {
        factureRepository.cancelFacture(id);
    }

    @Override
    public Facture retrieveFacture(Long id) {

        return factureRepository.findById(id).orElse(null);
    }

    @Override
    public List<Facture> getFacturesByClient(Long idClient) {
      return factureRepository.findByClients_IdClient(idClient);
    }

    @Transactional
    @Override
    public Facture addFacture(Facture f, Long idClient) {
        Client client= clientRepository.findById(idClient).orElse(null);
        if( client!=null)
        {
            Facture facture = factureRepository.save(f);
            facture.setClients(client);
            clientRepository.save(client);
            return facture;
        }
        return null;
    }


}









