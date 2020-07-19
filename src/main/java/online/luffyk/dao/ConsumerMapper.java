package online.luffyk.dao;

import online.luffyk.domain.Consumer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ConsumerMapper {
    /**
     *
     * @return 数据库中所有顾客的信息
     */
    List<Consumer> showAllConsumer();

    /**
     *
     * @param id 顾客的id
     * @return 根据ID返回顾客的信息
     */
    Consumer selectConsumerById(Integer id);

    /**
     *
     * @param username 用户名
     * @return 根据用户名返回用户的信息
     */
    Consumer selectConsumerByUserName(String username);

    /**
     * @param consumer 用户的信息
     * @return 返回对应的顾客列表
     */
    List<Consumer> selectConsumerByUserNameAndPassword(Consumer consumer);

    /**
     *
     * @param consumer 顾客的信息
     * @return 受影响的行数
     */
    Integer insertOneConsumer(Consumer consumer);
}
