package com.numberone.web.controller.mtdata;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
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
import com.numberone.system.domain.SysCapacity;
import com.numberone.system.domain.SysMaterial;
import com.numberone.system.service.ISysCapacityService;


/**
 * 產能數據上傳
 * @author Q18020504
 *
 */
@Controller
@RequestMapping("/mtdata/capacity")
public class CapacityUpload extends BaseController{
private String prefix = "mtdata/capacity";
	
	@Autowired
	private ISysCapacityService capacityService;
	
	@RequiresPermissions("mtdata:capacity:view")
	@GetMapping()
	public String capacity()
	{
		return prefix + "/capacity";
	}

	@RequiresPermissions("mtdata:capacity:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SysCapacity capacity)
	{
		startPage();
		List<SysCapacity> list = capacityService.selectCapacityList(capacity);
		return getDataTable(list);
	}
	
	 /**
     * 新增產能
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }
    
    /**
     * 新增保存產能
     */
    @RequiresPermissions("mtdata:capacity:add")
    @Log(title = "產能管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult addSave(SysCapacity capacity)
    {
    	capacity.setCreateBy(ShiroUtils.getLoginName());
        ShiroUtils.clearCachedAuthorizationInfo();
        return toAjax(capacityService.insertCapacity(capacity));

    }
    
    /**
     * 导出物料
     */
    @Log(title = "產能管理", businessType = BusinessType.EXPORT)
    @RequiresPermissions("mtdata:capacity:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysCapacity capacity)
    {
        List<SysCapacity> list = capacityService.selectCapacityList(capacity);
        ExcelUtil<SysCapacity> util = new ExcelUtil<SysCapacity>(SysCapacity.class);
        return util.exportExcel(list, "產能数据");
    }
    
    
}
