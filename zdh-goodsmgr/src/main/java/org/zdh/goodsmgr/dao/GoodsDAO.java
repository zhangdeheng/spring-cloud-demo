package org.zdh.goodsmgr.dao;

import org.springframework.stereotype.Repository;
import org.zdh.common.dao.BaseDAO;
import org.zdh.goodsmgr.vo.GoodsModel;
import org.zdh.goodsmgr.vo.GoodsQueryModel;

@Repository
public interface GoodsDAO extends BaseDAO<GoodsModel,GoodsQueryModel>{
	
}
