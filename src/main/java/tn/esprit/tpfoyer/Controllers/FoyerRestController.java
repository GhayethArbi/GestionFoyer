package tn.esprit.tpfoyer.Controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.Entity.Foyer;
import tn.esprit.tpfoyer.Services.IFoyerService;

import java.util.List;

@RestController
@AllArgsConstructor
public class FoyerRestController {
    IFoyerService iFoyerService;

    @GetMapping("/retrieve-all-foyers")
    public List<Foyer> retrieveAllFoyers(){
        List<Foyer> foyerList = iFoyerService.getFoyers();
        return foyerList;
    }
    @GetMapping("/retrieve-foyer/{id}")
    public Foyer retrieveFoyerById(@PathVariable("id") Long id){
        Foyer foyer = iFoyerService.getFoyerById(id);
        return foyer;
    }

    @PostMapping("/add-foyer")
    public Foyer addFoyer(@RequestBody Foyer foyer){
        Foyer foyer1 = iFoyerService.addFoyer(foyer);
        return foyer1;
    }

    @PutMapping("/update-foyer")
    public Foyer updateFoyer(@RequestBody Foyer foyer){
        Foyer foyer1 = iFoyerService.updateFoyer(foyer);
        return foyer1;
    }
    @DeleteMapping("/delete-foyer/{id}")
    public String deleteFoyer(@PathVariable("id") Long id){
        iFoyerService.deleteFoyer(id);

        return "Foyer deleted";

    }

}
