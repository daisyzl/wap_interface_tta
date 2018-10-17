package com.example.demo.raw;

import java.util.HashMap;
import java.util.List;

public class IData {
    /*
每条用例的参数
 */
    private List<CaseData> caseDataList;
    /*
    公共参数
     */
    private HashMap commonData;

    public List<CaseData> getCaseDataList() {
        return caseDataList;
    }

    public HashMap getCommonData() {
        return commonData;
    }

    public void setCaseDataList(List<CaseData> caseDataList) {
        this.caseDataList = caseDataList;
    }

    public void setCommonData(HashMap commonData) {
        this.commonData = commonData;
    }

}
