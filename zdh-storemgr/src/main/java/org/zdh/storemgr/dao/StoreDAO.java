package org.zdh.storemgr.dao;

import org.springframework.stereotype.Repository;
import org.zdh.common.dao.BaseDAO;
import org.zdh.storemgr.vo.StoreModel;
import org.zdh.storemgr.vo.StoreQueryModel;

@Repository
public interface StoreDAO extends BaseDAO<StoreModel,StoreQueryModel>{
	
}
