package tn.esprit.tpfoyer.Services;

import tn.esprit.tpfoyer.Entity.Chambre;
import tn.esprit.tpfoyer.Entity.TypeChambre;

import java.util.List;

public interface IChambreService {
    List<Chambre> getChambres();
    Chambre getChambreById(Long id);
    Chambre addChambre(Chambre chambre);
    Chambre updateChambre(Chambre chambre);
    void deleteChambre(Long id);


    //keywords
    List<Chambre> findAllChambreByTypeChambre(TypeChambre typeChambre);
    List<Chambre> retrieveByNumeroChambreBetween(long start,long end);
    List<Chambre> retrieveAllByTypeChambreAndBloc_IdBloc(TypeChambre typeChambre, long id);
    List<Chambre> retrieveAllByReservationsIsEmpty();

}
