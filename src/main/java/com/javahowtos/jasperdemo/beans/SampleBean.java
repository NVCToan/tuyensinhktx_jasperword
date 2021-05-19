package com.javahowtos.jasperdemo.beans;

public class SampleBean {

	String fullname;

	String sex;
	
	public SampleBean(String fullname, String sex) {
		this.fullname = fullname;
		this.sex = sex;
	}
	
	public SampleBean() {
		
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	

}
