package com.numberone.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.numberone.common.annotation.Excel;
import com.numberone.common.base.BaseEntity;

public class SysCapacity extends BaseEntity{
	private static final long serialVersionUID = 1L;
	@Excel(name = "公司")
	private String company;
	@Excel(name = "年份")
	private String income_year;
	@Excel(name = "月份")
	private String income_month;
	@Excel(name = "產能數量")
	private String income_qty;
	@Excel(name = "備註")
	private String remark;


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public String getIncome_year() {
		return income_year;
	}


	public void setIncome_year(String income_year) {
		this.income_year = income_year;
	}


	public String getIncome_month() {
		return income_month;
	}


	public void setIncome_month(String income_month) {
		this.income_month = income_month;
	}


	public String getIncome_qty() {
		return income_qty;
	}


	public void setIncome_qty(String income_qty) {
		this.income_qty = income_qty;
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
  
            .append("company",getCompany())
            .append("income_year", getIncome_year())
            .append("income_month", getIncome_month())
            .append("income_qty", getIncome_qty())           
            .append("remark",getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
