package com.numberone.system.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.numberone.system.domain.SysDemand;
public interface SysDemandMapper {
	
	/**
	 * 分頁查詢每月需求量
	 * @param demand_id
	 * @return
	 */
	public List<SysDemand> selectDemandList(SysDemand demand_id);
	public int checkMaterial(@Param("company") String company,@Param("material") String material);
	/** 插入一个月份需求*/
	public int insertDemand(SysDemand demand);
}