package tn.esprit.tpfoyer.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.Entity.Bloc;
import tn.esprit.tpfoyer.Entity.Reservation;
import tn.esprit.tpfoyer.Repositories.ReservationRepository;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ReservationServiceImpl implements IReservationService {
    ReservationRepository reservationRepository;
    @Override
    public List<Reservation> getReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getReservationById(String id) {
        return reservationRepository.findById(id).get();
    }

    @Override
    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservation(String id) {
        reservationRepository.deleteById(id);
    }


    @Scheduled( fixedRate = 50000)
    public void mettreAJourEtAfficherReservations(){
        List<Reservation> reservations = getReservations();
        reservations.stream().forEach(reservation -> {
            Date date1 = new Date(2024,1,1);
            if (reservation.getAnneeUniversitaire().compareTo( date1)==1){
                reservation.setEstValide(false);
                updateReservation(reservation);
                log.info(reservation.toString());
            }
        });
    }
}
