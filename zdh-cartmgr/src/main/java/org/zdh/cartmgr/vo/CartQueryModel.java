package org.zdh.cartmgr.vo;

public class CartQueryModel extends CartModel {
	
	public String toString(){
		return "Model"+this.getClass().getName()+","+super.toString()+" ,[]";
	}
}
