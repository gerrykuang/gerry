package com.numberone.system.mapper;

import java.util.List;
import java.util.Set;

import com.numberone.system.domain.SysMaterial;

/**
 * 物料表 数据层
 * 
 * @author gerry
 */

public interface SysMaterialMapper {
	
	/**
	 * 查询所有的物料
	 *  
	 */
	public List<SysMaterial> selectMaterial();
	
	/**
     * 根据条件分页查询物料数据
     * 
     * @param role 物料信息
     * @return 物料数据集合信息
     */
    public List<SysMaterial> selectMaterialList(SysMaterial material);

    /**
     * 根据物料ID查询
     * 
     * @param material 
     * @return 权限列表
     */
    public SysMaterial selectMaterialId(String material);

    /**
     * 批量删除物料
     * @param material
     * @return
     */
    public int deleteMaterials(String[] material);
    
    /**
     * 新增物料
     * 
     * @param 新增物料
     * @return 结果
     */
    public int insertMaterial(SysMaterial material);
    
    /**
     * 检查料号是否唯一
     * @ material 物料id
     * @return 结果
     */
    public int checkMaterialUnique(String material);
    
    public int updateMaterial(SysMaterial material);
}
