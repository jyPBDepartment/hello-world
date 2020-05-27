package com.jy.pc.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jy.pc.Entity.SalesEntity;



public interface SalesService {
	/**
	 * 公共/常用的方法
	 * 
	 * */
	public void save(SalesEntity salesEntity);
	public void update(SalesEntity salesEntity);
	public void delete(String id);
	public List<SalesEntity> findAll();
	public SalesEntity findBId(String id);
	public Page<SalesEntity> findListByName(String name,String phone,Pageable pageable);
}