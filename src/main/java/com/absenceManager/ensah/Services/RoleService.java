package com.absenceManager.ensah.Services;

import java.util.List;
import com.absenceManager.ensah.Models.ModelRole;
public interface RoleService {
    List<ModelRole> getAllRoles();

    ModelRole getRole(Long roleId);

    void saveRole(ModelRole role);

    ModelRole getRoleById(Long id);

    void deleteRole(Long id);

    List<ModelRole> getAllRolesNotDeleted();
}
