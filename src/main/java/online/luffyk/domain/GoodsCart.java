package online.luffyk.domain;

import java.util.Date;
import java.util.List;

public class GoodsCart {
    private Integer id;
    private Integer goodsId;
    private Integer buyCount;
    private Date addDate;
    private Double subtotal;
    private Integer consumerId;

    private List<GoodsImages> goodsImagesList;

    public GoodsCart() {
    }

    public GoodsCart(Integer id, Integer goodsId, Integer buyCount, Date addDate, Double subtotal, Integer consumerId, List<GoodsImages> goodsImagesList) {
        this.id = id;
        this.goodsId = goodsId;
        this.buyCount = buyCount;
        this.addDate = addDate;
        this.subtotal = subtotal;
        this.consumerId = consumerId;
        this.goodsImagesList = goodsImagesList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Integer getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(Integer consumerId) {
        this.consumerId = consumerId;
    }

    public List<GoodsImages> getGoodsImagesList() {
        return goodsImagesList;
    }

    public void setGoodsImagesList(List<GoodsImages> goodsImagesList) {
        this.goodsImagesList = goodsImagesList;
    }

    @Override
    public String toString() {
        return "GoodsCart{" +
                "id=" + id +
                ", goodsId=" + goodsId +
                ", buyCount=" + buyCount +
                ", addDate=" + addDate +
                ", subtotal=" + subtotal +
                ", consumerId=" + consumerId +
                ", goodsImagesList=" + goodsImagesList +
                '}';
    }
}
