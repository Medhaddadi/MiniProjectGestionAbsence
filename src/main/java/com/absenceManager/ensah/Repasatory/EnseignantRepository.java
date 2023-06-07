package com.absenceManager.ensah.Repasatory;

import com.absenceManager.ensah.Entity.Compte;
import com.absenceManager.ensah.Entity.Enseignant;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.PropertyValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant, Long>{

    @Query("select  e from Enseignant e where e.identifiant like %?1% ")
    List<Enseignant> getAllEnseignantByKeySearch(String search);
}
