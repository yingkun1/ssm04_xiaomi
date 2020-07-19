package online.luffyk.service.impl;

import online.luffyk.dao.GoodsMapper;
import online.luffyk.domain.Goods;
import online.luffyk.domain.GoodsType;
import online.luffyk.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> selectGoodsByGoodsTypeService(GoodsType goodsType) {
        return goodsMapper.selectGoodsByGoodsType(goodsType);
    }

    @Override
    public List<Goods> searchGoodsByNameService(String name) {
        return goodsMapper.searchGoodsByName(name);
    }

    @Override
    public Goods selectGoodsByIdService(Integer id) {
        return goodsMapper.selectGoodsById(id);
    }
}
