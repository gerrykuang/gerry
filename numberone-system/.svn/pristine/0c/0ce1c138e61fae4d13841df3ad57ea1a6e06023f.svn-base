package com.numberone.system.service;

import java.util.List;

import com.numberone.system.domain.SysException;

public interface ISysExceptionService {
	
	public List<SysException> selectExceptionList(SysException exception);//insertException
	public int insertException(SysException exception);
	
	/** 通过EXCEPTION_ID获取异常*/
	public SysException selectExceptionByID(long execption_id);
	
	/** 更新SysException*/
	public void updateException(SysException exception);
	
	/**批量導入異常記錄*/
	public String importExcetion(List<SysException> list, String operateName);
}
