package com.numberone.system.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.numberone.system.domain.SysDept;
import com.numberone.system.domain.SysMsds;
import com.numberone.system.mapper.SysDeptMapper;
import com.numberone.system.mapper.SysMsdsMapper;
import com.numberone.system.service.ISysMsdsService;

@Service
public class SysMsdsServiceImpl implements ISysMsdsService {

	 @Autowired
	 private SysMsdsMapper sysMsdsMapper;
	 @Override
	 public List<SysMsds> selectMsdsList(SysMsds msdsid)
	    {
	        return sysMsdsMapper.selectMsdsList(msdsid);
	    }
	    /**
	     * 上傳PDF檔時，更新MSDS number
	     * @param msdsid
	     * @return
	     */
	 @Override
	  public int updateMsds(Long msdsid,String msds,String updateBy,Date startTime,Long days){
		  //System.out.println(msdsid);
		  return sysMsdsMapper.updateMsds(msdsid,msds,updateBy,startTime,days);
	  }
	 
	    /**
	     * 查詢MSD by msdsid
	     * @param msdsid
	     * @return
	     */
	 @Override
	 public String selectMsdsById(Long msdsid){
		 return sysMsdsMapper.selectMsdsById(msdsid);
	 }
	    /**
	     * 查詢MSDS by msds
	     * @param msds
	     * @return
	     */
	 @Override
	 public SysMsds selectMsdsByMsds(String msds){
		 return sysMsdsMapper.selectMsdsByMsds(msds);
	 }
	 
	 /**
	  * 新增MSDS
	  * @param msdsid
	  * @return
	  */
	 @Override
	 public int insertMsds(SysMsds msdsid){
		 return sysMsdsMapper.insertMsds(msdsid);
	 }
	 /**
	  * 查詢料號
	  * @param msdsid
	  * @return
	  */
	 @Override
	 public String selectMaterialById(Long msdsid){
		 return sysMsdsMapper.selectMaterialById(msdsid);
	 }
}
