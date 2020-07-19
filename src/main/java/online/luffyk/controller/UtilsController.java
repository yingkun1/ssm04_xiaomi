package online.luffyk.controller;

import online.luffyk.domain.Goods;
import online.luffyk.domain.GoodsType;
import online.luffyk.service.GoodsService;
import online.luffyk.service.GoodsTypeService;
import online.luffyk.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RequestMapping("u")
@Controller
public class UtilsController {
    @Resource
    private GoodsService goodsService;

    @Resource
    private GoodsTypeService goodsTypeService;

    @ResponseBody
    @RequestMapping(value = "search/{name}")
    public Object search(@PathVariable("name") String name){
        System.out.println("name:"+name);
        List<Goods> goodsList = goodsService.searchGoodsByNameService(name);
        if(goodsList.size()>0){
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("goodsList",goodsList);
            return new Result("搜索数据成功",hashMap,200);
        }else{
            return new Result("没有搜索到对应的数据，请重新搜素",null,400);
        }
    }

    @ResponseBody
    @RequestMapping(value = "get/{level}/{id}",method = RequestMethod.GET)
    public Object getGoodsByGoodsType(@PathVariable("level") Integer level,@PathVariable("id") Integer id){
        System.out.println("level:"+level);
        System.out.println("id:"+level);
        GoodsType goodsType = goodsTypeService.selectGoodsTypeByIdService(id);
        ArrayList<Goods> goodsArrayList = new ArrayList<>();
        if(level == 1){
            List<GoodsType> secondGoodsTypes = goodsTypeService.showAllSecondGoodsTypeService(goodsType);
            for(GoodsType secondGoodsType:secondGoodsTypes){
                List<Goods> goods = goodsService.selectGoodsByGoodsTypeService(secondGoodsType);
                goodsArrayList.addAll(goods);
            }
        }else if(level == 2){
            List<Goods> goods = goodsService.selectGoodsByGoodsTypeService(goodsType);
            goodsArrayList.addAll(goods);
        }
        if(goodsArrayList.size()>0){
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("goodsList",goodsArrayList);
            return new Result("获取数据成功",hashMap,200);
        }else{
            return new Result("数据获取失败",null,400);
        }

    }

}
