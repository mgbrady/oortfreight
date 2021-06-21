package com.mbrady.oortfreight.dao;

import com.mbrady.oortfreight.models.Shipyard;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IShipyardRepo extends JpaRepository<Shipyard, Long>{
}
