package com.example.demo;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.Assert.assertEquals;


public class test {
    @Test(description = "大厅接口",dataProvider = "wap_hall_param")
    public void wap_hall_info(String url){
        Response response = get(url);
        String json=response.asString();
        System.out.println(response.getStatusCode());
//        System.out.println(response.asString());
        if(response.getStatusCode()==200){
            JsonPath jp = new JsonPath(json);
            assertEquals(100, jp.get("result"));


        }
    }

    @DataProvider(name="wap_hall_param")
    public Object[][] createData() {
        Object[][] retObjArr = {  {"https://wap.ttacp8.com/wap_hall.html"} };
        return (retObjArr);
    }

}
