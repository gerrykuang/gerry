package com.numberone.system.service;

import java.util.List;

import com.numberone.system.domain.SysMaintenance;
/**
 * 
 * @author Q18020504
 *
 */
public interface ISysMaintenanceService {
    /**
     * 根据条件分页查询系統聯繫人
     * 
     * @param Maintenance 系統聯繫人
     * @return 系統聯繫人集合信息
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
     * 批量刪除系統聯繫人
     * @param ids
     * @return
     */
    public int sysMaintenanceDeletes(String ids) throws Exception;;
}
