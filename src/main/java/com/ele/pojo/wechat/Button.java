package com.ele.pojo.wechat;

import java.util.Arrays;

//共同的属性
public class Button {
	// 菜单类型
	private String type;
	// 菜单名称
	private String name;
	// 二级菜单
	private Button[] sub_button;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Button[] getSub_button() {
		return sub_button;
	}

	public void setSub_button(Button[] sub_button) {
		this.sub_button = sub_button;
	}

	@Override
	public String toString() {
		return "Button [type=" + type + ", name=" + name + ", sub_button="
				+ Arrays.toString(sub_button) + "]";
	}
	
	
}
