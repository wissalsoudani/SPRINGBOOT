package tn.esprit.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.Entities.CategorieClient;
import tn.esprit.Entities.Client;
import tn.esprit.Entities.Facture;
import tn.esprit.Repositories.ClientRepository;
import tn.esprit.Repositories.FactureRepository;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class IClientServiceImp implements IClientService {


    ClientRepository clientRepository;
    FactureRepository factureRepository;


    @Override
    public List<Client> retrieveAllClients() {

        return clientRepository.findAll();
    }

    @Override
    public Client addClient(Client c) {

        return clientRepository.save(c);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Client updateClient(Client c) {
        return clientRepository.save(c);

    }

    @Override
    public Client retrieveClient(Long id) {

        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public float getChiffreAffaireParCategorieClient(CategorieClient categorieClient, Date startDate, Date endDate) {
        return 1;
    }

}
