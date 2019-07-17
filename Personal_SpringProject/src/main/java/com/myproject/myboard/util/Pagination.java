package com.myproject.myboard.util;

public class Pagination {
	private int page;
	private int perPageNum;
	
	public Pagination() {
		this.page = 1;
		this.perPageNum = 10;
		
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if (page <= 0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}
	/*limit 구문에서 시작 위치를 지정할 때 사용된다. 예를 들어 10개씩 출력하는 경우 3페이지의 데이터는 
	 * this.page 가 1이면 0이 되어야한다. mysql limit 0,10 해야 처음부터 10개씩 나온다.
	 * 마이바티스 조회쿼리의 #{pageStart}에 전달된다.*/
	public void setPerPageNum(int perPageNum) {
		if (perPageNum <=0 || perPageNum> 100) {
			this.perPageNum = 10;
			return;
		}
		this.perPageNum = perPageNum;
	}
	
	public int getPageStart() {
		return (this.page -1 ) * perPageNum;
	}

	@Override
	public String toString() {
		return "Pagination [page=" + page + ", perPageNum=" + perPageNum + "]";
	}
	
	
	
}
