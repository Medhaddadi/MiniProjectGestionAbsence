package com.absenceManager.ensah.Repasatory;

import com.absenceManager.ensah.Entity.Role;
import org.springframework.beans.PropertyValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role> findAllByDeletedAtIsNull();
}
