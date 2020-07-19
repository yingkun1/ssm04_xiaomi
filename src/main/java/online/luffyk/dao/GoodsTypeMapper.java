package online.luffyk.dao;

import online.luffyk.domain.GoodsType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsTypeMapper {
    /**
     *
     * @return 查询一级类型
     */
    List<GoodsType> showAllTopGoodsType();

    /**
     *
     * @return 查询一级类型下的二级类型
     */
    List<GoodsType> showAllSecondGoodsType(GoodsType goodsType);

    /**
     *
     * @param id 商品类型的id
     * @return 对应的商品类型
     */
    GoodsType selectGoodsTypeById(Integer id);
}
