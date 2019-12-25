package com.numberone.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.numberone.system.domain.SysUseReport;
import com.numberone.system.mapper.SysUseReportMapper;
import com.numberone.system.service.ISysUseReportService;

@Service
public class SysUseReportServiceImpl implements ISysUseReportService{
	
	@Autowired
	private SysUseReportMapper useReportMapper;
	
	/**
	 * 分頁查詢useReport
	 * @param useReport
	 * @return
	 */
	@Override
	public List<SysUseReport> selectUseReportList(SysUseReport useReport){
		
		return useReportMapper.selectUseReportList(useReport);
	}
}
