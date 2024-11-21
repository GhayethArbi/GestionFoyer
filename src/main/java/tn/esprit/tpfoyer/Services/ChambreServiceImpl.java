package tn.esprit.tpfoyer.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.Entity.Bloc;
import tn.esprit.tpfoyer.Entity.Chambre;
import tn.esprit.tpfoyer.Entity.TypeChambre;
import tn.esprit.tpfoyer.Repositories.BlocRepository;
import tn.esprit.tpfoyer.Repositories.ChambreRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ChambreServiceImpl implements IChambreService{
    ChambreRepository chambreRepository;
    IBlocService iBlocService;

   // @Scheduled(fixedRate = 30000)//10 sec
    @Override
    public List<Chambre> getChambres() {
        List<Chambre> c =  chambreRepository.findAll();
        for(Chambre ch : c){
            log.info(ch.toString());
        }
        return c;
    }

    //@Scheduled(cron = "0 * * * * *") // S'exécute chaque minute
    public void listeChambresParBloc() {
        List<Bloc> blocs = iBlocService.getBlocs();
        System.out.println(blocs);
        if (!blocs.isEmpty()) {
            blocs.forEach(bloc -> {
                System.out.println("Bloc => " + bloc.getNomBloc() + " ayant une capacité " + bloc.getCapaciteBloc());
                if (bloc.getChambres().isEmpty()) {
                    System.out.println("Pas de chambre disponible dans ce bloc");
                } else {
                    System.out.println("La liste des chambres pour ce bloc:");
                    bloc.getChambres().forEach(chambre -> {
                        System.out.println("NumChambre: " + chambre.getNumeroChambre() + " type: " + chambre.getTypeChambre());
                    });
                }
                System.out.println("********************");
            });
        }
        else {
            System.out.println("there is no blocs");
        }
    }
    @Scheduled(cron = "0 */5 * * * *") // Executes every 5 minutes
    public void pourcentageChambreParTypeChambre(){
        List<Chambre> chambres = getChambres();

        long allchambres = chambres.size();
        if(allchambres == 0) {
            long simpleChambre = chambres.stream().filter(chambre -> chambre.getTypeChambre().equals(TypeChambre.SIMPLE)).count();
            long doubleChambre = chambres.stream().filter(chambre -> chambre.getTypeChambre().equals(TypeChambre.DOUBLE)).count();
            long tripleChambre = chambres.stream().filter(chambre -> chambre.getTypeChambre().equals(TypeChambre.TRIPLE)).count();
            System.out.println("nombre totale de chambre " + allchambres);
            System.out.println("le pourcentage de chambre de type simple :" + (simpleChambre * 100) / allchambres);
            System.out.println("le pourcentage de chambre de type double :" + (doubleChambre * 100) / allchambres);
            System.out.println("le pourcentage de chambre de type triple :" + (tripleChambre * 100) / allchambres);
        }else System.out.println("there is no chambres");
    }


    @Scheduled(cron = "0 */5 * * * *") // Executes every 5 minutes

    public void nbrePlacesDisponibleParChambreAnneeEnCours(){
        List<Chambre> chambres = getChambres();
        if(chambres.size()==0) {
            chambres.stream().filter(chambre -> chambre.getTypeChambre().equals(TypeChambre.SIMPLE)).forEach(chambre -> {
                if (chambre.getReservations() != null)
                    System.out.println("La Chambre simple" + chambre.getNumeroChambre() + "est complete");
                else
                    System.out.println("Le nombre de place disponible pour la chambre simple" + chambre.getNumeroChambre() + "est 1");
            });
            chambres.stream().filter(chambre -> chambre.getTypeChambre().equals(TypeChambre.DOUBLE)).forEach(chambre -> {
                if (chambre.getReservations() != null)
                    System.out.println("La Chambre double" + chambre.getNumeroChambre() + "est complete");
                else
                    System.out.println("Le nombre de place disponible pour la chambre double" + chambre.getNumeroChambre() + "est 2");
            });
            chambres.stream().filter(chambre -> chambre.getTypeChambre().equals(TypeChambre.TRIPLE)).forEach(chambre -> {
                if (chambre.getReservations() != null)
                    System.out.println("La Chambre Triple" + chambre.getNumeroChambre() + "est complete");
                else
                    System.out.println("Le nombre de place disponible pour la chambre Triple" + chambre.getNumeroChambre() + "est 3");
            });
        }
    }

    @Override
    public Chambre getChambreById(Long id) {
        return chambreRepository.findById(id).get();
    }

    @Override
    public Chambre addChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public Chambre updateChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public void deleteChambre(Long id) {
        chambreRepository.deleteById(id);
    }










}
