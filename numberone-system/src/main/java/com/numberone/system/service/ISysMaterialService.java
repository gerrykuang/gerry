package com.numberone.system.service;

import java.util.List;
import java.util.Set;

import com.numberone.system.domain.SysMaterial;

public interface ISysMaterialService {
	/**
	 * 查询所有的物料
	 *  
	 */
	public List<SysMaterial> selectMaterial();
	public List<SysMaterial> selectMaterialList(SysMaterial material);
	public SysMaterial selectMaterialId(String material);
	public int insertMaterial(SysMaterial material);
    /**
     * 检查料号是否唯一
     * @ material 物料id
     * @return 结果
     */
    public String checkMaterialUnique(String material);
    
    /**
     * 批量删除物料信息
     * 
     * @param material
     * @return 结果
     * @throws Exception 异常
     */
    public int SysMaterialDeletes(String ids);
    public int updateMaterial(SysMaterial material);
}
