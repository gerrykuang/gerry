package com.numberone.system.mapper;

import java.util.List;

import com.numberone.system.domain.SysException;

public interface SysExceptionMapper {
	/**
     * 根据条件分页查询異常信息
     * 
     * @param exception 異常信息
     * @return 異常数据集合信息
     */
    public List<SysException> selectExceptionList(SysException exception);
    /**
     * 插入異常
     * @param exception 插入異常
     * @return 
     */
    public int insertException(SysException exception);
    
    /** 查询某个异常*/
	public SysException selectExceptionByID(long execption_id);
	
	/** 更新某個異常，null和“”字符串不會更新*/
	public int updateException(SysException sysException);
	
}
