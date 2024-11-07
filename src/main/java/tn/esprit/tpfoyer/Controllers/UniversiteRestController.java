package tn.esprit.tpfoyer.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import tn.esprit.tpfoyer.Entity.Universite;
import tn.esprit.tpfoyer.Services.IUniversiteService;

import java.util.List;

@RestController
@RequestMapping("/universite")
@AllArgsConstructor
public class UniversiteRestController {
    IUniversiteService iUniversiteService;

    @GetMapping("/retrieve-all-universites")
    public List<Universite> retrieveAllUniversites(){
        List<Universite> universiteList = iUniversiteService.getUniversites();
        return universiteList;
    }
    @GetMapping("/retrieve-universite/{id}")
    public Universite retrieveUniversiteById(@PathVariable("id") Long id){
        Universite universite = iUniversiteService.getUniversiteById(id);
        return universite;
    }

    @PostMapping("/add-universite")
    public Universite addUniversite(@RequestBody Universite universite){
        Universite universite1 = iUniversiteService.addUniversite(universite);
        return universite1;
    }

    @PutMapping("/update-universite")
    public Universite updateUniversite(@RequestBody Universite universite){
        Universite universite1 = iUniversiteService.updateUniversite(universite);
        return universite1;
    }
    @DeleteMapping("/delete-universite/{id}")
    public String deleteUniversite(@PathVariable("id") Long id){
        iUniversiteService.deleteUniversite(id);

        return "Universite deleted";

    }




}
