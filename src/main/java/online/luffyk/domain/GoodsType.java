package online.luffyk.domain;

public class GoodsType {
    private Integer id;
    private String name;
    private String pid;

    public GoodsType() {
    }

    public GoodsType(Integer id, String name, String pid) {
        this.id = id;
        this.name = name;
        this.pid = pid;
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

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "GoodsType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pid='" + pid + '\'' +
                '}';
    }
}