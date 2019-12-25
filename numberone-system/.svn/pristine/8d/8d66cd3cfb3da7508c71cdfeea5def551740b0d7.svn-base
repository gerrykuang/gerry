package com.numberone.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.numberone.common.annotation.Excel;
import com.numberone.common.base.BaseEntity;

public class SysMaterial  extends BaseEntity{
	private static final long serialVersionUID = 1L;
	 @Excel(name = "料號")
	    private String material;
	 @Excel(name = "物料描述")
	 	private String description;
	 @Excel(name = "品名")
	 	private String trade_name;
	 @Excel(name = "管控系統")
	 	private String sys_flag;
	 @Excel(name = "類別")
	 	private String category;
	 @Excel(name="規格型號")
	 	private String spec;
	 @Excel(name="料號狀態", readConverterExp ="N=可用,Y=不可用")
	 	private String delete_flag;//safety_stock msds
	 @Excel(name="計量單位")
	 	private String unit;
	 @Excel(name="物料品牌")
	 	private String brand;
	 @Excel(name="備註")
	 	private String remark;
	



	public String getMaterial() {
		return material;
	}





	public void setMaterial(String material) {
		this.material = material;
	}





	public String getDescription() {
		return description;
	}





	public void setDescription(String description) {
		this.description = description;
	}





	public String getTrade_name() {
		return trade_name;
	}





	public void setTrade_name(String trade_name) {
		this.trade_name = trade_name;
	}





	public String getSys_flag() {
		return sys_flag;
	}





	public void setSys_flag(String sys_flag) {
		this.sys_flag = sys_flag;
	}





	public String getCategory() {
		return category;
	}





	public void setCategory(String category) {
		this.category = category;
	}


	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}





	public String getDelete_flag() {
		return delete_flag;
	}





	public void setDelete_flag(String delete_flag) {
		this.delete_flag = delete_flag;
	}





	public String getUnit() {
		return unit;
	}





	public void setUnit(String unit) {
		this.unit = unit;
	}





	public String getBrand() {
		return brand;
	}





	public void setBrand(String brand) {
		this.brand = brand;
	}





	public String getRemark() {
		return remark;
	}





	public void setRemark(String remark) {
		this.remark = remark;
	}





	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("material", getMaterial())
            .append("description", getDescription())
            .append("category", getCategory())
            .append("trade_name", getTrade_name())
            .append("sys_flag", getSys_flag())
            .append("unit", getUnit())
            .append("delete_flag", getDelete_flag())
            .append("brand", getBrand())//safety_stock
            .append("spec", getSpec())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
