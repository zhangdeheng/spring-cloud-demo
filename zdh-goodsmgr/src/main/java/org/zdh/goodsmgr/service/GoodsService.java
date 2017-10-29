package org.zdh.goodsmgr.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zdh.common.service.BaseService;
import org.zdh.goodsmgr.dao.GoodsDAO;
import org.zdh.goodsmgr.vo.GoodsModel;
import org.zdh.goodsmgr.vo.GoodsQueryModel;

@Service
@Transactional
public class GoodsService extends BaseService<GoodsModel,GoodsQueryModel> implements IGoodsService{
	private GoodsDAO dao = null;
	@Autowired
	private void setDao(GoodsDAO dao){
		this.dao = dao;
		super.setDao(dao);
	}
	
}