package com.numberone.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.numberone.common.annotation.Excel;
import com.numberone.common.base.BaseEntity;

public class SysSafetyStock extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private Long sfstock_id;
	@Excel(name="公司別")
	private String company;
	@Excel(name="物料")
	private String	material;
	@Excel(name="別名")
	private String	trade_name;
	@Excel(name="安全庫存")
	private String sfstock_qty;
	@Excel(name="計量單位")
	private String unit;
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getSfstock_qty() {
		return sfstock_qty;
	}
	public void setSfstock_qty(String sfstock_qty) {
		this.sfstock_qty = sfstock_qty;
	}
	public Long getSfstock_id() {
		return sfstock_id;
	}
	public void setSfstock_id(Long sfstock_id) {
		this.sfstock_id = sfstock_id;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getTrade_name() {
		return trade_name;
	}
	public void setTrade_name(String trade_name) {
		this.trade_name = trade_name;
	}
	
	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("sfstock_id", getSfstock_id())
            .append("company",getCompany())
            .append("material", getMaterial())           
            .append("trade_name", getTrade_name())  
            .append("sfstock_qty", getSfstock_qty())
            .append("unit", getUnit())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
	
}