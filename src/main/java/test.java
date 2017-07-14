import com.ele.dto.Goods;
import com.ele.dto.RewardDTO;
import com.ele.mapper.RewardMapper;
import com.ele.mapper.ShopMapper;
import com.ele.mapper.UserMapper;
import com.ele.pojo.FoodReward;
import com.ele.pojo.Shop;
import com.ele.pojo.ShopReward;
import com.ele.pojo.User;
import com.ele.pojo.wechat.AccessToken;
import com.ele.service.OrderService;
import com.ele.service.RewardService;
import com.ele.service.ShopService;
import com.ele.util.SqlSessionFactoryUtil;
import com.ele.util.WeChatUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.joda.time.DateTime;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yanfeng-mac on 2017/6/27.
 */
public class test {

    public static void test1(Date d1, Date d2){

        // 毫秒ms
        long diff = d2.getTime() - d1.getTime();

        long diffSeconds = diff / 1000 % 60;
        long diffMinutes = diff / (60 * 1000) % 60;
        long diffHours = diff / (60 * 60 * 1000) % 24;
        long diffDays = diff / (24 * 60 * 60 * 1000);

        System.out.print("时间相差：");
        System.out.print(diffDays + " 天 ");
        System.out.print(diffHours + " 小时 ");
        System.out.print(diffMinutes + " 分钟 ");
        System.out.print(diffSeconds + " 秒.");
        System.out.println();
    }


    public static void main(String[] args) {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) ctx.getBean("sqlSessionFactory");
//
//        SqlSession sqlSession = sqlSessionFactory.openSession();

//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        ShopMapper shopMapper = sqlSession.getMapper(ShopMapper.class);
//        RewardMapper rewardMapper = sqlSession.getMapper(RewardMapper.class);
//        User user = userMapper.findById(1);
//        List<Goods> goods = shopMapper.findShopGoodsById(1);

//        ShopService shopService = new ShopService();

//        List<Shop> shopList = shopMapper.findShopByLikeName("百");





//        System.out.println(shopList);

//        User user = new User();
//        user.setUsername("swift");
//        user.setPassword("123123");
//

//        sqlSession.commit();
//        sqlSession.close();



        String dateStart = "2017-07-14 09:44:32";

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            Date d1 = format.parse(dateStart);
            DateTime now = new DateTime();
            String endStart = now.toString("yyyy-MM-dd HH:mm:ss");
            Date d2 = format.parse(endStart);
            System.out.println(endStart);
            test1(d1,d2);



        } catch (ParseException e) {
            e.printStackTrace();
        }





    }


}
