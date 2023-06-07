package com.absenceManager.ensah.Repasatory;

import com.absenceManager.ensah.Entity.Filiere;
import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface FiliereRepository extends JpaRepository<Filiere,Long> {

    @Query("select f from Filiere f where f.idFiliere=?1 and f.deletedAt is null")
    Filiere findByIdWhereDeleteAtNull(long l);

    @Query("select f from Filiere f where f.deletedAt is null")
    List<Filiere> findAllWhereDeleteAtNull();


    @Query("select f from Filiere f where f.deletedAt is null and f.titreFiliere like %?1% or f.codeFiliere like %?1% ")
    List<Filiere> findAllWhereDeleteAtNullAndNomContains(String query);
}
