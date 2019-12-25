package com.numberone.system.mapper;

import java.util.List;

import com.numberone.system.domain.SysMaintenance;

public interface SysMaintenanceMapper {
	
	/**
     * 根据条件分页查询異常信息
     * 
     * @param exception 異常信息
     * @return 異常数据集合信息
     */
    public List<SysMaintenance> selectMaintenanceList(SysMaintenance employeeid);
    /**
     * 新增系統聯繫人
     * 
     * @param 工號
     * @return 结果
     */
    public int insertMaintenance(SysMaintenance employeeid);
    /**
     * 檢查系統聯繫人
     * 
     * @param 工號
     * @return 结果
     */
    public SysMaintenance selectMaintenanceId(String employeeid);
    /**
     * 修改系統聯繫人
     * @param employeeid
     * @return
     */
    public int updateMaintenance(SysMaintenance employeeid);
    /**
     * 刪除系統聯繫人
     * @param ids
     * @return
     */
    public int sysMaintenanceDeletes(String[] employeeid);
}
