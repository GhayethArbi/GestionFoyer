package tn.esprit.tpfoyer.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.Entity.Bloc;
import tn.esprit.tpfoyer.Services.IBlocService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/bloc")

public class BlocRestController {


    IBlocService iBlocService;

    @GetMapping("/retrieve-all-blocs")
    public List<Bloc> retrieveAllBlocs(){
        return iBlocService.getBlocs();
    }
    @GetMapping("/retrieve-bloc/{id}")
    public Bloc retrieveBlocById(@PathVariable("id") Long id){
        return iBlocService.getBlocById(id);
    }
    @PostMapping("/add-bloc")
    public Bloc addBloc(@RequestBody Bloc bloc){
        return iBlocService.addBloc(bloc);
    }

    @PutMapping("/update-bloc")
    public Bloc updateBloc(@RequestBody Bloc bloc){
        return iBlocService.updateBloc(bloc);

    }

    @DeleteMapping("/delete-bloc/{id}")
    public String deleteBloc(@PathVariable Long id){
        iBlocService.deleteBloc(id);
        return "bloc deleted with successfully!";
    }


}
