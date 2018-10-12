package com.example.demo.controller;

import com.example.demo.domain.LinkConfig;
import com.example.demo.oraclemapper.LinkConfigMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringBootConfiguration;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;

@SpringBootConfiguration


public class test {
    private static Logger log= LoggerFactory.getLogger(test.class);

//    @Autowired
//    LinkConfigMapper linkConfigDao;

    @Autowired
    private LinkConfigMapper linkConfigDao;




    @Test(description = "大厅接口",dataProvider = "wap_hall_param")
    public void wap_hall_info(String url){
        Response response = get(url);
        String json=response.asString();
//        System.out.println(response.getStatusCode());
//        System.out.println(response.asString());
//        LinkConfig linkconfig = wapHallService.getLinkConfigByType(77);
//        String imageName=linkConfig.getImageName();
        LinkConfig linkconfig = linkConfigDao.selectByPrimaryKey("2018021116LC064229729");
        System.out.println("55555555");
//        System.out.println(linkconfig);
        if(response.getStatusCode()==200){
            JsonPath jp = new JsonPath(json);
//            assertEquals(100, jp.get("result"));


        }
    }

    @DataProvider(name="wap_hall_param")
    public Object[][] createData() {
        Object[][] retObjArr = {  {"https://wap.ttacp8.com/wap_hall.html"} };
        return (retObjArr);
    }

}
