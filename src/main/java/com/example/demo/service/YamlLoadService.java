package com.example.demo.service;

import com.example.demo.controller.test2;
import com.example.demo.raw.CaseData;
import com.example.demo.raw.IData;
import com.example.demo.raw.IRow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class YamlLoadService {
    private static Logger log = LoggerFactory.getLogger(YamlLoadService.class);

    //存放yaml文件的1级路径
    private static final String PATH_PREFIX = "dataprovider/";

    @Autowired
    private IData iData;

    public Iterator<Object[]> load(String filePath) {
        Yaml yaml = new Yaml();
        ClassLoader classloader = this.getClass().getClassLoader();
        URL url = classloader.getResource(PATH_PREFIX + filePath);
        System.out.println(url);
        try {
            File yamlFile = null;
            if (url != null) {
                System.out.println("888888888");
                System.out.println("6666666666");
                File file1=new File(url.getFile());
                System.out.println("333333333");
                FileInputStream fin1=new FileInputStream(file1);
                System.out.println("444444444");
                Object yamFile=yaml.load(fin1);
                System.out.println("7777777777");
                System.out.println(yamFile);
                System.out.println("999999999");
//                iData = yaml.loadAs(fin1, IData.class);
                iData = yaml.loadAs(new FileInputStream(new File(url.getFile())), IData.class);
                if(iData==null)
                {

                    System.out.println("363636");
                }
                System.out.println(iData.getCommonData());
                System.out.println(iData.getCaseDataList());
            }
//            assert yamlFile != null;
//            iData = yaml.loadAs(new FileInputStream(yamlFile), IData.class);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<Object> item = new ArrayList<Object>();
        List<Object[]> iDatas = new ArrayList<Object[]>();
        for (CaseData caseData : iData.getCaseDataList()) {
            IRow iRow = new IRow();
            iRow.setCaseData(caseData);
            iRow.setCommonData(iData.getCommonData());
            item.add(iRow);
        }
        //转换一下格式
        for (Object o : item) {
            iDatas.add(new Object[]{o});
        }
        //返回迭代器
        return iDatas.iterator();
    }
}
