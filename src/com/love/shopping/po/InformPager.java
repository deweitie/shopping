package com.love.shopping.po;

import java.util.Map;

public class InformPager {

	private Map imformMap;  //���漯��

	private int totalNum;  //��ҳ��������

	private int pageSize;  //ÿҳ��ʾ������

	private int pagecurrentPageNo;  //��ǰ�ڼ�ҳ
	
	private int pageNum;   //��ҳ��

	private int pageOffset; //���ݿ�limit����е�����ֵ

	public Map getImformMap() {
		return imformMap;
	}

	public void setImformMap(Map imformMap) {
		this.imformMap = imformMap;
	}

	public int getPagecurrentPageNo() {
		return pagecurrentPageNo;
	}

	public void setPagecurrentPageNo(int pagecurrentPageNo) {
		this.pagecurrentPageNo = pagecurrentPageNo;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageOffset() {
		return pageOffset;
	}

	public void setPageOffset(int pageOffset) {
		this.pageOffset = pageOffset;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
}
