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
import com.numberone.system.domain.SysDemand;
import com.numberone.system.domain.SysMaintenance;
import com.numberone.system.domain.SysMaterial;
import com.numberone.system.domain.SysSafetyStock;
import com.numberone.system.service.ISysSafetyStockService;

/**
 * 安全庫存維護
 * @author Q18020504
 *
 */
@Controller
@RequestMapping("/mtdata/safetyStock")
public class SaftyStockUpload extends BaseController{
	private String prefix = "mtdata/safetyStock";
	
	@Autowired
	private ISysSafetyStockService safetyStockService;
	
	@RequiresPermissions("mtdata:safetyStock:view")
	@GetMapping()
	public String safetyStock()
	{
		return prefix + "/safetyStock";
	}

	@RequiresPermissions("mtdata:safetyStock:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SysSafetyStock sfstock_id)
	{
		startPage();
		List<SysSafetyStock> list = safetyStockService.selectSafetyStockList(sfstock_id);
		return getDataTable(list);
	}
	
	
	 /**
     * 新增安全庫存
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }
    
    /**
     * 新增保存安全庫存
     */
    @RequiresPermissions("mtdata:safetyStock:add")
    @Log(title = "安全庫存管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult addSave(SysSafetyStock material)
    {
    	material.setCreateBy(ShiroUtils.getLoginName());
        ShiroUtils.clearCachedAuthorizationInfo();
        return toAjax(safetyStockService.insertSafetyStock(material));

    }
    
    /**
     * 修改安全庫存
     */
    @GetMapping("/edit/{sfstock_id}")
    public String edit(@PathVariable("sfstock_id") Long sfstock_id, ModelMap mmap)
    {
    	
        mmap.put("safetyStock", safetyStockService.selectSafetyStockId(sfstock_id));
        return prefix + "/edit";
    }

    /**
     * 修改保存安全庫存
     */
    @RequiresPermissions("mtdata:safetyStock:edit")
    @Log(title = "安全庫存管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult editSave(SysSafetyStock sfstock_id)
    {	
    	sfstock_id.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(safetyStockService.updateSafetyStock(sfstock_id));
    }
    
    /**
     * 导出安全庫存
     */
    @Log(title = "安全庫存管理", businessType = BusinessType.EXPORT)
    @RequiresPermissions("mtdata:safetyStock:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysSafetyStock safetyStock)
    {
        List<SysSafetyStock> list = safetyStockService.selectSafetyStockList(safetyStock);
        ExcelUtil<SysSafetyStock> util = new ExcelUtil<SysSafetyStock>(SysSafetyStock.class);
        return util.exportExcel(list, "安全庫存");
    }
    
	
}
