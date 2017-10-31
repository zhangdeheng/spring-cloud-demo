package org.zdh.customermgr.dao;

import org.springframework.stereotype.Repository;
import org.zdh.common.dao.BaseDAO;
import org.zdh.customermgr.vo.CustomerModel;
import org.zdh.customermgr.vo.CustomerQueryModel;
@Repository
public interface CustomerDAO extends BaseDAO<CustomerModel, CustomerQueryModel>{
	public CustomerModel getByCustomerId(String customerId);
}
