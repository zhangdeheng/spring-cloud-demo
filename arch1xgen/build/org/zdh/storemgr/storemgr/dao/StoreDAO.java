package org.zdh.storemgr.storemgr.dao;

import org.springframework.stereotype.Repository;
import org.zdh.common.dao.BaseDAO;

import org.zdh.storemgr.storemgr.vo.StoreModel;
import org.zdh.storemgr.storemgr.vo.StoreQueryModel;

@Repository
public interface StoreDAO extends BaseDAO<StoreModel,StoreQueryModel>{
	
}
