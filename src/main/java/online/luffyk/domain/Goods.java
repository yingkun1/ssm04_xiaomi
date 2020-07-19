package online.luffyk.domain;

import java.util.List;

public class Goods {
    private Integer id;
    private String name;
    private Double price;
    private Integer stock;
    private Integer goodsTypeId;
    private String remark;

    private List<GoodsImages> goodsImagesList;

    public Goods() {
    }

    public Goods(Integer id, String name, Double price, Integer stock, Integer goodsTypeId, String remark, List<GoodsImages> goodsImagesList) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.goodsTypeId = goodsTypeId;
        this.remark = remark;
        this.goodsImagesList = goodsImagesList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getGoodsTypeId() {
        return goodsTypeId;
    }

    public void setGoodsTypeId(Integer goodsTypeId) {
        this.goodsTypeId = goodsTypeId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<GoodsImages> getGoodsImagesList() {
        return goodsImagesList;
    }

    public void setGoodsImagesList(List<GoodsImages> goodsImagesList) {
        this.goodsImagesList = goodsImagesList;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", goodsTypeId=" + goodsTypeId +
                ", remark='" + remark + '\'' +
                ", goodsImagesList=" + goodsImagesList +
                '}';
    }
}
