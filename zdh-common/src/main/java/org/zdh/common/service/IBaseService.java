package org.zdh.common.service;

import org.zdh.common.pageutil.Page;
import org.zdh.common.vo.BaseModel;

public interface IBaseService<M,QM extends BaseModel> {
	
	public void create(M c);
	
	public void update(M c);
	
	public void delete(int uuid);
	
	public M getByUuid(int uuid);
	
	public Page<M> getByConditionPage(QM cq);
}
