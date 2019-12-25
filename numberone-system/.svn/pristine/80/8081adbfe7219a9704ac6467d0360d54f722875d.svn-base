package com.numberone.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.numberone.system.domain.SysCapacity;
import com.numberone.system.mapper.SysCapacityMapper;
import com.numberone.system.service.ISysCapacityService;

@Service
public class SysCapacityServiceImpl  implements ISysCapacityService{
	@Autowired
	private SysCapacityMapper capacityMapper;
	
	/**
	 * 分頁查詢產能數據
	 * @param capacity
	 * @return
	 */
	@Override
	public List<SysCapacity> selectCapacityList(SysCapacity capacity){
		return capacityMapper.selectCapacityList(capacity);
	}
	/**
	 * 新增產能
	 * @param capacity
	 * @return
	 */
	@Override
	public int insertCapacity(SysCapacity capacity){
		return capacityMapper.insertCapacity(capacity);
	}
}
