/*
 * 文 件 名:  HousePriceJob.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  root
 * 修改时间:  2014-6-15
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.henry.house.price.job;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.henry.house.price.model.HousePrice;
import com.henry.house.price.service.HousePriceService;

/**
 * 获取西安新房的价格
 * 
 * @author  root
 * @version  [版本号, 2014-6-15]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Component("housePriceJob")
public class HousePriceJob
{
    @Autowired
    private HousePriceService housePriceService;
    
    @Scheduled(cron="0 33 8 ? * *")  
    public void getNewHousePrice(){
        System.out.println("getNewHousePrice......");
        String newhourcePriceUrl="http://newhouse.xian.soufun.com/house/s/a78-b9";
        for (int i = 1; i < 11; i++)
        {
            System.out.println("第"+i+"页 begin......");
            StringBuffer sb = new StringBuffer();
            try
            {
                URL url = new URL(newhourcePriceUrl+i+"/");
                System.out.println(url);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.connect();

                InputStream in = conn.getInputStream();
                GZIPInputStream gzin = new GZIPInputStream(in);
                BufferedReader bin = new BufferedReader(new InputStreamReader(gzin, "GB2312"));
                String s = null;
                while((s=bin.readLine())!=null){
                    sb.append(s);
                }
                bin.close();
                //conn.disconnect();
                
                Document document = Jsoup. parse(sb.toString());
                Element element = document.getElementsByClass("sslist").get(0);
                Elements elements = element.getElementsByClass("sslalone");
                int j = 0;
                for(Element e : elements) {
                    System.out.println(j);
                    j++;
                    String kfsName = "";
                    String houseName = e.select("a.snblue").first().text();
                    Elements snblues = e.select("a.snblue");
                    for (Element e2 : snblues)
                    {
                        if(e2.text().contains("公司")){
                            kfsName = e2.text();
                            break;
                        }
                    }
                    String address = e.getElementsByTag("font").attr("title");
                    String price = e.select("li.junjia").text();
                    
                    System.out.println(houseName + " "+price+" "+address+" "+kfsName);
                    String priceNumber = price.replaceAll("\\D", "").trim();

                    Pattern p = Pattern.compile(".*\\d+.*");

                    Matcher m = p.matcher(priceNumber);

                    if (!m.matches()){
                        priceNumber="0";
                    }

                   
                    HousePrice housePrice = new HousePrice();
                    housePrice.setPrice(Integer.parseInt(priceNumber));
                    housePrice.setAddress(address.trim());
                    housePrice.setCreateTime(new Date());
                    housePrice.setHouseName(houseName.trim());
                    housePrice.setKfsName(kfsName.trim());
                    
                    housePriceService.createHousePrice(housePrice);
                    //System.out.println(id);
                }
                
            }
            catch (Exception e)
            {
                
               System.out.println(e);
               e.printStackTrace();
            }
            System.out.println("第"+i+"页 end***********");
        }
        //ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
//        HousePrice housePrice = housePriceService.getHousePriceById(1L);
//        if (null!=housePrice)
//        {
//            System.out.println(housePrice.getId()+" "+ housePrice.getAddress());
//        }
    }
    
}
