package com.love.shopping.po;

import java.util.List;

public class Page {

	private int totalNum; //����ҳ�е�  ��������

	private List<?> pageList; //ÿһҳ���ݵ��б�
	
	private int currentPage; //�ڼ�ҳ

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
