package tn.esprit.tpfoyer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tpfoyer.Entity.Foyer;

public interface FoyerRepository extends JpaRepository<Foyer, Long> {
}
