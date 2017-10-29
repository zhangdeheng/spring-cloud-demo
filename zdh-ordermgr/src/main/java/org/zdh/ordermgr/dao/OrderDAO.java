package org.zdh.ordermgr.dao;

import org.springframework.stereotype.Repository;
import org.zdh.common.dao.BaseDAO;

import org.zdh.ordermgr.vo.OrderModel;
import org.zdh.ordermgr.vo.OrderQueryModel;

@Repository
public interface OrderDAO extends BaseDAO<OrderModel,OrderQueryModel>{
	
}
