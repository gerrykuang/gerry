package com.numberone.web.controller.mtdata;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.numberone.common.annotation.Log;
import com.numberone.common.base.AjaxResult;
import com.numberone.common.enums.BusinessType;
import com.numberone.common.page.TableDataInfo;
import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.framework.util.ShiroUtils;
import com.numberone.framework.web.base.BaseController;
import com.numberone.system.domain.SysMaintenance;
import com.numberone.system.domain.SysMaterial;
import com.numberone.system.service.ISysMaintenanceService;

/**
 * 系統聯繫人維護
 * @author Q18020504
 *
 */
@Controller
@RequestMapping("/mtdata/maintenance")
public class MaintenanceUpload extends BaseController{
	private String prefix = "mtdata/maintenance";
	
	@Autowired
	private ISysMaintenanceService maintenanceService;
	 
	@RequiresPermissions("mtdata:maintenance:view")
	@GetMapping()
	public String maintenance()
	{
		return prefix + "/maintenance";
	}

	@RequiresPermissions("mtdata:maintenance:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SysMaintenance employeeid)
	{
		startPage();
		List<SysMaintenance> list = maintenanceService.selectMaintenanceList(employeeid);
		return getDataTable(list);
	}
	
    /**
     * 新增
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }
    
	/**
	 * 新增保存
	 */
    @RequiresPermissions("mtdata:maintenance:add")
	@Log(title = "系統聯繫人管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@Transactional(rollbackFor = Exception.class)
	@ResponseBody
	public AjaxResult addSave(SysMaintenance employeeid)
    {
    	employeeid.setCreateBy(ShiroUtils.getLoginName());
        ShiroUtils.clearCachedAuthorizationInfo();
        return toAjax(maintenanceService.insertMaintenance(employeeid));

    }
    
    /**
     * 修改系統聯繫人
     */
    @GetMapping("/edit/{employeeid}")
    public String edit(@PathVariable("employeeid") String employeeid, ModelMap mmap)
    {	
    	//System.out.println("xxx");
        mmap.put("maintenance", maintenanceService.selectMaintenanceId(employeeid));
        //System.out.println("x1x");
        return prefix + "/edit";
       
    }

    /**
     * 修改保存系統聯繫人
     */
    @RequiresPermissions("mtdata:maintenance:edit")
    @Log(title = "系統聯繫人", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult editSave(SysMaintenance employeeid)
    {
        return toAjax(maintenanceService.updateMaintenance(employeeid));
    }
	
    /**
     * 批量删除系統聯繫人
     * @param ids
     * @return
     */
    @RequiresPermissions("mtdata:maintenance:remove")
    @Log(title = "系統聯繫人管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)//参数名必须是ids？？？？？
    {
        try
        {
            return toAjax(maintenanceService.sysMaintenanceDeletes(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }
	
	
    /**
     * 导出系統聯繫人
     */
    @Log(title = "系統聯繫人管理", businessType = BusinessType.EXPORT)
    @RequiresPermissions("mtdata:maintenance:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysMaintenance maintenance)
    {
        List<SysMaintenance> list = maintenanceService.selectMaintenanceList(maintenance);
        ExcelUtil<SysMaintenance> util = new ExcelUtil<SysMaintenance>(SysMaintenance.class);
        return util.exportExcel(list, "系統聯繫人");
    }
    
	
	
	
	
}
