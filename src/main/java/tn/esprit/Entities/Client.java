package tn.esprit.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;
    private  String nom;
    private String prenom;
    @Temporal(value = TemporalType.DATE)
    private Date dateNaissance ;
    private String email;
    @Transient
    private String password;
    @Enumerated(EnumType.STRING)
    private CategorieClient CategC;
    @Enumerated(EnumType.STRING)
     private Profession profession;


    @OneToMany(mappedBy = "clients" )
    private List <Facture> factures;
}
