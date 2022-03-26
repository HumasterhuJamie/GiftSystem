package com.example.giftsystem.beans;


import org.springframework.stereotype.Component;

@Component
public class ResultBean {
	
	private int result_code = 500;
	private String result_message = "";
	private Object datas = "";
	
	public int getResult_code() {
		return result_code;
	}
	public void setResult_code(int result_code) {
		this.result_code = result_code;
	}
	public String getResult_message() {
		return result_message;
	}
	public void setResult_message(String result_message) {
		this.result_message = result_message;
	}
	public Object getDatas() {
		return datas;
	}
	public void setDatas(Object datas) {
		this.datas = datas;
	}
	
}
