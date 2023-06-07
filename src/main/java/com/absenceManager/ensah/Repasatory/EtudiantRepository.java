package com.absenceManager.ensah.Repasatory;


import com.absenceManager.ensah.Entity.Etudiant;
import org.springframework.beans.PropertyValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long>{

    @Query("select  e from Etudiant e where e.cne like %?1%")
    List<Etudiant> findAllByKeySearch(String search);
    @Query("select  e from Etudiant e where e.cne like %?1% and e.deletedAt is  null")
    List<Etudiant> findAllByCne(String cne);

    @Query("select  e from Etudiant e where e.nom like %?1% and e.deletedAt is  null")
    List<Etudiant> findAllByPnom(String pnom);

    @Query("select  e from Etudiant e where e.prenom like %?1% and e.deletedAt is  null")
    List<Etudiant> findAllByNom(String nom);

    @Query("select  e from Etudiant e where e.deletedAt is  null")
    List<Etudiant> getAll();

    @Query("select  e from Etudiant e where e.id = ?1 and e.deletedAt is  null")
    List<Etudiant> findByClasse(String classe);
}
