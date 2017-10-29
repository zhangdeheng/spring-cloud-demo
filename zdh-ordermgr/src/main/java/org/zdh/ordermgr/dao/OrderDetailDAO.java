package org.zdh.ordermgr.dao;

import org.springframework.stereotype.Repository;
import org.zdh.common.dao.BaseDAO;

import org.zdh.ordermgr.vo.OrderDetailModel;
import org.zdh.ordermgr.vo.OrderDetailQueryModel;

@Repository
public interface OrderDetailDAO extends BaseDAO<OrderDetailModel,OrderDetailQueryModel>{
	
}
