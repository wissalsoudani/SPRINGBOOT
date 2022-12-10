package tn.esprit.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetailProduit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iddetailproduit;
    @Temporal(value = TemporalType.DATE)
    private Date dateCreation;
    private  Date dateDerniereModification;
    @Enumerated(EnumType.STRING)
    private CategorieProduit CategPro;

    @OneToOne(mappedBy = "detailProduit")
    private Produit produit;
}
