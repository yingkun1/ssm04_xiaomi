package online.luffyk.dao;

import online.luffyk.domain.Consumer;
import online.luffyk.domain.Goods;
import online.luffyk.domain.GoodsCart;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GoodsCartMapper {

    /**
     *
     * @param consumer 顾客
     * @param goods 商品
     * @return 根据顾客的id和商品的id去返回购物车中的记录
     */
    GoodsCart selectGoodsCartByConsumerIdAndGoodsId(@Param("consumer") Consumer consumer,@Param("goods") Goods goods);

    /**
     *
     * @param goodsCart 购物车信息记录
     */
    Integer insertGoodsToGoodsCart(GoodsCart goodsCart);

    /**
     *
     * @param goodsCart 购物车信息记录
     * @return 受影响的行数
     */
    Integer updateGoodsInGoodsCart(GoodsCart goodsCart);

    /**
     *
     * @param goodsCart 购物车
     * @return 影响的行数
     */
    Integer removeGoodsInGoods(GoodsCart goodsCart);

    /**
     *
     * @param consumer 顾客信息
     * @return 返回顾客的购物车信息
     */
    List<GoodsCart> showAllGoodsCartByConsumer(Consumer consumer);
}
