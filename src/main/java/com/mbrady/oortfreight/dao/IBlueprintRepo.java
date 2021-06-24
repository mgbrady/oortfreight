package com.mbrady.oortfreight.dao;

import com.mbrady.oortfreight.models.Blueprint;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlueprintRepo extends JpaRepository<Blueprint, Long>{
    Blueprint findBlueprintByShipyardId(Long id);
}
