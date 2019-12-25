package com.numberone.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.numberone.system.domain.SysSafetyStock;
import com.numberone.system.mapper.SysSafetyStockMapper;
import com.numberone.system.service.ISysSafetyStockService;

@Service
public class SysSafetyStockServiceImpl implements ISysSafetyStockService{
	
	@Autowired
	private SysSafetyStockMapper safetyStockMapper;
	/**
	 * 分頁查詢安全庫存
	 * @param sfstock_id
	 * @return
	 */
	@Override
	public List<SysSafetyStock> selectSafetyStockList(SysSafetyStock sfstock_id){
		return safetyStockMapper.selectSafetyStockList(sfstock_id);
	}
	
	/**
	 * 新增安全庫存
	 * @param material
	 * @return
	 */
	@Override
	public int insertSafetyStock(SysSafetyStock material){
		return safetyStockMapper.insertSafetyStock(material);
	}
	
	/**
	 * by sfstock_id查詢安全庫存
	 * @param sfstock_id
	 * @return
	 */
	@Override
	public SysSafetyStock selectSafetyStockId(Long sfstock_id){
		return safetyStockMapper.selectSafetyStockId(sfstock_id);
	}
	/**
	 * 修改安全庫存
	 * @param sfstock_id
	 * @return
	 */
	@Override
	public int updateSafetyStock(SysSafetyStock sfstock_id){
		return safetyStockMapper.updateSafetyStock(sfstock_id);
	}
}
