package com.spartaglobal.PostcodeAPI_refactor.SinglePC.SPDTO;

import java.util.Map;

public class SPCDTO {
    private long status;
    private Map<String,Object > result;

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public Map<String, Object> getResult() {
        return result;
    }

    public void setResult(Map<String, Object> result) {
        this.result = result;
    }
}
