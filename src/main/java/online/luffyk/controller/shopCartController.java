package online.luffyk.controller;

import online.luffyk.domain.Consumer;
import online.luffyk.domain.Goods;
import online.luffyk.domain.GoodsCart;
import online.luffyk.service.GoodsCartService;
import online.luffyk.service.GoodsService;
import online.luffyk.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;


@RequestMapping("goodsCart")
@Controller
public class shopCartController {
    @Resource
    private GoodsCartService goodsCartService;

    @Resource
    private GoodsService goodsService;

    @ResponseBody
    @RequestMapping(value = "add/{goodsId}",method = RequestMethod.GET)
    public Object addGoodsToGoodsCart(@PathVariable("goodsId") Integer goodsId, HttpSession session){
        Consumer consumer = (Consumer) session.getAttribute("consumer");
        System.out.println("consumer:"+consumer);
        System.out.println("goodsId:"+goodsId);
        Goods goods = goodsService.selectGoodsByIdService(goodsId);
        System.out.println("goods:"+goods);
        Boolean flag = goodsCartService.addGoodsToGoodsService(consumer, goods);
        if(flag){
            return new Result("添加商品到购物车成功",true,200);
        }else{
            return new Result("添加商品到购物车失败",false,400);
        }
    }

    @ResponseBody
    @RequestMapping(value = "remove/{goodsId}",method = RequestMethod.GET)
    public Object removeGoodsFromGoodsCart(@PathVariable("goodsId") Integer goodsId,HttpSession session){
        Consumer consumer = (Consumer) session.getAttribute("consumer");
        Goods goods = goodsService.selectGoodsByIdService(goodsId);
        Boolean flag = goodsCartService.removeGoodsInGoodsService(consumer, goods);
        if(flag){
            return new Result("删除商品成功",true,200);
        }else{
            return new Result("删除商品失败",true,200);
        }
    }

    @ResponseBody
    @RequestMapping("find")
    public Object findAllGoodsCart(HttpSession session){
        Consumer consumer = (Consumer) session.getAttribute("consumer");
        List<GoodsCart> goodsCarts = goodsCartService.showAllGoodsCartByConsumerService(consumer);
        if(goodsCarts.size()>0){
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("goodsCart",goodsCarts);
            return new Result("购物车信息获取成功",hashMap,200);
        }else{
            return new Result("购物车信息获取失败",null,400);
        }
    }
}
