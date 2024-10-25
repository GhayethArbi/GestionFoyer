package tn.esprit.tpfoyer.Services;

import tn.esprit.tpfoyer.Entity.Etudiant;
import java.util.List;

public interface IEtudiantService {

    List<Etudiant> getEtudiants();
    Etudiant getEtudiantById(Long id);
    Etudiant addEtudiant(Etudiant etudiant);
    Etudiant updateEtudiant(Etudiant etudiant);
    void deleteEtudiant(Long id);
}
