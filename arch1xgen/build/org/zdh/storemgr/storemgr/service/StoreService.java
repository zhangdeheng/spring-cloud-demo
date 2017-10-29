package org.zdh.storemgr.storemgr.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.zdh.common.service.BaseService;

import org.zdh.storemgr.storemgr.dao.StoreDAO;
import org.zdh.storemgr.storemgr.vo.StoreModel;
import org.zdh.storemgr.storemgr.vo.StoreQueryModel;

@Service
@Transactional
public class StoreService extends BaseService<StoreModel,StoreQueryModel> implements IStoreService{
	private StoreDAO dao = null;
	@Autowired
	private void setDao(StoreDAO dao){
		this.dao = dao;
		super.setDao(dao);
	}
	
}