package online.luffyk.service;

import online.luffyk.domain.Goods;
import online.luffyk.domain.GoodsType;

import java.util.List;

public interface GoodsService {
    List<Goods> selectGoodsByGoodsTypeService(GoodsType goodsType);

    List<Goods> searchGoodsByNameService(String name);

    Goods selectGoodsByIdService(Integer id);
}
