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
import com.numberone.system.domain.SysMaterial;
import com.numberone.system.service.ISysMaterialService;

/**
 * 料號維護
 * @author Q18020504
 *
 */

@Controller
@RequestMapping("/mtdata/material")
public class MaterialUpload  extends BaseController{
	 private String prefix = "mtdata/material";
	 	
	   @Autowired
	   private ISysMaterialService materialService;
	 
	    @RequiresPermissions("mtdata:material:view")
	    @GetMapping()
	    public String material()
	    {
	        return prefix + "/material";
	    }

	    @RequiresPermissions("mtdata:material:list")
	    @PostMapping("/list")
	    @ResponseBody
	    public TableDataInfo list(SysMaterial material)
	    {
	        startPage();
	        List<SysMaterial> list = materialService.selectMaterialList(material);
	        return getDataTable(list);
	    }
	    
	    /**
	     * 新增物料
	     */
	    @GetMapping("/add")
	    public String add()
	    {
	        return prefix + "/add";
	    }
	    
	    /**
	     * 新增保存物料
	     */
	    @RequiresPermissions("mtdata:material:add")
	    @Log(title = "物料管理", businessType = BusinessType.INSERT)
	    @PostMapping("/add")
	    @Transactional(rollbackFor = Exception.class)
	    @ResponseBody
	    public AjaxResult addSave(SysMaterial material)
	    {
	    	material.setCreateBy(ShiroUtils.getLoginName());
	        ShiroUtils.clearCachedAuthorizationInfo();
	        return toAjax(materialService.insertMaterial(material));

	    }
	    
	    /**
	     * 导出物料
	     */
	    @Log(title = "物料管理", businessType = BusinessType.EXPORT)
	    @RequiresPermissions("mtdata:material:export")
	    @PostMapping("/export")
	    @ResponseBody
	    public AjaxResult export(SysMaterial material)
	    {
	        List<SysMaterial> list = materialService.selectMaterial();
	        ExcelUtil<SysMaterial> util = new ExcelUtil<SysMaterial>(SysMaterial.class);
	        return util.exportExcel(list, "物料数据");
	    }
	    
	    /**
	     * 检验物料是否存在
	     */
	    @PostMapping("/checkMaterialUnique")
	    @ResponseBody
	    public String checkMaterialUnique(String material)
	    {	
	    	
	        return materialService.checkMaterialUnique(material);
	    }
	    /**
	     * 删除物料
	     * @param ids
	     * @return
	     */
	    @RequiresPermissions("mtdata:material:remove")
	    @Log(title = "物料管理", businessType = BusinessType.DELETE)
	    @PostMapping("/remove")
	    @ResponseBody
	    public AjaxResult remove(String ids)//参数名必须是ids？？？？？
	    {
	        try
	        {
	            return toAjax(materialService.SysMaterialDeletes(ids));
	        }
	        catch (Exception e)
	        {
	            return error(e.getMessage());
	        }
	    }
	    /**
	     * 修改物料
	     */
	    @GetMapping("/edit/{material}")
	    public String edit(@PathVariable("material") String material, ModelMap mmap)
	    {
	    	
	        mmap.put("material", materialService.selectMaterialId(material));
	        return prefix + "/edit";
	    }

	    /**
	     * 修改保存物料
	     */
	    @RequiresPermissions("mtdata:material:edit")
	    @Log(title = "物料管理", businessType = BusinessType.UPDATE)
	    @PostMapping("/edit")
	    @Transactional(rollbackFor = Exception.class)
	    @ResponseBody
	    public AjaxResult editSave(SysMaterial material)
	    {	
	    	material.setUpdateBy(ShiroUtils.getLoginName());
	        return toAjax(materialService.updateMaterial(material));
	    }
}
