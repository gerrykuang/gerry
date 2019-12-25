package com.numberone.web.controller.mtdata;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.numberone.common.page.TableDataInfo;
import com.numberone.framework.web.base.BaseController;
import com.numberone.system.domain.SysUsageReport;
import com.numberone.system.service.ISysUsageReportService;


@Controller
@RequestMapping("/mtdata/usageReport")
public class UsageReportUpload extends BaseController{
	private String prefix = "mtdata/usageReport";
	@Autowired
	private ISysUsageReportService usageReportService;
	
	@RequiresPermissions("mtdata:usageReport:view")
	@GetMapping()
	public String usageReport()
	{
		//System.out.println("ddd");
		return prefix + "/usageReport";
	}
	@RequiresPermissions("mtdata:usageReport:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SysUsageReport usageReport)
	{
		startPage();
		List<SysUsageReport> list = usageReportService.selectUsageReportList(usageReport);
		System.out.println(usageReport.toString());
		return  getDataTable(list);
	}
}
