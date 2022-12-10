package tn.esprit.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetailFacture implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetailFacture;
    private int qte;
    private  float prixTotal;
    private  int pourcentageRemise;
    private int montantRemise;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Facture facture;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Produit produit;
}
