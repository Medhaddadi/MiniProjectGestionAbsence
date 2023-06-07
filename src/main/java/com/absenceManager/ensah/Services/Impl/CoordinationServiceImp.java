package com.absenceManager.ensah.Services.Impl;

import com.absenceManager.ensah.Models.ModelCoordination;
import com.absenceManager.ensah.Repasatory.CoordinationRepository;
import com.absenceManager.ensah.Services.CoordinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoordinationServiceImp implements CoordinationService {
    @Autowired
    private CoordinationRepository coordinationRepository;
    @Override
    public List<ModelCoordination> getAllCoordination() {
        return coordinationRepository.getAllCoordination().stream().map(ModelCoordination::new).toList();
    }
}
