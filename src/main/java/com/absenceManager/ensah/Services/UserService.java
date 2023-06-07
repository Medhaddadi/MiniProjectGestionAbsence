package com.absenceManager.ensah.Services;

import com.absenceManager.ensah.Models.ModelUtilisateur;

public interface UserService {
    ModelUtilisateur findByEmail(String email);

    void save(ModelUtilisateur user);
}
