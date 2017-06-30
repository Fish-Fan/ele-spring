package com.ele.pojo;

import com.ele.dto.DtoDiscountDesc;
import com.ele.dto.Goods;

import java.util.List;
import java.util.UUID;

/**
 * Created by yanfeng-mac on 2017/6/27.
 */
public class Shop {
    
    private Integer id;
    private String name;
    private String avatar;
    private String grade;
    private Integer monthlyCounts;
    private String introduce;
    private Integer deliveryTime;
    private String specialMsg;
    private String contact;
    private String address;
    private String openTime;
    private Integer reportCount;
    private Integer minPrice;

    private List<DtoDiscountDesc> discountDescList;
    private List<ShopImg> imgList;
    private List<Goods> goods;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getMonthlyCounts() {
        return monthlyCounts;
    }

    public void setMonthlyCounts(Integer monthlyCounts) {
        this.monthlyCounts = monthlyCounts;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Integer getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Integer deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getSpecialMsg() {
        return specialMsg;
    }

    public void setSpecialMsg(String specialMsg) {
        this.specialMsg = specialMsg;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public Integer getReportCount() {
        return reportCount;
    }

    public void setReportCount(Integer reportCount) {
        this.reportCount = reportCount;
    }

    public Integer getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }

    public List<DtoDiscountDesc> getDiscountDescList() {
        return discountDescList;
    }

    public void setDiscountDescList(List<DtoDiscountDesc> discountDescList) {
        this.discountDescList = discountDescList;
    }

    public List<ShopImg> getImgList() {
        return imgList;
    }

    public void setImgList(List<ShopImg> imgList) {
        this.imgList = imgList;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", grade='" + grade + '\'' +
                ", monthlyCounts=" + monthlyCounts +
                ", introduce='" + introduce + '\'' +
                ", deliveryTime=" + deliveryTime +
                ", specialMsg='" + specialMsg + '\'' +
                ", contact='" + contact + '\'' +
                ", address='" + address + '\'' +
                ", openTime='" + openTime + '\'' +
                ", reportCount=" + reportCount +
                ", minPrice=" + minPrice +
                ", discountDescList=" + discountDescList +
                ", imgList=" + imgList +
                ", goods=" + goods +
                '}';
    }
}
