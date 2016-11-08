package com.market.tools;
/**
 *  返回给网页的消息对象
 * @author hxuhao
 *
 */
public class Message {
	private int code;			
	private String info;
	
	public Message(){
		
	}
	
	public Message(int c,String i){
		code = c;
		info = i;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
}
