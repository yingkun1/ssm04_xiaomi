package online.luffyk.dao;

import online.luffyk.domain.Goods;
import online.luffyk.domain.GoodsType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsMapper {
    /**
     *
     * @param goodsType 商品类型
     * @return 该商品类型下的所有商品，此时的goodsType为二级类型
     */
    List<Goods> selectGoodsByGoodsType(GoodsType goodsType);

    /**
     *
     * @param name 商品名称关键字
     * @return 模糊查询到的所有商品
     */
    List<Goods> searchGoodsByName(String name);

    /**
     *
     * @param id 商品的id
     * @return 根据id返回对应的商品
     */
    Goods selectGoodsById(Integer id);


}
