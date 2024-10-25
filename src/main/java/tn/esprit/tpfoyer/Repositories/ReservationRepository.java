package tn.esprit.tpfoyer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tpfoyer.Entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, String> {
}
