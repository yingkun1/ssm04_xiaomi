package online.luffyk.controller;

import online.luffyk.domain.Consumer;
import online.luffyk.service.ConsumerService;
import online.luffyk.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("consumer")
public class ConsumerController {
    @Resource
    private ConsumerService consumerService;

    @ResponseBody
    @RequestMapping(value = "login/auth",method = RequestMethod.POST)
    public Object login(Consumer consumer){
        System.out.println("consumer:"+consumer);
        Boolean flag = consumerService.SelectConsumerByUserNameAndPasswordService(consumer);
        if(flag){
            return new Result("登录成功", true,200);
        }else{
            return new Result("登录失败", false,400);
        }
    }
}
