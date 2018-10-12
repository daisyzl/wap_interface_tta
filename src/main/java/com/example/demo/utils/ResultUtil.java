package com.example.demo.utils;

import com.example.demo.domain.Result;
import com.example.demo.enums.ResultEnum;

public class ResultUtil {

    public static Result success(Object object){
        Result result=new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }


    public static Result error(ResultEnum codemsg){
        Result result=new Result();
        result.setCode(codemsg.getCode());
        result.setMsg(codemsg.getMsg());
        return result;

    }



}
