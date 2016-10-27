package com.hxuhao.model;

import java.util.Date;

public class Goods {
    private Integer id;

    private Integer publisherid;

    private Integer contactwayid;

    private Integer categoryid;

    private String name;

    private Double originalprice;

    private Double nowprice;

    private Integer newdegree;

    private String description;

    private Integer totalnum;

    private Integer residualnum;

    private Byte ispublished;

    private Date publishtime;

    private Integer praisetimes;

    private Integer collectedtimes;

    private Date durabilityperiod;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPublisherid() {
        return publisherid;
    }

    public void setPublisherid(Integer publisherid) {
        this.publisherid = publisherid;
    }

    public Integer getContactwayid() {
        return contactwayid;
    }

    public void setContactwayid(Integer contactwayid) {
        this.contactwayid = contactwayid;
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Double getOriginalprice() {
        return originalprice;
    }

    public void setOriginalprice(Double originalprice) {
        this.originalprice = originalprice;
    }

    public Double getNowprice() {
        return nowprice;
    }

    public void setNowprice(Double nowprice) {
        this.nowprice = nowprice;
    }

    public Integer getNewdegree() {
        return newdegree;
    }

    public void setNewdegree(Integer newdegree) {
        this.newdegree = newdegree;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getTotalnum() {
        return totalnum;
    }

    public void setTotalnum(Integer totalnum) {
        this.totalnum = totalnum;
    }

    public Integer getResidualnum() {
        return residualnum;
    }

    public void setResidualnum(Integer residualnum) {
        this.residualnum = residualnum;
    }

    public Byte getIspublished() {
        return ispublished;
    }

    public void setIspublished(Byte ispublished) {
        this.ispublished = ispublished;
    }

    public Date getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }

    public Integer getPraisetimes() {
        return praisetimes;
    }

    public void setPraisetimes(Integer praisetimes) {
        this.praisetimes = praisetimes;
    }

    public Integer getCollectedtimes() {
        return collectedtimes;
    }

    public void setCollectedtimes(Integer collectedtimes) {
        this.collectedtimes = collectedtimes;
    }

    public Date getDurabilityperiod() {
        return durabilityperiod;
    }

    public void setDurabilityperiod(Date durabilityperiod) {
        this.durabilityperiod = durabilityperiod;
    }
}