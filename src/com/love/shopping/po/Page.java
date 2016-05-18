package com.love.shopping.po;

import java.util.List;

public class Page {

	private int totalNum; //所有页中的  数据条数

	private List<?> pageList; //每一页数据的列表
	
	private int currentPage; //第几页

	public List<?> getPageList() {
		return pageList;
	}

	public void setPageList(List<?> pageList) {
		this.pageList = pageList;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
}
