package com.numberone.system.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.numberone.common.annotation.Excel;
import com.numberone.common.base.BaseEntity;

public class SysMsds extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	private Long msdsid;
	
	public Long getMsdsid() {
		return msdsid;
	}

	public void setMsdsid(Long msdsid) {
		this.msdsid = msdsid;
	}

	@Excel(name = "料號")
	private String  material;
	
	@Excel(name = "品名")
	private String trade_name;
	
	@Excel(name="MSDS")
	private String msds;
	
	@Excel(name = "上傳日期", width = 30, dateFormat = "yyyy-MM-dd")
	private Date upload_time;
	
	@Excel(name = "距離下次更新時間")
	private Long next_date;

	public Long getNext_date() {
		return next_date;
	}

	public void setNext_date(Long next_date) {
		this.next_date = next_date;
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

	public String getMsds() {
		return msds;
	}

	public void setMsds(String msds) {
		this.msds = msds;
	}

	public Date getUpload_time() {
		return upload_time;
	}

	public void setUpload_time(Date upload_time) {
		this.upload_time = upload_time;
	}


	
	 @Override
	    public String toString() {
	        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
	        	.append("msdsid", getMsdsid())
	            .append("material", getMaterial())
	            .append("trade_name", getTrade_name())
	            .append("msds", getMsds())
	            .append("upload_time", getUpload_time())
	            .append("next_date", getNext_date())
	            .append("createBy", getCreateBy())
	            .append("createTime", getCreateTime())
	            .append("updateBy", getUpdateBy())
	            .append("updateTime", getUpdateTime())
	            .toString();
	    }
	
}
