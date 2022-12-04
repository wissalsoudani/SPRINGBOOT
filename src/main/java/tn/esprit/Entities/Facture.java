package tn.esprit.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Facture implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFacture;
    private Float montantRemise;
    private Float montantFacture;
    @Temporal(value = TemporalType.DATE)
    private Date dateFacture;
    private Boolean active;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Client clients;

    @OneToMany(mappedBy = "facture")
    private List<DetailFacture> detailFactures;
}
