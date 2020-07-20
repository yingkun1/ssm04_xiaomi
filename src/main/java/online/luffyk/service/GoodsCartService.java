package online.luffyk.service;

import online.luffyk.domain.Consumer;
import online.luffyk.domain.Goods;
import online.luffyk.domain.GoodsCart;

import java.util.List;

public interface GoodsCartService {

    /**
     *
     * @param consumer 顾客
     * @param goods 商品
     * @return 是否添加成功
     */
    Boolean addGoodsToGoodsService(Consumer consumer, Goods goods);

    /**
     *
     * @param consumer 顾客
     * @param goods 商品
     * @return 是否删除成功
     */
    Boolean removeGoodsInGoodsService(Consumer consumer,Goods goods);

    /**
     *
     * @param consumer 顾客信息
     * @return 返回谷歌的购物车信息
     */
    List<GoodsCart> showAllGoodsCartByConsumerService(Consumer consumer);

}
