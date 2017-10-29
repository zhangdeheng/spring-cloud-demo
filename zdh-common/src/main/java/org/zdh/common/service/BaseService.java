package org.zdh.common.service;

import java.util.List;

import org.zdh.common.dao.BaseDAO;
import org.zdh.common.pageutil.Page;
import org.zdh.common.vo.BaseModel;
/**
 * 
 * @author zdh
 *
 * @param <M> model
 * @param <QM>modelQuery
 */
public class BaseService<M,QM extends BaseModel> implements IBaseService<M,QM> {

	private BaseDAO<M, QM> dao=null;
	public void setDao(BaseDAO<M, QM> dao){
		this.dao=dao;
	}
	@Override
	public void create(M c) {
		dao.create(c);
	}
	@Override
	public void update(M c) {
		dao.update(c);
	}
	@Override
	public void delete(int uuid) {
		dao.delete(uuid);
	}
	@Override
	public M getByUuid(int uuid) {
		return dao.getByUuid(uuid);
	}
	@Override
	public Page<M> getByConditionPage(QM cq) {
		List<M> list=dao.getByConditionPage(cq);
		cq.getPage().setResult(list);
		return cq.getPage();
	}

	
}
