package com.example.demo.service;

import com.example.demo.domain.LinkConfig;
import com.example.demo.oraclemapper.LinkConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WapHallService {


    @Autowired
    private LinkConfigMapper linkConfigDao;

    public LinkConfig getLinkConfigByType(Integer linkType){
        return linkConfigDao.selectByLinkType(linkType);

    }

    public LinkConfig getLinkConfigById(String Id){

        return linkConfigDao.selectByPrimaryKey(Id);

    }

}
