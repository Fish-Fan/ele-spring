package com.ele.pojo.wechat;
//click类型的菜单
public class ClickButton extends Button {
	// Click类型菜单key
	private String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "ClickButton [key=" + key + "]";
	}
	
}
