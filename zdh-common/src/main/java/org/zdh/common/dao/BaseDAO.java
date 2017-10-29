package org.zdh.common.dao;

import java.util.List;

public interface BaseDAO<M,QM> {
	public void create(M c);
	
	public void update(M c);
	
	public void delete(int uuid);
	
	public M getByUuid(int uuid);
	
	public List<M> getByConditionPage(QM cq);
}
