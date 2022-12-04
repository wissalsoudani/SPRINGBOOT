package tn.esprit.Services;

import tn.esprit.Entities.Produit;

import java.util.List;

public interface IProduitService {
    public Produit addProduit(Produit p);
    public Produit updateProduit(Produit p);
    public List<Produit> getAllProduits();
    public void deleteProduit(Long idProduit);
    public Produit getById(Long idProduit);

    void assignProduitToStock(Long idProduit, Long idStock);
    public void assignFournisseurToProduit(Long fournisseurId, Long produitId);

}
