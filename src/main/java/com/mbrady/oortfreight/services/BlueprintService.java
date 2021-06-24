package com.mbrady.oortfreight.services;

import com.mbrady.oortfreight.models.Blueprint;
import com.mbrady.oortfreight.dao.IBlueprintRepo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class BlueprintService {
    @Autowired
    IBlueprintRepo blueprintRepo;

    public List<Blueprint> getAllBlueprints() {
        return blueprintRepo.findAll();
    }

    public void removeBlueprint(Long id) {
        blueprintRepo.deleteById(id);
    }

    public void saveBlueprint(Blueprint blueprint) {
        blueprintRepo.save(blueprint);
    }
}