package tn.esprit.tpfoyer.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.Entity.Reservation;
import tn.esprit.tpfoyer.Services.IReservationService;

import java.util.List;

@RestController
@AllArgsConstructor
public class ReservationRestController {

    IReservationService iReservationService;
    @GetMapping("/retrieve-all-reservations")
    public List<Reservation> retrieveAllReservations(){
        List<Reservation> reservationList = iReservationService.getReservations();
        return reservationList;
    }
    @GetMapping("/retrieve-reservation/{id}")
    public Reservation retrieveReservationById(@PathVariable("id") String id){
        Reservation reservation = iReservationService.getReservationById(id);
        return reservation;
    }

    @PostMapping("/add-reservation")
    public Reservation addReservation(@RequestBody Reservation reservation){
        Reservation reservation1 = iReservationService.addReservation(reservation);
        return reservation1;
    }

    @PutMapping("/update-reservation")
    public Reservation updateReservation(@RequestBody Reservation reservation){
        Reservation reservation1 = iReservationService.updateReservation(reservation);
        return reservation1;
    }
    @DeleteMapping("/delete-reservation/{id}")
    public String deleteReservation(@PathVariable("id") String id){
        iReservationService.deleteReservation(id);

        return "Reservation deleted";

    }

}
