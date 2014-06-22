/*
 * 文 件 名:  HousePriceController.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  root
 * 修改时间:  2014-6-22
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.henry.house.price.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.henry.house.price.model.HousePrice;
import com.henry.house.price.service.HousePriceService;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  root
 * @version  [版本号, 2014-6-22]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Controller
@RequestMapping("/web/price")
public class HousePriceController
{
    @Autowired
    private HousePriceService housePriceService;
    @RequestMapping(value="/{id}/graphe", method=RequestMethod.GET)
    public ModelAndView grapheView(@PathVariable("id") long id){
        
        return new ModelAndView("/priceview/graphe");
    }
    
    @RequestMapping(value="/{id}/info",method=RequestMethod.GET)
    public ModelAndView getHousePriceById(@PathVariable("id") long id){
        
//        return new ModelAndView("/priceview/view");
        HousePrice h = housePriceService.getHousePriceById(id);
        List<HousePrice> list = housePriceService.getHousePricesByHouseName("华远海蓝城");
        for (HousePrice housePrice : list)
        {
            System.out.println(housePrice.getHouseName());
        }
        return new ModelAndView("/priceview/view").addObject("house",h);
    }
    
    @RequestMapping(value="/house/name",method=RequestMethod.POST)
    @ResponseBody
    public ModelMap getHousePriceByHouseName(@RequestBody Map<String, String> map,HttpServletRequest request, HttpServletResponse response,
        ModelMap model){
        
        String houseName = map.get("houseName");
        List<HousePrice> h = housePriceService.getHousePricesByHouseName(houseName);
        return model.addAttribute("houseList", h);
    }
}
