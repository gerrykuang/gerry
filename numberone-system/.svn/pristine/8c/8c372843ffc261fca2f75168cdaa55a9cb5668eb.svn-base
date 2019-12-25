package com.numberone.system.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.numberone.common.annotation.Excel;
import com.numberone.common.base.BaseEntity;

public class SysException extends BaseEntity{
	
	private static final long serialVersionUID = 1L;
	//ID exception_id
	/*
	private Long exception;
	@Excel(name="料號")
	private String material;
	@Excel(name="品名")
	private String trade_name;
	@Excel(name="數量")
	private String quantity; //QTY
	@Excel(name="異常原因")
	private String exception_case;
	@Excel(name="處理方法")
	private String handle_action;
	@Excel(name="處理人員")
	private String create_by;
	@Excel(name="發生時間")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date create_time;
	*/
	//異常ID
	private long exception_id;
	
	@Excel(name="公司代碼")
	private String company;
	@Excel(name="物料號碼")
	private String material;
	@Excel(name="物料品名")
	private String trade_name;
	@Excel(name="異常數量")
	private String qty;
	//單位 默認PCS
	@Excel(name="計量單位")
	private String unit="PCS";
	//處理人員
	@Excel(name="處理人員")
	private String handle_by;
	//異常時間
	@Excel(name="異常時間", dateFormat="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date exception_time;
	//異常原因
	@Excel(name="異常原因")
	private String exception_case;
	@Excel(name="處理方法")
	private String handle_action;
	@Excel(name="創建者")
	private String create_by;
	@Excel(name="創建時間", dateFormat="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date create_time;
	
	@Excel(name="更新者")
	private String update_by;
	@Excel(name="更新時間", dateFormat="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date update_time;
	@Excel(name="備註")
	private String remark;

	public long getException_id() {
		return exception_id;
	}

	public void setException_id(long exception_id) {
		this.exception_id = exception_id;
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

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public String getHandle_by() {
		return handle_by;
	}	
	public void setHandle_by(String handle_by) {
		this.handle_by = handle_by;
	}
	
	public String getException_case() {
		return exception_case;
	}
	
	public void setException_case(String exception_case) {
		this.exception_case = exception_case;
	}
	
	public Date getException_time() {
		return exception_time;
	}
	
	public void setException_time(Date exception_time) {
		this.exception_time = exception_time;
	}

	public String getHandle_action() {
		return handle_action;
	}

	public void setHandle_action(String handle_action) {
		this.handle_action = handle_action;
	}

	public String getCreate_by() {
		return create_by;
	}

	public void setCreate_by(String create_by) {
		this.create_by = create_by;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public String getUpdate_by() {
		return update_by;
	}

	public void setUpdate_by(String update_by) {
		this.update_by = update_by;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "SysException [exception_id=" + exception_id + ", company=" + company + ", material=" + material
				+ ", trade_name=" + trade_name + ", qty=" + qty + ", unit=" + unit + ", handle_by=" + handle_by
				+ ", exception_time=" + exception_time + ", exception_case=" + exception_case + ", handle_action="
				+ handle_action + ", create_by=" + create_by + ", create_time=" + create_time + ", update_by="
				+ update_by + ", update_time=" + update_time + ", remark=" + remark + "]";
	}
}