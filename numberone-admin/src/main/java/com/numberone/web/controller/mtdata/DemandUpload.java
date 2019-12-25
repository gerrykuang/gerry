package com.numberone.web.controller.mtdata;
import java.util.Date;
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
import com.numberone.framework.web.base.BaseController;
import com.numberone.system.domain.SysDemand;
import com.numberone.system.service.ISysDemandService;

/**
 * 每月需求量維護
 * @author Q18020504
 *
 */
@Controller
@RequestMapping("/mtdata/demand")
public class DemandUpload extends BaseController{
	private String prefix = "mtdata/demand";
	
	@Autowired
	private ISysDemandService demandService;
	@RequiresPermissions("mtdata:demand:view")
	@GetMapping()
	public String demand()
	{
		return prefix + "/demand";
	}

	@RequiresPermissions("mtdata:demand:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SysDemand demand_id)
	{
		startPage();
		List<SysDemand> list = demandService.selectDemandList(demand_id);
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
     * 新增
     */
    @RequiresPermissions("mtdata:demand:add")
    @Log(title = "每月需求", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult addSave(SysDemand demand)
    {
    	demand.setCreateBy(getLoginName());
    	demand.setCreateTime(new Date());
        return toAjax(demandService.insertDemand(demand));
    }
    
    
    
    /**
     * 物料驗證
     */
    @PostMapping("/checkMaterial")
    @ResponseBody
    public String checkMaterial(String company,String material)
    {	
    	System.out.println(material+" | |"+company);
        return demandService.checkMaterial(company,material);
    } 
}
