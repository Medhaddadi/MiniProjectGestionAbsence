package com.absenceManager.ensah.Services.Impl;

import com.absenceManager.ensah.Entity.Role;
import com.absenceManager.ensah.Models.ModelRole;
import com.absenceManager.ensah.Repasatory.RoleRepository;
import com.absenceManager.ensah.Services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImp implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<ModelRole> getAllRoles() {
        return roleRepository.findAll().stream().map(this::roleToModelRole).collect(Collectors.toList());
    }

    //conver Role to ModelRole
    public ModelRole roleToModelRole(Role role) {

        return ModelRole.builder()
                .idRole(role.getId())
                .nomRole(role.getNom())
                .createdAt(role.getCreatedAt())
                .updatedAt(role.getUpdatedAt())
                .deletedAt(role.getDeletedAt())
                .build();
    }

    @Override
    public ModelRole getRole(Long roleId) {
        return roleToModelRole(roleRepository.findById(roleId).get());
    }

    @Override
    public void saveRole(ModelRole role) {
        roleRepository.save(modelRoleToRole(role));
    }

    @Override
    public ModelRole getRoleById(Long id) {
        return roleToModelRole(roleRepository.findById(id).get());
    }

    @Override
    public void deleteRole(Long id) {
        // get the element by id and change the deleteAt
        Role role = roleRepository.findById(id).get();
        role.setDeletedAt(java.time.LocalDateTime.now());
        roleRepository.save(role);
    }

    @Override
    public List<ModelRole> getAllRolesNotDeleted() {
        return roleRepository.findAllByDeletedAtIsNull().stream().map(this::roleToModelRole).collect(Collectors.toList());
    }

    //conver ModelRole to Role
    public Role modelRoleToRole(ModelRole modelRole) {
        return Role.builder()
                .id(modelRole.getIdRole())
                .nom(modelRole.getNomRole())
                .build();
    }

}
