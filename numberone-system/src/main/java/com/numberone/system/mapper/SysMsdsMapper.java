package com.numberone.system.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.StringHolder;

import com.numberone.system.domain.SysMsds;

public interface SysMsdsMapper {
	/**
     * 根据条件分页查询MSDS
     * 
     * @param MSDS 異常信息
     * @return MSDS数据集合信息
     */
    public List<SysMsds> selectMsdsList(SysMsds msdsid);
    /**
     * 上傳PDF檔時，更新MSDS number
     * @param msdsid
     * @return
     */
    public int updateMsds(@Param("msdsid")Long msdsid,@Param("msds")String msds,@Param("updateBy")String updateBy,@Param("startTime")Date startTime,@Param("days")Long days );
    /**
     * 查詢MSD by msdsid
     * @param msdsid
     * @return
     */
    public String selectMsdsById(Long msdsid);
    /**
     * 查詢MSDS by msds
     * @param msds
     * @return
     */
    public SysMsds selectMsdsByMsds(String msds);
	 /**
	  * 新增MSDS
	  * @param msdsid
	  * @return
	  */
	 public int insertMsds(SysMsds msdsid);
	 
	 /**
	  * 查詢料號
	  * @param msdsid
	  * @return
	  */
	 public String selectMaterialById(Long msdsid);
}
