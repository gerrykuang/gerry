package com.numberone.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.numberone.common.annotation.Excel;
import com.numberone.common.base.BaseEntity;


public class SysUseReport extends BaseEntity{
	private static final long serialVersionUID = 1L;
	
	@Excel(name="公司別")
	private String company;
	@Excel(name="物料")
	private String	material;
	@Excel(name="別名")
	private String	trade_name;
	@Excel(name="領用部門ID")
	private String to_wh_deptid;
	@Excel(name="1月需求")
	private String jan_demand_qty;
	@Excel(name="1月實際")
	private String jan_actual_qty;
	
	@Excel(name="2月需求")
	private String feb_demand_qty;
	@Excel(name="2月實際")
	private String feb_actual_qty;
	
	@Excel(name="3月需求")
	private String mar_demand_qty;
	@Excel(name="3月實際")
	private String mar_actual_qty;
	@Excel(name="4月需求")
	private String apr_demand_qty;
	@Excel(name="4月實際")
	private String apr_actual_qty;
	@Excel(name="5月需求")
	private String may_demand_qty;
	@Excel(name="5月實際")
	private String may_actual_qty;
	
	@Excel(name="6月需求")
	private String jun_demand_qty;
	@Excel(name="6月實際")
	private String jun_actual_qty;
	@Excel(name="7月需求")
	private String jul_demand_qty;
	@Excel(name="7月實際")
	private String jul_actual_qty;
	@Excel(name="8月需求")
	private String aug_demand_qty;
	@Excel(name="8月實際")
	private String aug_actual_qty;
	@Excel(name="9月需求")
	private String sep_demand_qty;
	@Excel(name="9月實際")
	private String sep_actual_qty;
	@Excel(name="10月需求")
	private String oct_demand_qty;
	@Excel(name="10月實際")
	private String oct_actual_qty;
	
	@Excel(name="11月需求")
	private String nov_demand_qty;
	@Excel(name="11月實際")
	private String nov_actual_qty;
	@Excel(name="12月需求")
	private String dec_demand_qty;
	@Excel(name="12月實際")
	private String dec_actual_qty;
	
	
	private String demand_year;
	private String demand_month;
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
	public String getTo_wh_deptid() {
		return to_wh_deptid;
	}
	public void setTo_wh_deptid(String to_wh_deptid) {
		this.to_wh_deptid = to_wh_deptid;
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
	
	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            
            .append("company",getCompany())
            .append("material", getMaterial())   
            .append("trade_name", getTrade_name())                      
            .append("demand_year",getDemand_year())
            .append("demand_month", getDemand_month())
            .append("jan_demand_qty", getJan_demand_qty()) 
            .append("jan_actual_qty", getJan_actual_qty())
            .append("feb_demand_qty", getFeb_demand_qty())
            .append("feb_actual_qty", getFeb_actual_qty()) 
            .append("mar_demand_qty", getMar_demand_qty()) 
            .append("mar_actual_qty", getMar_actual_qty())
            .append("apr_demand_qty", getApr_demand_qty())
            .append("apr_actual_qty", getApr_actual_qty())
            .append("may_demand_qty", getMay_demand_qty()) 
            .append("may_actual_qty", getMay_actual_qty())
            .append("jun_demand_qty", getJun_demand_qty())
            .append("jun_actual_qty", getJun_actual_qty())
            .append("jul_demand_qty", getJul_demand_qty())
            .append("jul_actual_qty", getJul_actual_qty())
            .append("aug_demand_qty", getAug_demand_qty())
            .append("aug_actual_qty", getAug_actual_qty())
            .append("sep_demand_qty", getSep_demand_qty())
            .append("sep_actual_qty", getSep_actual_qty())            
            .append("dec_demand_qty", getDec_demand_qty())
            .append("dec_actual_qty", getDec_actual_qty())
            .append("nov_demand_qty", getNov_demand_qty())
            .append("nov_actual_qty", getNov_actual_qty())
            .append("oct_demand_qty", getOct_demand_qty())
            .append("oct_actual_qty", getOct_actual_qty())           
            .append("to_wh_deptid", getTo_wh_deptid())
            .append("remark",getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
	public String getOct_demand_qty() {
		return oct_demand_qty;
	}
	public void setOct_demand_qty(String oct_demand_qty) {
		this.oct_demand_qty = oct_demand_qty;
	}
	public String getOct_actual_qty() {
		return oct_actual_qty;
	}
	public void setOct_actual_qty(String oct_actual_qty) {
		this.oct_actual_qty = oct_actual_qty;
	}
	public String getNov_demand_qty() {
		return nov_demand_qty;
	}
	public void setNov_demand_qty(String nov_demand_qty) {
		this.nov_demand_qty = nov_demand_qty;
	}
	public String getNov_actual_qty() {
		return nov_actual_qty;
	}
	public void setNov_actual_qty(String nov_actual_qty) {
		this.nov_actual_qty = nov_actual_qty;
	}
	public String getDec_demand_qty() {
		return dec_demand_qty;
	}
	public void setDec_demand_qty(String dec_demand_qty) {
		this.dec_demand_qty = dec_demand_qty;
	}
	public String getDec_actual_qty() {
		return dec_actual_qty;
	}
	public void setDec_actual_qty(String dec_actual_qty) {
		this.dec_actual_qty = dec_actual_qty;
	}
	public String getAug_demand_qty() {
		return aug_demand_qty;
	}
	public void setAug_demand_qty(String aug_demand_qty) {
		this.aug_demand_qty = aug_demand_qty;
	}
	public String getAug_actual_qty() {
		return aug_actual_qty;
	}
	public void setAug_actual_qty(String aug_actual_qty) {
		this.aug_actual_qty = aug_actual_qty;
	}
	public String getSep_demand_qty() {
		return sep_demand_qty;
	}
	public void setSep_demand_qty(String sep_demand_qty) {
		this.sep_demand_qty = sep_demand_qty;
	}
	public String getSep_actual_qty() {
		return sep_actual_qty;
	}
	public void setSep_actual_qty(String sep_actual_qty) {
		this.sep_actual_qty = sep_actual_qty;
	}
	public String getMay_demand_qty() {
		return may_demand_qty;
	}
	public void setMay_demand_qty(String may_demand_qty) {
		this.may_demand_qty = may_demand_qty;
	}
	public String getMay_actual_qty() {
		return may_actual_qty;
	}
	public void setMay_actual_qty(String may_actual_qty) {
		this.may_actual_qty = may_actual_qty;
	}
	public String getJun_demand_qty() {
		return jun_demand_qty;
	}
	public void setJun_demand_qty(String jun_demand_qty) {
		this.jun_demand_qty = jun_demand_qty;
	}
	public String getJun_actual_qty() {
		return jun_actual_qty;
	}
	public void setJun_actual_qty(String jun_actual_qty) {
		this.jun_actual_qty = jun_actual_qty;
	}
	public String getJul_demand_qty() {
		return jul_demand_qty;
	}
	public void setJul_demand_qty(String jul_demand_qty) {
		this.jul_demand_qty = jul_demand_qty;
	}
	public String getJul_actual_qty() {
		return jul_actual_qty;
	}
	public void setJul_actual_qty(String jul_actual_qty) {
		this.jul_actual_qty = jul_actual_qty;
	}
	public String getMar_demand_qty() {
		return mar_demand_qty;
	}
	public void setMar_demand_qty(String mar_demand_qty) {
		this.mar_demand_qty = mar_demand_qty;
	}
	public String getMar_actual_qty() {
		return mar_actual_qty;
	}
	public void setMar_actual_qty(String mar_actual_qty) {
		this.mar_actual_qty = mar_actual_qty;
	}
	public String getApr_demand_qty() {
		return apr_demand_qty;
	}
	public void setApr_demand_qty(String apr_demand_qty) {
		this.apr_demand_qty = apr_demand_qty;
	}
	public String getApr_actual_qty() {
		return apr_actual_qty;
	}
	public void setApr_actual_qty(String apr_actual_qty) {
		this.apr_actual_qty = apr_actual_qty;
	}
	public String getJan_demand_qty() {
		return jan_demand_qty;
	}
	public void setJan_demand_qty(String jan_demand_qty) {
		this.jan_demand_qty = jan_demand_qty;
	}
	public String getJan_actual_qty() {
		return jan_actual_qty;
	}
	public void setJan_actual_qty(String jan_actual_qty) {
		this.jan_actual_qty = jan_actual_qty;
	}
	public String getFeb_demand_qty() {
		return feb_demand_qty;
	}
	public void setFeb_demand_qty(String feb_demand_qty) {
		this.feb_demand_qty = feb_demand_qty;
	}
	public String getFeb_actual_qty() {
		return feb_actual_qty;
	}
	public void setFeb_actual_qty(String feb_actual_qty) {
		this.feb_actual_qty = feb_actual_qty;
	}
	
	
}
