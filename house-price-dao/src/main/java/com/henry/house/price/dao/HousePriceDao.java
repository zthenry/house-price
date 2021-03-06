/*
 * 文 件 名:  HousePriceDao.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  root
 * 修改时间:  2014-6-21
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.henry.house.price.dao;

import java.util.List;

import com.henry.house.price.model.HousePrice;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  root
 * @version  [版本号, 2014-6-21]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public interface HousePriceDao
{
    HousePrice getHouseInfoById(Long id);
    
    void insertHousePrice(HousePrice housePrice);
    
    List<HousePrice> getHousePricesByHouseName(String houseName);
}
