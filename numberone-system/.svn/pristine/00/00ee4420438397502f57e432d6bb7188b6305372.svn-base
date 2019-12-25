package com.numberone.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.numberone.common.constant.FcmsConstants;
import com.numberone.system.domain.SysDemand;
import com.numberone.system.mapper.SysDemandMapper;
import com.numberone.system.service.ISysDemandService;

@Service
public class SysDemandServiceImpl implements ISysDemandService{
	@Autowired
    private SysDemandMapper demandMapper;
	
	/**
	 * 分頁查詢每月需求量
	 * @param demand_id
	 * @return
	 */
	@Override
	public List<SysDemand> selectDemandList(SysDemand demand_id){
		return demandMapper.selectDemandList(demand_id);
	}
	@Override
	public String checkMaterial(String company,String material){
	
		System.out.println(material+" __ "+company);
    	int count=demandMapper.checkMaterial(company,material);
        if (count > 0)
        {
            return FcmsConstants.COMPANY_MATERIAL_NOT_EXIST;
        }
        return FcmsConstants.COMPANY_MATERIAL_EXIST;
	}
	@Override
	public int insertDemand(SysDemand demand) {
		return demandMapper.insertDemand(demand);
	}
}
