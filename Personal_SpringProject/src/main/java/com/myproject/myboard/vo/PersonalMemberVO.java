package com.myproject.myboard.vo;

public class PersonalMemberVO {
	private int mem_idx;
	private String mem_id;
	private String mem_name;
	private String mem_pw;
	private String mem_email;
	private String mem_add;
	private String mem_idnumber;
	private String mem_nick;
	private int mem_per;
	
	public PersonalMemberVO() {
		// TODO Auto-generated constructor stub
	}

	public PersonalMemberVO(int mem_idx, String mem_id, String mem_name, String mem_pw, String mem_email,
			String mem_add, String mem_idnumber, String mem_nick, int mem_per) {
		super();
		this.mem_idx = mem_idx;
		this.mem_id = mem_id;
		this.mem_name = mem_name;
		this.mem_pw = mem_pw;
		this.mem_email = mem_email;
		this.mem_add = mem_add;
		this.mem_idnumber = mem_idnumber;
		this.mem_nick = mem_nick;
		this.mem_per = mem_per;
	}


	@Override
	public String toString() {
		return "PersonalMemberVO [mem_idx=" + mem_idx + ", mem_id=" + mem_id + ", mem_name=" + mem_name + ", mem_pw="
				+ mem_pw + ", mem_email=" + mem_email + ", mem_add=" + mem_add + ", mem_idnumber=" + mem_idnumber
				+ ", mem_nick=" + mem_nick + ", mem_per=" + mem_per + "]";
	}

	public int getMem_idx() {
		return mem_idx;
	}

	public void setMem_idx(int mem_idx) {
		this.mem_idx = mem_idx;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getMem_pw() {
		return mem_pw;
	}

	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}

	public String getMem_email() {
		return mem_email;
	}

	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}

	public String getMem_add() {
		return mem_add;
	}

	public void setMem_add(String mem_add) {
		this.mem_add = mem_add;
	}

	public String getMem_idnumber() {
		return mem_idnumber;
	}

	public void setMem_idnumber(String mem_idnumber) {
		this.mem_idnumber = mem_idnumber;
	}

	public String getMem_nick() {
		return mem_nick;
	}

	public void setMem_nick(String mem_nick) {
		this.mem_nick = mem_nick;
	}

	public int getMem_per() {
		return mem_per;
	}

	public void setMem_per(int mem_per) {
		this.mem_per = mem_per;
	}
	
	

	

}
