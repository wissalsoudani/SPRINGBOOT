package tn.esprit.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.Entities.Client;

public interface ClientRepository extends JpaRepository <Client,Long> {

// Long deleteByIdClient();
}
