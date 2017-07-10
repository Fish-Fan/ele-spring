package com.ele.dto;

import com.ele.pojo.ShopFood;

import java.util.List;

/**
 * Created by yanfeng-mac on 2017/7/7.
 */
public class OrderDetail {

    /**
     * orderDetail : {"foodList":[{"id":1,"foodName":"皮蛋瘦肉粥","shopFoodType":1,"shopId":1,"price":10,"monthlyCounts":229,"foodImg":"http://fuss10.elemecdn.com/c/cd/c12745ed8a5171e13b427dbc39401jpeg.jpeg?imageView2/1/w/750/h/750","info":"一碗皮蛋瘦肉粥，总是我到粥店时的不二之选。香浓软滑，饱腹暖心，皮蛋的Q弹与瘦肉的滑嫩伴着粥香溢于满口，让人喝这样的一碗粥也觉得心满意足","description":"咸粥","grade":100,"foodRewardList":[{"id":4,"shopFoodId":1,"shopId":1,"userId":1,"username":"fanyank","avatar":"http://static.galileo.xiaojukeji.com/static/tms/default_header.png","rewardMsg":"很一般啊","orderId":1,"rewardTime":"2017-7-1 12:53","rewardType":0,"grade":5},{"id":7,"shopFoodId":1,"shopId":1,"userId":1,"username":"fanyank","avatar":"http://static.galileo.xiaojukeji.com/static/tms/default_header.png","rewardMsg":"没之前的粥好喝，肉也变少了","orderId":2,"rewardTime":"2017-7-1 12:53","rewardType":1,"grade":3}],"count":1},{"id":2,"foodName":"扁豆焖面","shopFoodType":1,"shopId":1,"price":14,"monthlyCounts":188,"foodImg":"http://fuss10.elemecdn.com/c/6b/29e3d29b0db63d36f7c500bca31d8jpeg.jpeg?imageView2/1/w/750/h/750","grade":96,"foodRewardList":[{"id":3,"shopFoodId":2,"shopId":1,"userId":1,"username":"fanyank","avatar":"http://static.galileo.xiaojukeji.com/static/tms/default_header.png","rewardMsg":"没啥味道","orderId":1,"rewardTime":"2017-7-1 12:53","rewardType":0,"grade":5}],"count":1},{"id":3,"foodName":"葱花饼","shopFoodType":1,"shopId":1,"price":10,"monthlyCounts":124,"foodImg":"http://fuss10.elemecdn.com/f/28/a51e7b18751bcdf871648a23fd3b4jpeg.jpeg?imageView2/1/w/750/h/750","grade":85,"foodRewardList":[{"id":1,"shopFoodId":3,"shopId":1,"userId":1,"username":"fanyank","avatar":"http://static.galileo.xiaojukeji.com/static/tms/default_header.png","rewardMsg":"很喜欢的粥","orderId":1,"rewardTime":"2017-7-1 12:53","rewardType":0,"grade":5}],"count":1}],"totalPrice":34}
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
         * foodList : [{"id":1,"foodName":"皮蛋瘦肉粥","shopFoodType":1,"shopId":1,"price":10,"monthlyCounts":229,"foodImg":"http://fuss10.elemecdn.com/c/cd/c12745ed8a5171e13b427dbc39401jpeg.jpeg?imageView2/1/w/750/h/750","info":"一碗皮蛋瘦肉粥，总是我到粥店时的不二之选。香浓软滑，饱腹暖心，皮蛋的Q弹与瘦肉的滑嫩伴着粥香溢于满口，让人喝这样的一碗粥也觉得心满意足","description":"咸粥","grade":100,"foodRewardList":[{"id":4,"shopFoodId":1,"shopId":1,"userId":1,"username":"fanyank","avatar":"http://static.galileo.xiaojukeji.com/static/tms/default_header.png","rewardMsg":"很一般啊","orderId":1,"rewardTime":"2017-7-1 12:53","rewardType":0,"grade":5},{"id":7,"shopFoodId":1,"shopId":1,"userId":1,"username":"fanyank","avatar":"http://static.galileo.xiaojukeji.com/static/tms/default_header.png","rewardMsg":"没之前的粥好喝，肉也变少了","orderId":2,"rewardTime":"2017-7-1 12:53","rewardType":1,"grade":3}],"count":1},{"id":2,"foodName":"扁豆焖面","shopFoodType":1,"shopId":1,"price":14,"monthlyCounts":188,"foodImg":"http://fuss10.elemecdn.com/c/6b/29e3d29b0db63d36f7c500bca31d8jpeg.jpeg?imageView2/1/w/750/h/750","grade":96,"foodRewardList":[{"id":3,"shopFoodId":2,"shopId":1,"userId":1,"username":"fanyank","avatar":"http://static.galileo.xiaojukeji.com/static/tms/default_header.png","rewardMsg":"没啥味道","orderId":1,"rewardTime":"2017-7-1 12:53","rewardType":0,"grade":5}],"count":1},{"id":3,"foodName":"葱花饼","shopFoodType":1,"shopId":1,"price":10,"monthlyCounts":124,"foodImg":"http://fuss10.elemecdn.com/f/28/a51e7b18751bcdf871648a23fd3b4jpeg.jpeg?imageView2/1/w/750/h/750","grade":85,"foodRewardList":[{"id":1,"shopFoodId":3,"shopId":1,"userId":1,"username":"fanyank","avatar":"http://static.galileo.xiaojukeji.com/static/tms/default_header.png","rewardMsg":"很喜欢的粥","orderId":1,"rewardTime":"2017-7-1 12:53","rewardType":0,"grade":5}],"count":1}]
         * totalPrice : 34
         */

        private Double totalPrice;
        private List<ShopFood> foodList;

        public Double getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(Double totalPrice) {
            this.totalPrice = totalPrice;
        }

        public List<ShopFood> getFoodList() {
            return foodList;
        }

        public void setFoodList(List<ShopFood> foodList) {
            this.foodList = foodList;
        }

    }
}
