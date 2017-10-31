package org.zdh.customermgr.service;

import org.zdh.common.service.IBaseService;
import org.zdh.customermgr.vo.CustomerModel;
import org.zdh.customermgr.vo.CustomerQueryModel;

public interface ICustomerService extends IBaseService<CustomerModel, CustomerQueryModel>{
	public CustomerModel getByCustomerId(String customerId);
}
