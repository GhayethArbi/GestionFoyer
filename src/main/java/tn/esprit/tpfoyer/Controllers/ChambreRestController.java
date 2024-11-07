package tn.esprit.tpfoyer.Controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import tn.esprit.tpfoyer.Entity.Chambre;
import tn.esprit.tpfoyer.Services.IChambreService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/chambre")

public class ChambreRestController {

    IChambreService iChambreService;

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


}
