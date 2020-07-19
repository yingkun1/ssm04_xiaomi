package online.luffyk.dao;

import online.luffyk.domain.Goods;
import online.luffyk.domain.GoodsType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class GoodsMapperTest {
    @Resource
    private GoodsMapper goodsMapper;

    @Test
    public void testSelectGoodsByGoodsType(){
        GoodsType goodsType = new GoodsType(10002, "手机电话", null);
        List<Goods> goods = goodsMapper.selectGoodsByGoodsType(goodsType);
        for(Goods value:goods){
            System.out.println(value);
        }
    }

    @Test
    public void testSearchGoodsByName(){
        List<Goods> goodsList = goodsMapper.searchGoodsByName("小米");
        for(Goods goods:goodsList){
            System.out.println(goods);
        }
    }
}
