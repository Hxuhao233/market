package com.market.model;

public class Comments {
	private Integer id;

	private String comment;

	private Integer studentid;

	private Integer goodsid;

	
	
	
	
	public Comments(Integer id, String comment, Integer studentid, Integer goodsid) {
		this.id = id;
		this.comment = comment;
		this.studentid = studentid;
		this.goodsid = goodsid;
	}
	
	public Comments( String comment, Integer studentid, Integer goodsid) {

		this.comment = comment;
		this.studentid = studentid;
		this.goodsid = goodsid;
	}

	public Comments(){
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment == null ? null : comment.trim();
	}

	public Integer getStudentid() {
		return studentid;
	}

	public void setStudentid(Integer studentid) {
		this.studentid = studentid;
	}

	public Integer getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(Integer goodsid) {
		this.goodsid = goodsid;
	}
	
	
}