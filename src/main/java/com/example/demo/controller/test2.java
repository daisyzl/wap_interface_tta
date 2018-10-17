package com.example.demo.controller;

import com.example.demo.raw.IRow;
import com.example.demo.service.YamlLoadService;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.*;

import static io.restassured.RestAssured.get;
import static io.restassured.path.json.JsonPath.from;

/*
主要是通过读取yaml中数据
 */
public class test2 {
    private static Logger log= LoggerFactory.getLogger(test2.class);

    @Test(description = "大厅接口",dataProvider = "wap_hall_param")
    public void wap_hall_info(IRow iRow) throws IOException, InterruptedException {
        String caseUrl = (String) iRow.getCommonData().get("caseUrl");
        Response response = get(caseUrl);
        String json=response.asString();
        log.info("response=" + response.asString());

        Map<String, ?> dbParams = iRow.getCaseData().getDbParams();
        Map bannerList = (Map) dbParams.get("bannerList");
        ArrayList<Map> gameInfoListEX = (ArrayList<Map>) dbParams.get("gameInfoList");
        System.out.println(bannerList);
        System.out.println("999999999");
        System.out.println(gameInfoListEX.get(1).get("gameCn"));

        if (response.getStatusCode() == 200) {
            JsonPath jp = new JsonPath(json);
            /*
            expected
             */
            Integer resultEX=(Integer)iRow.getCaseData().getResultParams().get("result");
            Integer totalAwardEX=(Integer)iRow.getCaseData().getResultParams().get("totalAward");
            String gameCn1EX=(String)gameInfoListEX.get(0).get("gameCn");
            /*
            actual
             */
            System.out.println(response.getBody().jsonPath().getString("result"));
            Integer result=from(json).get("result");
            Integer totalAward=from(json).get("totalAward");
            List<Map> gameInfoList=from(json).get("gameInfoList");
            String gameCn1=(String)gameInfoList.get(0).get("gameCn");

            /*
            assert
             */
            Assert.assertEquals(result,resultEX);
            Assert.assertEquals(totalAward,totalAwardEX);
            Assert.assertEquals(gameCn1,gameCn1EX);


        }
    }

    @DataProvider(name = "wap_hall_param")
    public Iterator<Object[]> wapHallParam() {
        return new YamlLoadService().load("test.yaml");
    }
}
