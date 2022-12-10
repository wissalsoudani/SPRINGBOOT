package tn.esprit.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.Entities.Fournisseur;
import tn.esprit.Entities.Produit;
import tn.esprit.Entities.Stock;
import tn.esprit.Repositories.FournisseurRepository;
import tn.esprit.Repositories.ProduitRepository;
import tn.esprit.Repositories.StockRepository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
public class IProduitServiceImp implements IProduitService {

    @Autowired
    ProduitRepository produitRepository;
    @Autowired
    StockRepository stockRepository;
    @Autowired
    FournisseurRepository fournisseurRepository;


    @Override
    public Produit addProduit(Produit p) {
        return produitRepository.save(p);
    }

    @Override
    public Produit updateProduit(Produit p) {

        return produitRepository.save(p);
    }

    @Override
    public List<Produit> getAllProduits() {

        return produitRepository.findAll();
    }

    @Override
    public void deleteProduit(Long idProduit) {
        produitRepository.deleteById(idProduit);

    }

    @Override
    public Produit getById(Long idProduit) {
        return produitRepository.findById(idProduit).orElse(null);

    }

    @Override
    public void assignProduitToStock(Long idProduit, Long idStock) {
        Produit p = produitRepository.findById(idProduit).orElse(null);
        Stock s = stockRepository.findById(idStock).orElse(null);
        if (p != null && s != null) {
            p.setStock(s);
        }
        produitRepository.save(p);
    }

    @Override
    public void assignFournisseurToProduit(Long fournisseurId, Long produitId) {
        Produit p = produitRepository.findById(produitId).orElse(null);
        Fournisseur f = fournisseurRepository.findById(fournisseurId).orElse(null);
        if (p != null && f != null) {

        }
        fournisseurRepository.save(f);
    }

    @Override
    public float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate) {
        Produit produit = produitRepository.findById(idProduit).orElse(null);
        return produitRepository.getRevenuBrutProduit(produit, startDate, endDate);
    }


}



