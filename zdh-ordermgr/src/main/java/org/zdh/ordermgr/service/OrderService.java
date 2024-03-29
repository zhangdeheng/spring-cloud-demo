package org.zdh.ordermgr.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zdh.common.service.BaseService;
import org.zdh.ordermgr.dao.OrderDAO;
import org.zdh.ordermgr.queue.QueueSender;
import org.zdh.ordermgr.vo.OrderModel;
import org.zdh.ordermgr.vo.OrderQueryModel;

@Service
@Transactional
public class OrderService extends BaseService<OrderModel,OrderQueryModel> implements IOrderService{
	private OrderDAO dao = null;
	@Autowired
	private void setDao(OrderDAO dao){
		this.dao = dao;
		super.setDao(dao);
	}
	public void order(int customerUuid) {
		//消息的 生产者
		for(int i=0;i<100;i++){
			QueueSender.sendMsg(customerUuid);
		}
	}
}