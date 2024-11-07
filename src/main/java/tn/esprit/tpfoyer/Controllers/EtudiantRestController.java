package tn.esprit.tpfoyer.Controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.Entity.Etudiant;
import tn.esprit.tpfoyer.Services.IEtudiantService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantRestController {


    IEtudiantService iEtudiantService;

    @GetMapping("/retrieve-all-etudiants")
    public List<Etudiant> retrieveAllEtudiants(){
        List<Etudiant> etudiantList = iEtudiantService.getEtudiants();
        return etudiantList;
    }
    @GetMapping("/retrieve-etudiant/{id}")
    public Etudiant retrieveEtudiantById(@PathVariable("id") Long id){
        Etudiant etudiant = iEtudiantService.getEtudiantById(id);
        return etudiant;
    }

    @PostMapping("/add-etudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant etudiant){
        Etudiant etudiant1 = iEtudiantService.addEtudiant(etudiant);
        return etudiant1;
    }

    @PutMapping("/update-etudiant")
    public Etudiant updateEtudiant(@RequestBody Etudiant etudiant){
        Etudiant etudiant1 = iEtudiantService.updateEtudiant(etudiant);
        return etudiant1;
    }
    @DeleteMapping("/delete-etudiant/{id}")
    public String deleteEtudiant(@PathVariable("id") Long id){
        iEtudiantService.deleteEtudiant(id);

        return "Etudiant deleted";

    }

}
