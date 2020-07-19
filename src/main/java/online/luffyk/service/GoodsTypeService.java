package online.luffyk.service;

import online.luffyk.domain.GoodsType;

import java.util.List;

public interface GoodsTypeService {

    List<GoodsType> showAllTopGoodsTypeService();

    List<GoodsType> showAllSecondGoodsTypeService(GoodsType goodsType);

    GoodsType selectGoodsTypeByIdService(Integer id);
}
