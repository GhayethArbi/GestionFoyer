package tn.esprit.tpfoyer.Services;

import tn.esprit.tpfoyer.Entity.Universite;

import java.util.List;

public interface IUniversiteService {
    List<Universite> getUniversites();
    Universite getUniversiteById(Long id);
    Universite addUniversite(Universite universite);
    Universite updateUniversite(Universite universite);
    void deleteUniversite(Long id);
}
