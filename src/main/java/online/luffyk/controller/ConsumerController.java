package online.luffyk.controller;

import online.luffyk.domain.Consumer;
import online.luffyk.service.ConsumerService;
import online.luffyk.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
@RequestMapping("consumer")
public class ConsumerController {
    @Resource
    private ConsumerService consumerService;

    @ResponseBody
    @RequestMapping(value = "login/auth",method = RequestMethod.POST)
    public Object login(Consumer consumer, HttpSession session){
        System.out.println("consumer:"+consumer);
        Consumer consumer1 = consumerService.SelectConsumerByUserNameAndPasswordService(consumer);
        if(consumer1!=null){
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("loginConsumer",consumer1.getUsername());
            //将登录成功的用户信息存储到session中
            session.setAttribute("consumer",consumer1);
            return new Result("登录成功", hashMap,200);
        }else{
            return new Result("登录失败", null,400);
        }
    }

    @ResponseBody
    @RequestMapping(value = "register",method = RequestMethod.POST)
    public Object register(Consumer consumer){
        System.out.println("consumer:"+consumer);
        Integer count = consumerService.insertOneConsumerService(consumer);
        if(count == 1){
            return new Result("注册成功",true,200);
        }else{
            return new Result("注册失败",false,400);
        }
    }
}
