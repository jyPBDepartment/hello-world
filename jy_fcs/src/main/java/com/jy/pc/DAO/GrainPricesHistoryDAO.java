package com.jy.pc.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jy.pc.Entity.GrainPricesHistoryEntity;

public interface GrainPricesHistoryDAO extends JpaRepository<GrainPricesHistoryEntity,String>{

	@Query(value="select * from sas_grain_prices_history t where t.id=?1",nativeQuery = true)
	public GrainPricesHistoryEntity findInfoById(String id);
}