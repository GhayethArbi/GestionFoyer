package tn.esprit.tpfoyer.Services;


import tn.esprit.tpfoyer.Entity.Foyer;

import java.util.List;

public interface IFoyerService {
    List<Foyer> getFoyers();
    Foyer getFoyerById(Long id);
    Foyer addFoyer(Foyer foyer);
    Foyer updateFoyer(Foyer foyer);
    void deleteFoyer(Long id);
}
