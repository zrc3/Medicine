package bs.gsau.ssm.pojo;

import java.util.Date;

public class BSell {
    private Integer id;

    private Integer medid;

    private Integer sellcount;

    private Float sellprice;

    private Float sellallmoney;

    private Date selltime;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMedid() {
        return medid;
    }

    public void setMedid(Integer medid) {
        this.medid = medid;
    }

    public Integer getSellcount() {
        return sellcount;
    }

    public void setSellcount(Integer sellcount) {
        this.sellcount = sellcount;
    }

    public Float getSellprice() {
        return sellprice;
    }

    public void setSellprice(Float sellprice) {
        this.sellprice = sellprice;
    }

    public Float getSellallmoney() {
        return sellallmoney;
    }

    public void setSellallmoney(Float sellallmoney) {
        this.sellallmoney = sellallmoney;
    }

    public Date getSelltime() {
        return selltime;
    }

    public void setSelltime(Date selltime) {
        this.selltime = selltime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}