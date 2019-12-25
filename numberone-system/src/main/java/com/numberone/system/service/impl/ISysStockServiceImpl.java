package com.numberone.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.numberone.system.domain.SysStock;
import com.numberone.system.mapper.SysStockMapper;
import com.numberone.system.service.ISysStockService;

/**
 * @author Q19030520
 * 庫存管理service實現層
 */

@Service
public class ISysStockServiceImpl implements ISysStockService{
	
	@Autowired
	private SysStockMapper stockMapper;
	
	@Override
	public List<SysStock> selectStockList(SysStock stock) {
		return stockMapper.selectStockList(stock);
	}
	
}
