package com.market.model;

public class ContactWays {
    private Integer id;

    private Integer goodsid;

    private String qqnum;

    private String mailnum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public String getQqnum() {
        return qqnum;
    }

    public void setQqnum(String qqnum) {
        this.qqnum = qqnum == null ? null : qqnum.trim();
    }

    public String getMailnum() {
        return mailnum;
    }

    public void setMailnum(String mailnum) {
        this.mailnum = mailnum == null ? null : mailnum.trim();
    }
}