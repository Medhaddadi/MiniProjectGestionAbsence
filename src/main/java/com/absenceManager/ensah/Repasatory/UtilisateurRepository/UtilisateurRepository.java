package com.absenceManager.ensah.Repasatory.UtilisateurRepository;

import com.absenceManager.ensah.Entity.Utilisateur;
import com.absenceManager.ensah.Models.ModelUtilisateur;
import org.springframework.beans.PropertyValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{
    @Query("select  u from Utilisateur u where u.nom like %?1% or u.prenom like %?1% or u.nomArabe like %?1% or u.prenomArabe like %?1% or u.email like %?1% or u.telephone like %?1%")
    List<Utilisateur> findAllByKeySearch(String search);
}
