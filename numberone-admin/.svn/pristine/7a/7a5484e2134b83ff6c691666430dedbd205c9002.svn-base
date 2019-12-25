package com.numberone.web.controller.mtdata;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
import com.numberone.framework.web.base.BaseController;
import com.numberone.system.domain.SysMaterial;
import com.numberone.system.domain.SysUseReport;
import com.numberone.system.service.ISysCapacityService;
import com.numberone.system.service.ISysUseReportService;
@Controller
@RequestMapping("/mtdata/useReport")
public class UseReportController extends BaseController{
	private String prefix = "mtdata/useReport";
	@Autowired
	private ISysUseReportService useReportService;
	
	
	@RequiresPermissions("mtdata:useReport:view")
	@GetMapping()
	public String useReport()
	{
		System.out.println("ddd");
		return prefix + "/useReport";
	}
	@RequiresPermissions("mtdata:useReport:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SysUseReport useReport)
	{
		startPage();
		List<SysUseReport> list = useReportService.selectUseReportList(useReport);
		System.out.println(useReport.toString());
		//System.out.println(co);
		return  getDataTable(list);
	}
	
/*     
         导出使用量報表
     
    @Log(title = "物料管理", businessType = BusinessType.EXPORT)
    @RequiresPermissions("mtdata:useReport:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysUseReport useReport)
    {	System.out.println("ddd");
        List<SysUseReport> list = useReportService.selectUseReportList(useReport);
        ExcelUtil<SysUseReport> util = new ExcelUtil<SysUseReport>(SysUseReport.class);
        return util.exportExcel(list, "使用量報表");
    }*/
}
