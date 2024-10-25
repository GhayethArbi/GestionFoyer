package tn.esprit.tpfoyer.Services;

import tn.esprit.tpfoyer.Entity.Chambre;

import java.util.List;

public interface IChambreService {
    List<Chambre> getChambres();
    Chambre getChambreById(Long id);
    Chambre addChambre(Chambre chambre);
    Chambre updateChambre(Chambre chambre);
    void deleteChambre(Long id);
}
