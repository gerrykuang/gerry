package com.numberone.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.numberone.system.domain.SysUsageReport;
import com.numberone.system.mapper.SysUsageReportMapper;
import com.numberone.system.service.ISysUsageReportService;
/**
 * 化學品用量報表
 * @author Q18020504
 *
 */
@Service
public class SysUsageReportServiceImpl implements ISysUsageReportService{
	
	@Autowired
	private	SysUsageReportMapper usageReportMapper;
	
	/**
	 * 分頁查詢usageReport
	 * @param usageReport
	 * @return
	 */
	@Override
	public List<SysUsageReport> selectUsageReportList(SysUsageReport usageReport){
		return usageReportMapper.selectUsageReportList(usageReport); 
	}
}
