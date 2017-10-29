package org.zdh.common.pageutil;

import java.util.Collections;
import java.util.List;
/**
 * 
 * @author zdh
 *
 * @param <E>
 */
public class Page<E> implements java.io.Serializable{
	
	private int pageShow = 2;  //每页显示多少条
	private int totalPage;//总共有多少页
	private int totalCount;//总数
	private int start;//起始页
	private int nowPage;//当前页
	private List<E> result = Collections.emptyList();
	
	public int getStart() {
		start = (getNowPage()-1)*getPageShow();
		if(start<0){
			start = 0;
		}
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getPageShow() {
		return pageShow;
	}
	public void setPageShow(int pageShow) {
		this.pageShow = pageShow;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public List<E> getResult() {
		return result;
	}
	public void setResult(List<E> result) {
		this.result = result;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getTotalPage() {
		return  (int)Math.ceil(totalCount*1.0/pageShow);
	}
	public int getNowPage() {
		if(nowPage<=0)
			nowPage = 1;
		if(nowPage>getTotalPage())
			nowPage = getTotalPage();
		return nowPage;
	}
	@Override
	public String toString() {
		return "Page [pageShow=" + pageShow + ", totalPage=" + getTotalPage()
				+ ", totalCount=" + totalCount + ", nowPage=" + nowPage
				+ ", result=" + result + "]";
	}
	
	
}