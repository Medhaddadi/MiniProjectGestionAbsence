package com.absenceManager.ensah.Repasatory;

import com.absenceManager.ensah.Entity.CadreAdministrateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadreAdministrateurRepository extends JpaRepository<CadreAdministrateur, Long> {
}
