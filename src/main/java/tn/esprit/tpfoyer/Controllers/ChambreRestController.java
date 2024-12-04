package tn.esprit.tpfoyer.Controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import tn.esprit.tpfoyer.Entity.Chambre;
import tn.esprit.tpfoyer.Entity.TypeChambre;
import tn.esprit.tpfoyer.Services.IChambreService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/chambre")
@Tag(name = "Section chambre pour 4sim1")

public class ChambreRestController {

    IChambreService iChambreService;


    @Operation(description = "cette methode affiche tt le chambre de la db")
    @GetMapping("/retrieve-all-chambres")
    public List<Chambre> retrieveAllChambres(){
        List<Chambre> chambreList = iChambreService.getChambres();
        return chambreList;
    }
    @GetMapping("/retrieve-chambre/{id}")
    public Chambre retrieveChambreById(@PathVariable("id") Long id){
        Chambre chambre = iChambreService.getChambreById(id);
        return chambre;
    }

    @PostMapping("/add-chambre")
    public Chambre addChambre(@RequestBody Chambre chambre){
        Chambre chambre1 = iChambreService.addChambre(chambre);
        return chambre1;
    }

    @PutMapping("/update-chambre")
    public Chambre updateChambre(@RequestBody Chambre chambre){
        Chambre chambre1 = iChambreService.updateChambre(chambre);
        return chambre1;
    }
    @DeleteMapping("/delete-chambre/{id}")
    public String deleteChambre(@PathVariable("id") Long id){
        iChambreService.deleteChambre(id);

        return "Chambre deleted";

    }

    //keywords
    @GetMapping("/getAllChambreByTypeChambre/{type-chambre}")
    public List<Chambre> getAllChambreByTypeChambre(@PathVariable("type-chambre")TypeChambre typeChambre){
        return iChambreService.findAllChambreByTypeChambre(typeChambre);
    }
    @GetMapping("/getAllChambreByNumeroChambreBetween/{start}/{end}")
    public List<Chambre> getAllChambreByNumeroChambreBetween(@PathVariable("start") long start,@PathVariable("end") long end){
        return iChambreService.retrieveByNumeroChambreBetween(start, end);
    }
    @GetMapping("/getAllChambreByTypeChambreAndBloc_IdBloc/{type-chambre}/{id}")
    public List<Chambre> getAllChambreByTypeChambreAndBloc_IdBloc(@PathVariable("type-chambre")TypeChambre typeChambre,@PathVariable("id") long id){
        return iChambreService.retrieveAllByTypeChambreAndBloc_IdBloc(typeChambre, id);
    }
    @GetMapping("/getAllChambreByReservationsIsEmpty")
    public List<Chambre> getAllChambreByReservationsIsEmpty(){
        return iChambreService.retrieveAllByReservationsIsEmpty();
    }



}
