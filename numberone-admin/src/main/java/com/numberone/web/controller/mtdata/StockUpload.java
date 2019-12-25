package com.numberone.web.controller.mtdata;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.numberone.common.annotation.Log;
import com.numberone.common.base.AjaxResult;
import com.numberone.common.enums.BusinessType;
import com.numberone.common.page.TableDataInfo;
import com.numberone.common.utils.poi.ExcelUtil;
import com.numberone.framework.web.base.BaseController;
import com.numberone.system.domain.SysSafetyStock;
import com.numberone.system.domain.SysStock;
import com.numberone.system.service.ISysStockService;

/**SAP_STOCK和EMS_STOCK维护
 * @author Q19030520
 *
 */
@Controller
@RequestMapping("/mtdata/stock")
public class StockUpload extends BaseController{
	private String prefix = "mtdata/stock";
	
	@Autowired
	private ISysStockService stockService;
	
	@RequiresPermissions("mtdata:stock:view")
	@GetMapping
	public String stock(){
		return prefix+"/stock";
	}
	
	@RequiresPermissions("mtdata:stock:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SysStock stock){
		startPage();
		List<SysStock> list = stockService.selectStockList(stock);
		return getDataTable(list);
	}
	
    /**
     * 导出庫存報表
     */
    @Log(title = "庫存管理報表", businessType = BusinessType.EXPORT)
    @RequiresPermissions("mtdata:stock:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysStock stock)
    {
        List<SysStock> list = stockService.selectStockList(stock);
        ExcelUtil<SysStock> util = new ExcelUtil<SysStock>(SysStock.class);
        return util.exportExcel(list, "庫存報表");
    }
}
