package com.numberone.system.mapper;

import java.util.List;

import com.numberone.system.domain.SysUsageReport;


/**
 * 
 * @author Q18020504
 *
 */
public interface SysUsageReportMapper {
	/**
	 * 分頁查詢usageReport
	 * @param usageReport
	 * @return
	 */
	public List<SysUsageReport> selectUsageReportList(SysUsageReport usageReport);
}
