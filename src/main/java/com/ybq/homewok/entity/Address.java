package com.ybq.homewok.entity;

public class Address {
    /**
     * 主键
     */
    private Integer addressId;

    /**
     * 收件人姓名
     */
    private String recipientName;

    /**
     * 收件人的电话
     */
    private String recipientPhone;

    /**
     * 省份
     */
    private String addressProvince;

    /**
     * 城市
     */
    private String addressCity;

    /**
     * 详细地址
     */
    private String addressDetailed;

    /**
     * 0表示非默认地址 1表示默认地址
     */
    private Integer status;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 0表示未删除 1表示已删除
     */
    private Integer isDel;

    /**
     * 区
     */
    private String addressCounty;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientPhone() {
        return recipientPhone;
    }

    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
    }

    public String getAddressProvince() {
        return addressProvince;
    }

    public void setAddressProvince(String addressProvince) {
        this.addressProvince = addressProvince;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressDetailed() {
        return addressDetailed;
    }

    public void setAddressDetailed(String addressDetailed) {
        this.addressDetailed = addressDetailed;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public String getAddressCounty() {
        return addressCounty;
    }

    public void setAddressCounty(String addressCounty) {
        this.addressCounty = addressCounty;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", recipientName='" + recipientName + '\'' +
                ", recipientPhone='" + recipientPhone + '\'' +
                ", addressProvince='" + addressProvince + '\'' +
                ", addressCity='" + addressCity + '\'' +
                ", addressDetailed='" + addressDetailed + '\'' +
                ", status=" + status +
                ", userId=" + userId +
                ", isDel=" + isDel +
                ", addressCounty='" + addressCounty + '\'' +
                '}';
    }
}

