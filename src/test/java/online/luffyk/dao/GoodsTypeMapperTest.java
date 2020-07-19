package online.luffyk.dao;

import online.luffyk.domain.GoodsType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class GoodsTypeMapperTest {
    @Resource
    private GoodsTypeMapper goodsTypeMapper;

    @Test
    public void testShowAllTopGoodsType(){
        List<GoodsType> goodsTypes = goodsTypeMapper.showAllTopGoodsType();
        for(GoodsType goodsType:goodsTypes){
            System.out.println(goodsType);
        }
    }

    @Test
    public void testShowAllSecondGoodsType(){
        GoodsType goodsType = new GoodsType(101, "手机电话", null);
        List<GoodsType> goodsTypes = goodsTypeMapper.showAllSecondGoodsType(goodsType);
        for(GoodsType goodsType1:goodsTypes){
            System.out.println(goodsType1);
        }
    }

    @Test
    public void testSelectGoodsTypeById(){
        GoodsType goodsType = goodsTypeMapper.selectGoodsTypeById(101);
        System.out.println(goodsType);
    }
}
