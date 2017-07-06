package com.ele.pojo.wechat;
//view类型的菜单
public class ViewButton extends Button{
	//view类型菜单url--跳转的地址
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "ViewButton [url=" + url + "]";
	}
	
}
