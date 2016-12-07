package com.market.model;

public class GoodsPictures {
    private Integer id;

    private Integer goodsid;

    private String pictureaddr;

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

    public String getPictureaddr() {
        return pictureaddr;
    }

    public void setPictureaddr(String pictureaddr) {
        this.pictureaddr = pictureaddr == null ? null : pictureaddr.trim();
    }
}