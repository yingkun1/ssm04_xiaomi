package online.luffyk.dao;

import online.luffyk.domain.Consumer;
import online.luffyk.domain.Goods;
import online.luffyk.domain.GoodsCart;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class GoodsCartMapperTest {
    @Resource
    private GoodsCartMapper goodsCartMapper;
    @Test
    public void testSelectGoodsCartByConsumerIdAndGoodsId(){
        Consumer consumer = new Consumer(1, "应昆", "yingkun9257", null, null);
        Goods goods = new Goods(1, "小米", 100.0, null, null, null, null);
        GoodsCart goodsCarts = goodsCartMapper.selectGoodsCartByConsumerIdAndGoodsId(consumer, goods);
        System.out.println(goodsCarts.getBuyCount());
    }

    @Test
    public void testInsertGoodsToGoodsCartByConsumerAdnGoods(){
        GoodsCart goodsCart = new GoodsCart(null, 2, 3,new Date(), 200.02, 32, null);
        Integer count = goodsCartMapper.insertGoodsToGoodsCart(goodsCart);
        System.out.println("受影响的行数为:"+count);
    }

    @Test
    public void testUpdateGoodsInGoodsCart(){
        GoodsCart goodsCart = new GoodsCart(13, 11, 2,new Date(), 6998.0, 1, null);
        Integer count = goodsCartMapper.updateGoodsInGoodsCart(goodsCart);
        System.out.println("受影响的行数:"+count);
    }

    @Test
    public void testRemoveGoodsInGoods(){
        GoodsCart goodsCart = new GoodsCart(null, 2, 3,new Date(), 2125.02, 3, null);
        Integer count = goodsCartMapper.removeGoodsInGoods(goodsCart);
        System.out.println("受影响的行数:"+count);
    }

    @Test
    public void testShowAllGoodsCartByConsumer(){
        Consumer consumer = new Consumer(1, "应昆", "yingkun9257", null, null);
        List<GoodsCart> goodsCarts = goodsCartMapper.showAllGoodsCartByConsumer(consumer);
        for(GoodsCart goodsCart:goodsCarts){
            System.out.println(goodsCart);
        }
    }
}
