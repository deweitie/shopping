package com.love.shopping.po;

import java.util.Map;

public class NotePager {

	private Map noteMap; //����

	private int totalNum; //��ҳ��������

	private int pageSize; //ÿҳ��ʾ������

	private int pagecurrentPageNo; //��ǰ�ڼ�ҳ

	private int pageNum; //��ҳ��

	private int pageOffset; //���ݿ�limit����е�����ֵ

	public Map getNoteMap() {
		return noteMap;
	}

	public void setNoteMap(Map noteMap) {
		this.noteMap = noteMap;
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
