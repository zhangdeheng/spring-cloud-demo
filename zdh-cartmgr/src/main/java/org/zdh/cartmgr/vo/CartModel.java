package org.zdh.cartmgr.vo;

import org.zdh.common.vo.BaseModel;

public class CartModel extends BaseModel{
	private Integer customerUuid;
	private Integer goodsUuid;
	private Integer buyNum;
	
	public void setCustomerUuid(Integer obj){
		this.customerUuid = obj;
	}
	public Integer getCustomerUuid(){
		return this.customerUuid;
	}
	
	public void setGoodsUuid(Integer obj){
		this.goodsUuid = obj;
	}
	public Integer getGoodsUuid(){
		return this.goodsUuid;
	}
	
	public void setBuyNum(Integer obj){
		this.buyNum = obj;
	}
	public Integer getBuyNum(){
		return this.buyNum;
	}
	
	
	
	public String toString(){
		return "Model"+this.getClass().getName()+"[customerUuid=" + this.getCustomerUuid() + ",goodsUuid=" + this.getGoodsUuid() + ",buyNum=" + this.getBuyNum() + ",]";
	}	
}
