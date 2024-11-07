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
        List<Bloc> blocList = iBlocService.getBlocs();
        return blocList;
    }
    @GetMapping("/retrieve-bloc/{id}")
    public Bloc retrieveChambreById(@PathVariable("id") Long id){
        return iBlocService.getBlocById(id);
    }
    @PostMapping("/add-bloc")
    public Bloc addBloc(@RequestBody Bloc bloc){
        Bloc bloc1 = iBlocService.addBloc(bloc);
        return bloc1;
    }

    @PutMapping("/update-bloc")
    public Bloc updateBloc(@RequestBody Bloc bloc){
        Bloc bloc1 = iBlocService.updateBloc(bloc);
        return bloc1;
    }

    @DeleteMapping("/delete-bloc/{id}")
    public String deleteBloc(@PathVariable Long id){
        iBlocService.deleteBloc(id);
        return "bloc deleted with successfully!";
    }


}
