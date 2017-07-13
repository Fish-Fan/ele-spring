package com.ele.pojo;

/**
 * Created by yanfeng-mac on 2017/7/13.
 */
public class MenuType {
    private Integer menuTypeId;
    private String menuName;
    private String menuImg;

    public Integer getMenuTypeId() {
        return menuTypeId;
    }

    public void setMenuTypeId(Integer menuTypeId) {
        this.menuTypeId = menuTypeId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuImg() {
        return menuImg;
    }

    public void setMenuImg(String menuImg) {
        this.menuImg = menuImg;
    }

    @Override
    public String toString() {
        return "MenuType{" +
                "menuTypeId=" + menuTypeId +
                ", menuName='" + menuName + '\'' +
                ", menuImg='" + menuImg + '\'' +
                '}';
    }
}
