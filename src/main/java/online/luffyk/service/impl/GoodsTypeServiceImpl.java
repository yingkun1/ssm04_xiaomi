package online.luffyk.service.impl;

import online.luffyk.dao.GoodsTypeMapper;
import online.luffyk.domain.GoodsType;
import online.luffyk.service.GoodsTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {
    @Resource
    private GoodsTypeMapper goodsTypeMapper;

    @Override
    public List<GoodsType> showAllTopGoodsTypeService() {
        return goodsTypeMapper.showAllTopGoodsType();
    }

    @Override
    public List<GoodsType> showAllSecondGoodsTypeService(GoodsType goodsType) {
        return goodsTypeMapper.showAllSecondGoodsType(goodsType);
    }

    @Override
    public GoodsType selectGoodsTypeByIdService(Integer id) {
        return goodsTypeMapper.selectGoodsTypeById(id);
    }
}
