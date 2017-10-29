package org.zdh.ordermgr.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.zdh.common.service.BaseService;

import org.zdh.ordermgr.dao.OrderDetailDAO;
import org.zdh.ordermgr.vo.OrderDetailModel;
import org.zdh.ordermgr.vo.OrderDetailQueryModel;

@Service
@Transactional
public class OrderDetailService extends BaseService<OrderDetailModel,OrderDetailQueryModel> implements IOrderDetailService{
	private OrderDetailDAO dao = null;
	@Autowired
	private void setDao(OrderDetailDAO dao){
		this.dao = dao;
		super.setDao(dao);
	}
	
}