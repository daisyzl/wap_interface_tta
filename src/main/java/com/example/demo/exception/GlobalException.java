package com.example.demo.exception;

import com.example.demo.enums.ResultEnum;

public class GlobalException extends RuntimeException{
    private ResultEnum re;

    public GlobalException(ResultEnum re) {
        super(re.getMsg());
        this.re = re;
    }

    public ResultEnum getRe() {
        return re;
    }
}
