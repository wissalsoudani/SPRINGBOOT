package tn.esprit.Services;
import org.springframework.stereotype.Component;
import tn.esprit.Entities.CategorieClient;
import tn.esprit.Entities.Client;
import tn.esprit.Entities.Facture;

import java.util.Date;
import java.util.List;

public interface IClientService {

    List<Client> retrieveAllClients();
    Client addClient(Client c);
    void deleteClient(Long id);
    Client updateClient(Client c);
    Client retrieveClient(Long id);

    public float getChiffreAffaireParCategorieClient(CategorieClient categorieClient, Date startDate, Date endDate);

}
