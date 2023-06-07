package com.absenceManager.ensah.Repasatory;

import com.absenceManager.ensah.Entity.Coordination;
import com.absenceManager.ensah.Models.ModelCoordination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoordinationRepository extends JpaRepository<Coordination, Long> {

    @Query("select c from Coordination c where c.deletedAt is null")
    List<Coordination> getAllCoordination();
}
