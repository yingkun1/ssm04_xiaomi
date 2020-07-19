package online.luffyk.controller;

import online.luffyk.domain.Goods;
import online.luffyk.service.GoodsService;
import online.luffyk.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RequestMapping("goods")
@Controller
public class GoodsController {
    @Resource
    private GoodsService goodsService;

    @ResponseBody
    @RequestMapping(value = "detail/{gid}",method = RequestMethod.GET)
    public Object getGoodsById(@PathVariable("gid") Integer gid){
        System.out.println("gid:"+gid);
        Goods goods = goodsService.selectGoodsByIdService(gid);
        if(goods!=null){
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("goods",goods);
            return new Result("获取商品详细信息成功",hashMap,200);
        }else{
            return new Result("获取商品详细信息失败",null,400);
        }
    }
}
