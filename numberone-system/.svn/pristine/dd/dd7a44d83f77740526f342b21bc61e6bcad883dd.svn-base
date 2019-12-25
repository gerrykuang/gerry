package com.numberone.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.numberone.common.annotation.Excel;
import com.numberone.common.base.BaseEntity;

public class SysDemand extends BaseEntity{
	
	private static final long serialVersionUID = 1L;
	private long demand_id;
	@Excel(name="公司別")
	private String company;
	@Excel(name="物料")
	private String	material;
	@Excel(name="別名")
	private String	trade_name;
	@Excel(name="類別")
	private String	category;
	@Excel(name="計量單位")
	private String	unit;
	@Excel(name="年份")
	private String	demand_year;
	@Excel(name="月份")
	private String	demand_month;
	@Excel(name="需求數量")
	private int demand_qty;
	@Excel(name="保養頻率")
	private String	maintenan_freq;
	@Excel(name="單次食用量")
	private String	singleuse_qty;
	@Excel(name="備註")
	private String	remark;
	public long getDemand_id() {
		return demand_id;
	}
	public void setDemand_id(long demand_id) {
		this.demand_id = demand_id;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getDemand_year() {
		return demand_year;
	}
	public void setDemand_year(String demand_year) {
		this.demand_year = demand_year;
	}
	public String getDemand_month() {
		return demand_month;
	}
	public void setDemand_month(String demand_month) {
		this.demand_month = demand_month;
	}
	public int getDemand_qty() {
		return demand_qty;
	}
	public void setDemand_qty(int demand_qty) {
		this.demand_qty = demand_qty;
	}
	public String getMaintenan_freq() {
		return maintenan_freq;
	}
	public void setMaintenan_freq(String maintenan_freq) {
		this.maintenan_freq = maintenan_freq;
	}
	public String getSingleuse_qty() {
		return singleuse_qty;
	}
	public void setSingleuse_qty(String singleuse_qty) {
		this.singleuse_qty = singleuse_qty;
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
            .append("demand_id", getDemand_id())
            .append("company",getCompany())
            .append("material", getMaterial())
            .append("category", getCategory())
            .append("trade_name", getTrade_name())            
            .append("unit", getUnit())
            .append("demand_year",getDemand_year())
            .append("demand_month", getDemand_month())
            .append("demand_qty", getDemand_qty())
            .append("maintenan_freq", getMaintenan_freq())            
            .append("singleuse_qty", getSingleuse_qty())
            .append("remark",getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
