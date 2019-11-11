package com.spartaglobal.PostcodeAPI_refactor;

import static org.junit.Assert.assertTrue;

import com.spartaglobal.PostcodeAPI_refactor.SinglePC.SPCHTTPManager.SPCHttpResponseManager;
import com.spartaglobal.PostcodeAPI_refactor.SinglePC.SPCHTTPManager.SPHttpCallManager;
import com.spartaglobal.PostcodeAPI_refactor.SinglePC.SinglePCService;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    private static SinglePCService singlePCService;

    @BeforeClass
    public static void setup() {
        singlePCService = new SinglePCService();
        singlePCService.executeSinglePostcodeCall("se57qj");



    }

    @Test
    public void shouldAnswerWithTrue()
    {
        System.out.println(singlePCService.getParseJsonResponse().getStatus());
    }




}
