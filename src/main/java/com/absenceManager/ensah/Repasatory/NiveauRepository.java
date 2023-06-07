package com.absenceManager.ensah.Repasatory;

import com.absenceManager.ensah.Entity.Niveau;
import com.absenceManager.ensah.Models.ModelNiveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface NiveauRepository extends JpaRepository<Niveau,Long>{

    @Query("select n from Niveau n where n.deletedAt is null ")
    List<Niveau> findAllWhereDeletedIsNull();

    @Query("select n from Niveau n where n.deletedAt is null and (n.alias like %?1% or n.filiere.codeFiliere like %?1% or n.titre like %?1% or n.filiere.codeFiliere like %?1%)")
    List<Niveau> findAllWhereDeletedIsNullAndQuery();
}
