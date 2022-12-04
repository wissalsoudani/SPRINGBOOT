package tn.esprit.Services;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Entities.Fournisseur;
import tn.esprit.Entities.Produit;
import tn.esprit.Entities.Stock;
import tn.esprit.Repositories.FournisseurRepository;
import tn.esprit.Repositories.ProduitRepository;

@Service
@AllArgsConstructor
public class IFournisseurServiceImp implements IFournisseurService{
    @Autowired
    ProduitRepository produitRepository;
    FournisseurRepository fournisseurRepository;



}
