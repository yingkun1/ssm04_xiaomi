package online.luffyk.controller;

import online.luffyk.domain.Goods;
import online.luffyk.domain.GoodsType;
import online.luffyk.service.GoodsService;
import online.luffyk.service.GoodsTypeService;
import online.luffyk.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Controller
public class IndexController {
    @Resource
    private GoodsTypeService goodsTypeService;
    
    @Resource
    private GoodsService goodsService;

    @ResponseBody
    @RequestMapping(value = "initIndex",method = RequestMethod.GET)
    public Object initIndex(){
        List<GoodsType> topGoodsTypes = goodsTypeService.showAllTopGoodsTypeService();
        HashMap<Integer, Object> hashMap = new HashMap<>();
        for(GoodsType topGoodsType:topGoodsTypes){
            List<GoodsType> secondGoodsTypes = goodsTypeService.showAllSecondGoodsTypeService(topGoodsType);
            for(GoodsType secondGoodsType:secondGoodsTypes){
                List<Goods> goods = goodsService.selectGoodsByGoodsTypeService(secondGoodsType);
                hashMap.put(secondGoodsType.getId(),goods);
            }
        }
        HashMap<String, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("goodsTypeList",topGoodsTypes);
        objectHashMap.put("goodsMap",hashMap);
        return new Result("获取商品信息成功",objectHashMap,200);
    }
}
