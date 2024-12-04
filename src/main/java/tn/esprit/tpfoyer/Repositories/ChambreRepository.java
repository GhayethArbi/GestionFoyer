package tn.esprit.tpfoyer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tpfoyer.Entity.Chambre;
import tn.esprit.tpfoyer.Entity.TypeChambre;

import java.util.List;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {


    //keywords
    List<Chambre> findAllByTypeChambre(TypeChambre typeChambre);

    List<Chambre> findByNumeroChambreBetween(long start, long end);

    List<Chambre> findAllByTypeChambreAndBloc_IdBloc(TypeChambre typeChambre, long id);

    List<Chambre> findAllByReservationsIsEmpty();


}
