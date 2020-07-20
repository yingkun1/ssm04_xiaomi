package online.luffyk.dao;

import online.luffyk.domain.Consumer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ConsumerMapperTest {
    @Resource
    private ConsumerMapper consumerMapper;

    @Test
    public void testShowAllConsumer(){
        List<Consumer> consumers = consumerMapper.showAllConsumer();
        System.out.println(consumers.size());
        for(Consumer consumer:consumers){
            System.out.println(consumer);
        }
    }

    @Test
    public void testInsertOneConsumer(){
        Consumer consumer = new Consumer(null, "王五", "wangwu9257", "wangwu@qq.com", "17373960306");
        Integer count = consumerMapper.insertOneConsumer(consumer);
        System.out.println("受影响的行数为："+count);
    }

    @Test
    public void testSelectConsumerById(){
        Consumer consumer = consumerMapper.selectConsumerById(1);
        System.out.println(consumer);
    }

    @Test
    public void testSelectConsumerByUserName(){
        Consumer consumer = consumerMapper.selectConsumerByUserName("应昆123");
        System.out.println(consumer);
    }

    @Test
    public void testSelectConsumerByUserNameAndPassword(){
        Consumer consumer1 = new Consumer(null, "王五", "wangwu9257",null,null);
        Consumer consumer2 = consumerMapper.selectConsumerByUserNameAndPassword(consumer1);
        System.out.println(consumer2);
    }
}
