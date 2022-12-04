package tn.esprit.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduit;
    private String codeProduit;
    private String libelleProduit;
    private Float prixUnitaire;

    @OneToMany(mappedBy = "produit")
    private List<DetailFacture> detailFactures;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Rayon rayon;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Stock stock;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Fournisseur> fournisseur;

    @OneToOne
    private DetailProduit detailProduit;
}

