package com.numberone.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.numberone.common.support.Convert;
import com.numberone.system.domain.SysMaintenance;
import com.numberone.system.mapper.SysMaintenanceMapper;
import com.numberone.system.service.ISysMaintenanceService;

@Service
public class SysMaintenanceServiceImpl implements ISysMaintenanceService{
	@Autowired
    private SysMaintenanceMapper maintenanceMapper;
	
    /**
     * 分页查询系統管理員
     */
    @Override
    public List<SysMaintenance> selectMaintenanceList(SysMaintenance employeeid)
    {
    	return maintenanceMapper.selectMaintenanceList(employeeid);
    }
    /**
     * 新增系統聯繫人
     * 
     * @param 工號
     * @return 结果
     */
    @Override
    public int insertMaintenance(SysMaintenance employeeid){
    	return maintenanceMapper.insertMaintenance(employeeid);
    }
    /**
     * 檢查系統聯繫人
     * 
     * @param 工號
     * @return 结果
     */
    @Override
    public SysMaintenance selectMaintenanceId(String employeeid){
    	return maintenanceMapper.selectMaintenanceId(employeeid);
    }
    /**
     * 修改系統聯繫人
     * @param employeeid
     * @return
     */
    @Override
    public int updateMaintenance(SysMaintenance employeeid){
    	return maintenanceMapper.updateMaintenance(employeeid);
    }
    /**
     * 批量刪除系統聯繫人
     * @param ids
     * @return
     */
    public int sysMaintenanceDeletes(String ids){
    	String[] employeeid=Convert.toStrArray(ids);
    	return maintenanceMapper.sysMaintenanceDeletes(employeeid);
    }
}
