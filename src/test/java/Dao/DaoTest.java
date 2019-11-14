package Dao;

import com.hwh.kfr.KfrApplication;
import com.hwh.kfr.dao.IMainDataDao;
import com.hwh.kfr.dao.IUserDao;
import com.hwh.kfr.model.Inferior;
import com.hwh.kfr.model.MainData;
import com.hwh.kfr.model.Order;
import com.hwh.kfr.model.User;
import com.hwh.kfr.service.impl.MainDataService;
import com.hwh.kfr.service.impl.OrderService;
import com.hwh.kfr.service.impl.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;
import java.util.UUID;


@ContextConfiguration
@SpringBootTest(classes = KfrApplication.class)
@RunWith(SpringRunner.class)
public class DaoTest {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;


    @Autowired
    private MainDataService mainDataService;
    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    /**
     * 测试查询指定用户ID的面板数据
     */
    @Test
    public void test(){

        MainData mainData = mainDataService.selectAllDataById(1);
        System.out.println(mainData);
        System.out.println(redisTemplate);
        User user = new User();
        user.setNikeName("黄威海");
        user.setUsername("13313");
        user.setPassword("124");
        redisTemplate.opsForValue().set("user2",user);
//        redisTemplate.opsForValue().append("name", "黄威海");
//        System.out.println(redisTemplate.opsForValue().get("key").toString());

    }



    /**
     * 测试UserDao
     */
    @Test
    public void test2(){

        User user = userService.findUserById(1);
        System.out.println(user);

    }

    /**
     * 测试根据用户名查询用户以及用户数据
     */
    @Test
    public void test3(){

        User user = userService.findUserByUsername("13313767166");
        System.out.println(user);
    }

    /**
     * 测试登陆功能
     */
    @Test
    public void test4(){
        User user = userService.login("13313767166", "123");
        System.out.println(user);

    }

    /**
     * 测试根据上级用户名查找所有下级功能
     */

    @Test
    public void test5(){

        List<Inferior> inferiors = userService.findInferiorByUsername("13313767166");
        for (Inferior inferior : inferiors) {
            System.out.println(inferior);
        }

    }

    /**
     * 测试注册功能
     *
     */
    @Test
    public void test6(){
        User u = new User();
        u.setNikeName("赵六");
        u.setUsername("13316363166");
        u.setPassword("16546");
        u.setIdcard("350522199810260444");
        u.setPhone("13331484574");
        u.setSuperiors_id(1);

        Map<String, Object> map = userService.register(u);
        String msg = (String)map.get("msg");
        System.out.println(msg);
    }

    /**
     * 测试签到释放功能
     *
     */
    @Test
    public void test7(){
        User user = userService.findUserById(1);
        MainData mainData = user.getMainData();

        //执行签到
        boolean release = mainDataService.release(mainData);

    }

    @Test
    public void test8(){
        Order order = new Order();
//        order.setOrder_id(1233l);
        order.setCoin_number(30);
        order.setBuyer_id(2);
        order.setSeller_id(1);
        order.setTotalPrice(30.0*5);
        order.setPrice(5.0);

        int i = orderService.addOrder(order);
        System.out.println(i);

    }

    @Test
    public void test9(){
//        Order order = new Order();
//        order.setOrder_id("");
//
//        orderService.cancelOrder(order);
        System.out.println(UUID.randomUUID().toString().substring(0,8));
        //20d2d337-2b47-4ec9-ae42-f2eb359f9acb
        //2b0b05f3-463c-4bcf-8e7f-2474bd7c6cfa

    }
    @Autowired
    MainData mainData;

    @Autowired
    IMainDataDao mainDataDao;
    @Test
    public void test10(){
        System.out.println(mainData.toString());
        System.out.println(mainData.getProportion());

        mainDataDao.addMainData(3);
    }

    @Autowired
    IUserDao userDao;


    @Test
    public void test11(){
        List<Inferior> inferior = userDao.findInferiorUsername("13313767166");
        for (Inferior inferior1 : inferior) {
            System.out.println(inferior1);
        }
    }



}
