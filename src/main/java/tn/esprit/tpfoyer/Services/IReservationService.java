package tn.esprit.tpfoyer.Services;

import tn.esprit.tpfoyer.Entity.Reservation;

import java.util.List;

public interface IReservationService {
    List<Reservation> getReservations();
    Reservation getReservationById(String id);
    Reservation addReservation(Reservation reservation);
    Reservation updateReservation(Reservation reservation);
    void deleteReservation(String id);
}
