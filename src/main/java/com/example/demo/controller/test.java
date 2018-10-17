package com.example.demo.controller;

import com.example.demo.domain.LinkConfig;
import com.example.demo.oraclemapper.LinkConfigMapper;
import com.example.demo.raw.IRow;
import com.example.demo.utils.DatabaseUtil;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringBootConfiguration;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.get;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

@SpringBootConfiguration

/*
读取数据库
 */
public class test {
    private static Logger log= LoggerFactory.getLogger(test.class);

    @Test(description = "大厅接口",dataProvider = "wap_hall_param")
    public void wap_hall_info(String url) throws IOException, InterruptedException {
        Response response = get(url);
        String json=response.asString();
        log.info("response=" + response.asString());
        SqlSession session = DatabaseUtil.getSqlSession();
        LinkConfig linkconfig = session.selectOne("selectByLinkType", 77);
        if (response.getStatusCode() == 200) {
            JsonPath jp = new JsonPath(json);
            assertEquals(-1,jp.getInt("totalAward"));
            List<String> bannerList=jp.get("gameInfoList.gameCn");
            System.out.println(bannerList);


        }
    }

        @DataProvider(name = "wap_hall_param")
        public static Object[][] createData () {
            Object[][] retObjArr = {{"https://wap.ttacp8.com/wap_hall.html"}};
            return (retObjArr);
        }
    }


