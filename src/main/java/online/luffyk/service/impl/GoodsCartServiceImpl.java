package online.luffyk.service.impl;

import online.luffyk.dao.GoodsCartMapper;
import online.luffyk.domain.Consumer;
import online.luffyk.domain.Goods;
import online.luffyk.domain.GoodsCart;
import online.luffyk.service.GoodsCartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class GoodsCartServiceImpl implements GoodsCartService {
    @Resource
    private GoodsCartMapper goodsCartMapper;

    private GoodsCart goodsCart;

    private Integer count;
    
    @Override
    public Boolean addGoodsToGoodsService(Consumer consumer, Goods goods) {
        if(this.checkGoodsInGoodsCart(consumer, goods)){
            //如果已经添加过了，修改即可
            int buyCount = goodsCart.getBuyCount();
            Double subtotal = goodsCart.getSubtotal();
            double unitPrice = subtotal / buyCount;
            goodsCart.setBuyCount(buyCount+1);
            goodsCart.setAddDate(new Date());
            goodsCart.setSubtotal(unitPrice*(buyCount+1));
            count = goodsCartMapper.updateGoodsInGoodsCart(goodsCart);
        }else{
            //没有添加，需要重新添加一条记录
            System.out.println("goods11111:"+goods);
            Integer id = goods.getId();
            Double price = goods.getPrice();
            System.out.println("consumer:"+consumer);
            goodsCart = new GoodsCart(null, goods.getId(), 1, new Date(), goods.getPrice(), consumer.getId(), null);
            count = goodsCartMapper.insertGoodsToGoodsCart(goodsCart);
        }
        return count == 1;
    }

    @Override
    public Boolean removeGoodsInGoodsService(Consumer consumer,Goods goods){
        if(this.checkGoodsInGoodsCart(consumer,goods)){
            //进行删除
            count = goodsCartMapper.removeGoodsInGoods(goodsCart);
            return count == 1;
        }
        System.out.println("商品不存在");
        return false;
    }

    @Override
    public List<GoodsCart> showAllGoodsCartByConsumerService(Consumer consumer) {
        return goodsCartMapper.showAllGoodsCartByConsumer(consumer);
    }

    public Boolean checkGoodsInGoodsCart(Consumer consumer,Goods goods){
        //判断该购物记录是否已经添加过了
        goodsCart = goodsCartMapper.selectGoodsCartByConsumerIdAndGoodsId(consumer, goods);
        return goodsCart != null;
    }
}
