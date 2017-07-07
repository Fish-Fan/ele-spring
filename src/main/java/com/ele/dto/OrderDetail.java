package com.ele.dto;

import com.ele.pojo.User;

import java.util.List;

/**
 * Created by yanfeng-mac on 2017/7/7.
 */
public class OrderDetail {

    /**
     * orderDetail : {"user":{"id":1,"username":"fanyank","password":"123123","email":"fanyank@126.com","avatar":"http://static.galileo.xiaojukeji.com/static/tms/default_header.png","phoneNum":"17638918399","weixin":"weixin"},"foodList":[{"foodName":"皮蛋瘦肉粥","price":10,"count":1},{"foodName":"扁豆焖面","price":14,"count":1},{"foodName":"葱花饼","price":10,"count":1}]}
     */

    private OrderDetailBean orderDetail;

    public OrderDetailBean getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetailBean orderDetail) {
        this.orderDetail = orderDetail;
    }

    public static class OrderDetailBean {
        /**
         * user : {"id":1,"username":"fanyank","password":"123123","email":"fanyank@126.com","avatar":"http://static.galileo.xiaojukeji.com/static/tms/default_header.png","phoneNum":"17638918399","weixin":"weixin"}
         * foodList : [{"foodName":"皮蛋瘦肉粥","price":10,"count":1},{"foodName":"扁豆焖面","price":14,"count":1},{"foodName":"葱花饼","price":10,"count":1}]
         */

        private User user;
        private List<BasicFoodDTO> foodList;
        private Double totalPrice;

        public Double getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(Double totalPrice) {
            this.totalPrice = totalPrice;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public List<BasicFoodDTO> getFoodList() {
            return foodList;
        }

        public void setFoodList(List<BasicFoodDTO> foodList) {
            this.foodList = foodList;
        }




    }


}
