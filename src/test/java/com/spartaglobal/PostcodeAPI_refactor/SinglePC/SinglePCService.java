package com.spartaglobal.PostcodeAPI_refactor.SinglePC;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spartaglobal.PostcodeAPI_refactor.SinglePC.SPCHTTPManager.SPCHttpResponseManager;
import com.spartaglobal.PostcodeAPI_refactor.SinglePC.SPCHTTPManager.SPHttpCallManager;
import com.spartaglobal.PostcodeAPI_refactor.SinglePC.SPDTO.SPCDTO;

import javax.imageio.IIOException;
import java.io.IOException;

public class SinglePCService {

    private SPHttpCallManager spHttpCallManager;
    private SPCHttpResponseManager spcHttpResponseManager;
    private ObjectMapper objectMapper;

    public SinglePCService() {
        spHttpCallManager = new SPHttpCallManager();
        spcHttpResponseManager = new SPCHttpResponseManager();
        objectMapper = new ObjectMapper();
    }

    public void executeSinglePostcodeCall(String postcode) {
        spcHttpResponseManager.setFullResponse((spHttpCallManager.executeSPGetRequest(postcode)));
    }


    public SPCDTO getParseJsonResponse() {
        SPCDTO parseResponse = null;
        try {
            parseResponse = objectMapper.readValue(spcHttpResponseManager.getResponseBody(), SPCDTO.class);
        } catch (IOException e) {
            e.printStackTrace();

        }
        return parseResponse;

    }
}
