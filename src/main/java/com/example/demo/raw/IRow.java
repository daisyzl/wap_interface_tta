package com.example.demo.raw;

import java.util.HashMap;

public class IRow {
  /*
    组合了公共参数和一条用例参数
     */

    private CaseData caseData;

    private HashMap commonData;

    public CaseData getCaseData() {
        return caseData;
    }

    public HashMap getCommonData() {
        return commonData;
    }

    public void setCaseData(CaseData caseData) {
        this.caseData = caseData;
    }

    public void setCommonData(HashMap commonData) {
        this.commonData = commonData;
    }

    @Override
    public String toString() {
        return "caseData = " + caseData.toString() + " commonData = " + commonData;
    }

}
