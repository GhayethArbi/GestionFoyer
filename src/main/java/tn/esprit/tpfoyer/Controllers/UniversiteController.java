package tn.esprit.tpfoyer.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.Entity.Universite;
import tn.esprit.tpfoyer.Services.UniversiteServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/universite")
@AllArgsConstructor
public class UniversiteController {
    UniversiteServiceImpl universiteService;

    @PostMapping
    public Universite create(@RequestBody Universite universite){
        return universiteService.addUniversite(universite);
    }

    @GetMapping
    public List<Universite> read(){
        return universiteService.getUniversites();
    }

}
