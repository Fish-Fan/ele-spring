package com.ele.pojo.wechat;

import java.util.Arrays;

//封装Button
public class Menu {
	//一级菜单
	private Button[] button;

	public Button[] getButton() {
		return button;
	}

	public void setButton(Button[] button) {
		this.button = button;
	}

	@Override
	public String toString() {
		return "Menu [button=" + Arrays.toString(button) + "]";
	}
	
}
