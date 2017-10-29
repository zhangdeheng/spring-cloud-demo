package org.zdh.customermgr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.zdh.common.pageutil.Page;
import org.zdh.customermgr.service.ICustomerService;
import org.zdh.customermgr.vo.CustomerModel;
import org.zdh.customermgr.vo.CustomerQueryModel;
@Service
public class Client {
	@Autowired
	private ICustomerService c=null;
	public static void main(String[] args) {
		ApplicationContext act=new ClassPathXmlApplicationContext("applicationContext.xml");
		Client t=(Client)act.getBean("client");
//		Customer c=new Customer();
//		c.setCustomerId("2");
//		c.setPwd("c1");
//		c.setRegisterTime("2017-01-01");
//		c.setTrueName("c1");
//		t.customerDAO.create(c);
		CustomerQueryModel cq=new CustomerQueryModel();
		cq.getPage().setPageShow(3);
		Page<CustomerModel> list=t.c.getByConditionPage(cq);
		System.out.println("list:"+list+"\ncq:"+cq.getPage());
		Page<CustomerModel> list2=t.c.getByConditionPage(cq);
	}
}
