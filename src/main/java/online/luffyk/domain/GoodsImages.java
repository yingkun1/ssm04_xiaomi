package online.luffyk.domain;

public class GoodsImages {
    private Integer id;
    private String path;
    private String title;
    private String alt;
    private Integer goodsId;

    public GoodsImages() {
    }

    public GoodsImages(Integer id, String path, String title, String alt, Integer goodsId) {
        this.id = id;
        this.path = path;
        this.title = title;
        this.alt = alt;
        this.goodsId = goodsId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    public String toString() {
        return "GoodsImage{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", title='" + title + '\'' +
                ", alt='" + alt + '\'' +
                ", goodsId=" + goodsId +
                '}';
    }
}
