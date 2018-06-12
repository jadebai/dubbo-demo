package com.baiyu.bean.entity;

import java.io.Serializable;
import java.util.Date;

public class UserLoginRecord implements Serializable {
    private Long id;

    private Long uid;

    private String ipAddress;

    private Integer sourceType;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public UserLoginRecord(Long id, Long uid, String ipAddress, Integer sourceType, Date createTime) {
        this.id = id;
        this.uid = uid;
        this.ipAddress = ipAddress;
        this.sourceType = sourceType;
        this.createTime = createTime;
    }

    public UserLoginRecord() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress == null ? null : ipAddress.trim();
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}