package com.spartaglobal.PostcodeAPI_refactor.MultiPC;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spartaglobal.PostcodeAPI_refactor.MultiPC.MPCDTO.MPCDTO;
import com.spartaglobal.PostcodeAPI_refactor.MultiPC.MPCHTTPManagagement.MPCHttpCallManager;
import com.spartaglobal.PostcodeAPI_refactor.MultiPC.MPCHTTPManagagement.MPCResponseManager;

public class MPCService {

    private MPCHttpCallManager mpcHttpCallManager;
    private MPCResponseManager mpcResponseManager;
    private ObjectMapper objectMapper;

    public MPCService(){
        this.mpcHttpCallManager = new MPCHttpCallManager();
        this.mpcResponseManager = new MPCResponseManager();
        this.objectMapper = new ObjectMapper();
    }

    public void executeMPCPostcodeRequest(String listOfPostcodesSplitByCommas){
        mpcResponseManager.setFullResponse(mpcHttpCallManager.exectuteMPCRequest(listOfPostcodesSplitByCommas));
    }

    public MPCDTO getParsedJSONResponse (){
        MPCDTO parsedResponse = null;

        try {
            parsedResponse = objectMapper.readValue(mpcResponseManager.getResponseBody(), MPCDTO.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return parsedResponse;
    }

}
