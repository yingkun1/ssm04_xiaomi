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
    public Boolean SelectConsumerByUserNameAndPasswordService(Consumer consumer) {
        List<Consumer> consumers = consumerMapper.selectConsumerByUserNameAndPassword(consumer);
        System.out.println("consumers:"+consumers);
        if(consumers!=null && consumers.size()==1){
            return true;
        }else{
            return false;
        }
    }
}
