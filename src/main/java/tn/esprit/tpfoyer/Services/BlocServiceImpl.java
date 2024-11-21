package tn.esprit.tpfoyer.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.Entity.Bloc;
import tn.esprit.tpfoyer.Repositories.BlocRepository;

import java.util.List;
@Service
@AllArgsConstructor
@Slf4j
public class BlocServiceImpl implements IBlocService{

    BlocRepository blocRepository;

    @Override
    public List<Bloc> getBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc getBlocById(Long id) {
        return blocRepository.findById(id).get();
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public void deleteBloc(Long id) {
        blocRepository.deleteById(id);
        System.out.println("bloc deleted succeff");
    }




    @Scheduled(fixedRate = 60000)
    public List<Bloc> retrieveAllBlocs(){
        List<Bloc> blocs = getBlocs();
        blocs.stream().forEach(bloc -> log.info(bloc.toString()));
        return blocs;
    }



}
