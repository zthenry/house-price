/*
 * 文 件 名:  HouseInfo.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  root
 * 修改时间:  2014-6-18
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.henry.house.price.model;

import java.util.Date;


/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  root
 * @version  [版本号, 2014-6-18]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class HousePrice
{
    //id
    private Long id;
    
    //楼盘名称
    private String houseName;
    
    //开发商
    private String kfsName;
    
    //地址
    private String address;
    
    //价钱
    private int price;
    
    //创建时间
    private Date createTime;
    
    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }
    public String getHouseName()
    {
        return houseName;
    }
    public void setHouseName(String houseName)
    {
        this.houseName = houseName;
    }
    public String getKfsName()
    {
        return kfsName;
    }
    public void setKfsName(String kfsName)
    {
        this.kfsName = kfsName;
    }
    public String getAddress()
    {
        return address;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
   
    public Date getCreateTime()
    {
        return createTime;
    }
    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }
    public int getPrice()
    {
        return price;
    }
    public void setPrice(int price)
    {
        this.price = price;
    }
    
    
    
    
}
