package org.zdh.customermgr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zdh.common.service.BaseService;
import org.zdh.customermgr.dao.CustomerDAO;
import org.zdh.customermgr.vo.CustomerModel;
import org.zdh.customermgr.vo.CustomerQueryModel;
@Service
@Transactional
public class CustomerService extends BaseService<CustomerModel, CustomerQueryModel> implements ICustomerService{
	private CustomerDAO dao=null;
	@Autowired
	private void setDao(CustomerDAO dao){
		this.dao=dao;
		super.setDao(dao);
	}
	
	
	
}
