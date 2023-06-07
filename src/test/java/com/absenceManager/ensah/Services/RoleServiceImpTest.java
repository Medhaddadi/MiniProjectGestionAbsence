package com.absenceManager.ensah.Services;

import com.absenceManager.ensah.Models.ModelRole;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class RoleServiceImpTest {
    @Autowired
    private RoleService roleService;

    @Test
    void addRole() {
        Faker faker = new Faker();
        for (int i = 0; i < 5; i++) {
            ModelRole role =  ModelRole
                    .builder()
                    .nomRole(faker.name().title())
                    .build();
            roleService.saveRole(role);
        }
    }
    @Test
    void getAllRoles() {
        // get all roles from the database and print them
        roleService.getAllRoles().forEach(role -> System.out.println(role.getNomRole()));
    }
}