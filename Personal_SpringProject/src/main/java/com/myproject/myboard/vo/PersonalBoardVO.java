package com.myproject.myboard.vo;

public class PersonalBoardVO {
	private int board_idx;
	private String board_title;
	private String board_detail;
	private String board_pw;
	private String board_date;
	private int mem_idx;
	
	
	public PersonalBoardVO(int board_idx, String board_title, String board_detail, String board_pw, String board_date,
			int mem_idx) {
		super();
		this.board_idx = board_idx;
		this.board_title = board_title;
		this.board_detail = board_detail;
		this.board_pw = board_pw;
		this.board_date = board_date;
		this.mem_idx = mem_idx;
	}
	public int getBoard_idx() {
		return board_idx;
	}
	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_detail() {
		return board_detail;
	}
	public void setBoard_detail(String board_detail) {
		this.board_detail = board_detail;
	}
	public String getBoard_pw() {
		return board_pw;
	}
	public void setBoard_pw(String board_pw) {
		this.board_pw = board_pw;
	}
	public String getBoard_date() {
		return board_date;
	}
	public void setBoard_date(String board_date) {
		this.board_date = board_date;
	}
	public int getMem_idx() {
		return mem_idx;
	}
	public void setMem_idx(int mem_idx) {
		this.mem_idx = mem_idx;
	}
	
	@Override
	public String toString() {
		return "PersonalBoardVO [board_idx=" + board_idx + ", board_title=" + board_title + ", board_detail="
				+ board_detail + ", board_pw=" + board_pw + ", board_date=" + board_date + ", mem_idx=" + mem_idx + "]";
	}
	
	
	
}
