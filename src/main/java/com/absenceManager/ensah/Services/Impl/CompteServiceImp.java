package com.absenceManager.ensah.Services.Impl;

import com.absenceManager.ensah.Entity.Compte;
import com.absenceManager.ensah.Entity.Role;
import com.absenceManager.ensah.Entity.Utilisateur;
import com.absenceManager.ensah.Models.ModelCompte;
import com.absenceManager.ensah.Models.ModelUtilisateur;
import com.absenceManager.ensah.Repasatory.CompteRepository;
import com.absenceManager.ensah.Repasatory.RoleRepository;
import com.absenceManager.ensah.Repasatory.UtilisateurRepository.UtilisateurRepository;
import com.absenceManager.ensah.Services.CompteService;
import com.absenceManager.ensah.helpers.CompteManagerHelper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
public class CompteServiceImp implements CompteService {

    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private RoleRepository roleRepository;



    @Autowired
    private UtilisateurRepository utilisateurRepository;


    @Override
    public List<ModelCompte> getAllComptes() {
        return compteRepository.findAll().stream().map(CompteServiceImp::compteToCompteM).toList();
    }

    @Override
    public String addCompte(Long idRole, Long idUtilisateur) {
        Utilisateur utilisateur = utilisateurRepository.findById(idUtilisateur).get();
        Role role = roleRepository.findById(idRole).get();
        Compte compte = new Compte();
        List<String> Logins = compteRepository.geAllLogins();
        compte.setLogin(CompteManagerHelper.genarateLogin(utilisateur.getNom(), utilisateur.getPrenom(),Logins));
        String GenaratePassword = CompteManagerHelper.genaratePassword();
        compte.setRole(role);
        compte.setProprietaire(utilisateur);
        compteRepository.save(compte);
        return GenaratePassword;
    }

    @Override
    public void deleteCompte(Long id) {

    }

    @Override
    public void updateCompte(ModelCompte compte) {

    }

    @Override
    public Compte getCompte(Long id) {
        return null;
    }


    @Override
    public void creerCompte(ModelCompte compte) {
        compteRepository.save(compteMToCompte(compte));
    }

    @Override
    public List<String> getAllComptesLogin() {
        return  compteRepository.findAllNomRoles();
    }

    public static Compte compteMToCompte(ModelCompte modelCompte) {
        return Compte.builder()
                .id(modelCompte.getId())
                .login(modelCompte.getLogin())
                .password(modelCompte.getPassword())
                .build();
    }


    public static ModelCompte compteToCompteM(Compte compte) {
        return ModelCompte.builder()
                .login(compte.getLogin())
                .password(compte.getPassword())
                .id(compte.getId())
                .build();

    }
}
