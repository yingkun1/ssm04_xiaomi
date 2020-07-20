package online.luffyk.service.impl;

import online.luffyk.dao.ConsumerMapper;
import online.luffyk.domain.Consumer;
import online.luffyk.service.ConsumerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ConsumerServiceImpl implements ConsumerService {
    @Resource
    private ConsumerMapper consumerMapper;


    @Override
    public Consumer SelectConsumerByUserNameAndPasswordService(Consumer consumer) {
       return consumerMapper.selectConsumerByUserNameAndPassword(consumer);
    }

    @Override
    public Integer insertOneConsumerService(Consumer consumer) {
        int count = -1;
        //检查该用户的用户名是否存在
        Consumer consumerByUserName = consumerMapper.selectConsumerByUserName(consumer.getUsername());
        if(consumerByUserName==null){
            count = consumerMapper.insertOneConsumer(consumer);
        }
        return count;

    }
}
