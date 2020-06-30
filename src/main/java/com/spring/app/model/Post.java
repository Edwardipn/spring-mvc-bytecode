package com.spring.app.model;

import java.util.Date;

public class Post {
	private int id;
	private String description;
	private String urlImg="http://localhost:8080/img/champions.jpg";
	private Date fecha=new Date();
	private String title;
	
	
	public Post() {
	}
	public Post(int id, String description, String urlImg, Date fecha, String title) {
		this.id = id;
		this.description = description;
		this.urlImg = urlImg;
		this.fecha = fecha;
		this.title = title;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrlImg() {
		return urlImg;
	}
	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
