package org.zdh.cartmgr.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zdh.cartmgr.dao.CartDAO;
import org.zdh.cartmgr.vo.CartModel;
import org.zdh.cartmgr.vo.CartQueryModel;
import org.zdh.common.service.BaseService;

@Service
@Transactional
public class CartService extends BaseService<CartModel,CartQueryModel> implements ICartService{
	private CartDAO dao = null;
	@Autowired
	private void setDao(CartDAO dao){
		this.dao = dao;
		super.setDao(dao);
	}
	
}