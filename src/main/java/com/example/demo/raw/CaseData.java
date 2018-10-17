package com.example.demo.raw;

import java.util.HashMap;

public class CaseData {
    /*
       数据库参数，用于数据库操作
        */
    private HashMap<String, ?> dbParams;
    /*
    结果断言需要用的数据
     */
    private HashMap<String, Object> resultParams;
    /*
    查询接口需要用的数据
     */
    private HashMap<String, String> queryParams;

    private String desc;

    public HashMap<String, ?> getDbParams() {
        return dbParams;
    }

    public HashMap<String, Object> getResultParams() {
        return resultParams;
    }

    public HashMap<String, String> getQueryParams() {
        return queryParams;
    }

    public String getDesc() {
        return desc;
    }

    public void setDbParams(HashMap<String, Object> dbParams) {
        this.dbParams = dbParams;
    }

    public void setResultParams(HashMap<String, Object> resultParams) {
        this.resultParams = resultParams;
    }

    public void setQueryParams(HashMap<String, String> queryParams) {
        this.queryParams = queryParams;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "dbParams = " + dbParams.toString() + " queryParams = " +
                queryParams.toString() + " resultParams = " + resultParams.toString();
    }

}
