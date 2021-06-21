package com.mbrady.oortfreight.dao;

import com.mbrady.oortfreight.models.Bluprint;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlueprintRepo extends JpaRepository<Bluprint, Long>{
}
