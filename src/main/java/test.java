import com.ele.dto.Goods;
import com.ele.mapper.ShopMapper;
import com.ele.mapper.UserMapper;
import com.ele.pojo.User;
import com.ele.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by yanfeng-mac on 2017/6/27.
 */
public class test {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) ctx.getBean("sqlSessionFactory");

        SqlSession sqlSession = sqlSessionFactory.openSession();

//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        ShopMapper shopMapper = sqlSession.getMapper(ShopMapper.class);
//        User user = userMapper.findById(1);
        List<Goods> goods = shopMapper.findShopGoodsById(1);
        System.out.println(goods);


//        User user = new User();
//        user.setUsername("swift");
//        user.setPassword("123123");
//

//        sqlSession.commit();
        sqlSession.close();
    }
}
