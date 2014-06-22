/*
 * 文 件 名:  HousePriceServiceImpl.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  root
 * 修改时间:  2014-6-21
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.henry.house.price.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.henry.house.price.dao.HousePriceDao;
import com.henry.house.price.model.HousePrice;
import com.henry.house.price.service.HousePriceService;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  root
 * @version  [版本号, 2014-6-21]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Service("houseService")
public class HousePriceServiceImpl implements HousePriceService
{
    private HousePriceDao housePriceDao;
    
    public void createHousePrice(HousePrice housePrice)
    {
        housePriceDao.insertHousePrice(housePrice);
    }
    
    public HousePrice getHousePriceById(Long id)
    {
        return housePriceDao.getHouseInfoById(id);
    }

    public HousePriceDao getHousePriceDao()
    {
        return housePriceDao;
    }

    public void setHousePriceDao(HousePriceDao housePriceDao)
    {
        this.housePriceDao = housePriceDao;
    }

    public List<HousePrice> getHousePricesByHouseName(String houseName)
    {
        return housePriceDao.getHousePricesByHouseName(houseName);
    }
    
    
}
