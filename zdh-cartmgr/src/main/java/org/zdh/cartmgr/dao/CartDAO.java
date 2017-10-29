package org.zdh.cartmgr.dao;

import org.springframework.stereotype.Repository;
import org.zdh.common.dao.BaseDAO;

import org.zdh.cartmgr.vo.CartModel;
import org.zdh.cartmgr.vo.CartQueryModel;

@Repository
public interface CartDAO extends BaseDAO<CartModel,CartQueryModel>{
	
}
