package tn.esprit.tpfoyer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tpfoyer.Entity.Chambre;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {
}
