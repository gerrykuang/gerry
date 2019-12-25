package com.numberone.system.domain;

import java.io.Serializable;

import com.numberone.common.annotation.Excel;

/** Ems_Stock 和 Sap_Stock
 * 不繼承BaseEntity類
 * @author Q19030520
 */
public class SysStock implements Serializable{

	private static final long serialVersionUID = 1L;

	/*
	 * CREATE TABLE VW_STOCK_REPORT
(
  COMPANY        VARCHAR2(10),
  MATERIAL       VARCHAR2(30),
  CATEGORY       VARCHAR2(20),
  TRADE_NAME     VARCHAR2(40),
  WAREHOUSE      VARCHAR2(4),
  SFSTOCK_QTY    NUMBER(15),
  CURSTOCK_QTY   NUMBER(15),
  THIS_MON_USED  NUMBER(15),
  THIS_MON_AVAIL NUMBER(15),
  DEMAND_QTY     NUMBER(15),
  GAP_QTY        NUMBER(15),
  GAP_RATE       NUMBER(15),
  SUGGEST_QTY    NUMBER(15)
);
*/
	@Excel(name = "公司別")
	private String company;
	@Excel(name = "物料號碼")
	private String material;
	@Excel(name = "類別")
	private String category;
	@Excel(name = "品名")
	private String trade_name;
	@Excel(name = "庫別")
	private String warehouse;
	@Excel(name = "安全存儲上限")
	private String sfStock_qty;
	@Excel(name = "當前庫存數量")
	private String curStock_qty;
	@Excel(name = "本月已領用量")
	private String this_mon_used;
	@Excel(name = "本月待領用量")
	private String this_mon_avail;
	@Excel(name = "下月需求")
	private String demand_qty;
	@Excel(name = "GAP")
	private String gap_qty;
	@Excel(name = "下月佔比")
	private String gap_rate;
	@Excel(name = "建議請購數量")
	private String suggest_qty;
	
	
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTrade_name() {
		return trade_name;
	}
	public void setTrade_name(String trade_name) {
		this.trade_name = trade_name;
	}
	public String getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}
	public String getsfStock_qty() {
		return sfStock_qty;
	}
	public void setsfStock_qty(String sfStock_qty) {
		this.sfStock_qty = sfStock_qty;
	}
	public String getCurStock_qty() {
		return curStock_qty;
	}
	public void setCurStock_qty(String curStock_qty) {
		this.curStock_qty = curStock_qty;
	}
	public String getThis_mon_used() {
		return this_mon_used;
	}
	public void setThis_mon_used(String this_mon_used) {
		this.this_mon_used = this_mon_used;
	}
	public String getThis_mon_avail() {
		return this_mon_avail;
	}
	public void setThis_mon_avail(String this_mon_avail) {
		this.this_mon_avail = this_mon_avail;
	}
	public String getDemand_qty() {
		return demand_qty;
	}
	public void setDemand_qty(String demand_qty) {
		this.demand_qty = demand_qty;
	}
	public String getGap_qty() {
		return gap_qty;
	}
	public void setGap_qty(String gap_qty) {
		this.gap_qty = gap_qty;
	}
	public String getGap_rate() {
		return gap_rate;
	}
	public void setGap_rate(String gap_rate) {
		this.gap_rate = gap_rate;
	}
	public String getSuggest_qty() {
		return suggest_qty;
	}
	public void setSuggest_qty(String suggest_qty) {
		this.suggest_qty = suggest_qty;
	}
	
}
