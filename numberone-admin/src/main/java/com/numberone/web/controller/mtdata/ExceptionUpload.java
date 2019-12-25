package com.numberone.web.controller.mtdata;

import java.util.Date;
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
import org.springframework.web.multipart.MultipartFile;

import com.numberone.common.annotation.Log;
import com.numberone.common.base.AjaxResult;
import com.numberone.common.enums.BusinessType;
import com.numberone.common.page.TableDataInfo;
import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.framework.util.ShiroUtils;
import com.numberone.framework.web.base.BaseController;
import com.numberone.system.domain.SysException;
import com.numberone.system.service.ISysExceptionService;

/**
 * 異常上傳
 * @author Q18020504
 *
 */
@Controller
@RequestMapping("/mtdata/exception")
public class ExceptionUpload   extends BaseController{
	
	private String prefix = "mtdata/exception";
	 	
	@Autowired
	private ISysExceptionService exceptionService;
	 
	@RequiresPermissions("mtdata:exception:view")
	@GetMapping()
	public String exception()
	{
		return prefix + "/exception";
	}

	@RequiresPermissions("mtdata:exception:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SysException exception)
	{
		startPage();
		List<SysException> list = exceptionService.selectExceptionList(exception);
		return getDataTable(list);
	}
	   
	 /**
     * 修改異常
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") long EXCEPTION_ID, ModelMap modelMap)
    {
    	SysException sysException = exceptionService.selectExceptionByID(EXCEPTION_ID);
    	
    	modelMap.put("sysException", sysException);
        return prefix + "/edit";
    }
    
    /**
     * 修改並保存異常
     */
    @RequiresPermissions("mtdata:exception:edit")
    @Log(title = "異常管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult editSave(SysException exception)
    {/*
    	exception.setCreateBy(ShiroUtils.getLoginName());
        ShiroUtils.clearCachedAuthorizationInfo();
        
        return toAjax(exceptionService.insertException(exception));
        */
    	exception.setUpdate_by(getLoginName());
    	exception.setUpdate_time(new Date());
    	exceptionService.updateException(exception);
    	//System.out.println("Exception:\n"+exception);
    	/* 前台上傳的確實是"create_by"，單接收到的確實"createBy"
    	 * 初步猜測：查詢的時候SysException對象瘋轉進了ModelMap中，
    	 * 前台使用了ModelMap中的對象SysException對象進行展示，
    	 * 修改後，上傳的name也是展示時使用的屬性名，自己設置的name被覆蓋掉*/
    	//exception.setCreate_by(exception.getCreateBy()); //更新時，使用的是createBy，所以這一行廢棄
        return toAjax(true);
    }
	
	 /**
     * 新增異常
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }
    
    /**
     * 新增保存異常
     */
    @RequiresPermissions("mtdata:exception:add")
    @Log(title = "異常管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult addSave(SysException exception)
    {
    	exception.setCreate_by(ShiroUtils.getLoginName());
        ShiroUtils.clearCachedAuthorizationInfo();
        
        exception.setCreate_by(getLoginName());
        exception.setCreate_time(new Date());
        return toAjax(exceptionService.insertException(exception));
    }
	
    @Log(title="異常管理", businessType=BusinessType.EXPORT)
    @RequiresPermissions("mtdata:exception:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult exportExcel(SysException exception){
    	List<SysException> list = exceptionService.selectExceptionList(exception);
    	ExcelUtil<SysException> excelUtil = new ExcelUtil<>(SysException.class);
    	/*excelUtil.setUseCurrentTimeNameFile(true);
    	excelUtil.setCurrentTimeFormate(DateUtils.YYYYMMDDHHMMSS);*/
    	AjaxResult result = excelUtil.exportExcel(list, "異常清單");
    	return result;
    }
    
    @Log(title="異常管理", businessType=BusinessType.IMPORT)
    @RequiresPermissions("mtdata:exception:import")
    @PostMapping("/import")
   // @Transactional(rollbackFor=Exception.class)
    @ResponseBody
    public AjaxResult importExcel(MultipartFile file) throws Exception {
    	ExcelUtil<SysException> excelUtil = new ExcelUtil<>(SysException.class);
    	List<SysException> list = excelUtil.importExcel(file.getInputStream());
    	
    	String operName = getSysUser().getLoginName();
    	String message = exceptionService.importExcetion(list, operName);
    	
    	return AjaxResult.success(message);
    }
    
}
