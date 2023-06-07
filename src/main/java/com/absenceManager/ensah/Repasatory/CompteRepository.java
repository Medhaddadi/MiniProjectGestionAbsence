package com.absenceManager.ensah.Repasatory;
import com.absenceManager.ensah.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompteRepository extends JpaRepository< Compte , Long>{
    @Query("SELECT DISTINCT c.login FROM Compte c")
    List<String> findAllNomRoles();

    Compte findByLogin(String login);

    @Query("SELECT DISTINCT c.login FROM Compte c")
    List<String> geAllLogins();
}
