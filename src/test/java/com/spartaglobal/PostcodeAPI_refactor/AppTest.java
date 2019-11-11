package com.spartaglobal.PostcodeAPI_refactor;

import static org.junit.Assert.assertTrue;

import com.spartaglobal.PostcodeAPI_refactor.MultiPC.MPCHTTPManagagement.MPCHttpCallManager;
import com.spartaglobal.PostcodeAPI_refactor.MultiPC.MPCJsonGenerator.MPCJsonGenerator;
import com.spartaglobal.PostcodeAPI_refactor.MultiPC.MPCService;
import com.spartaglobal.PostcodeAPI_refactor.SinglePC.SPCHTTPManager.SPCHttpResponseManager;
import com.spartaglobal.PostcodeAPI_refactor.SinglePC.SPCHTTPManager.SPHttpCallManager;
import com.spartaglobal.PostcodeAPI_refactor.SinglePC.SinglePCService;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    private static SinglePCService singlePCService;
   private static MPCService mpcService;
   public static Map<String, Object> firstResponse;
   

    @BeforeClass
    public static void setup() {
        singlePCService = new SinglePCService();
        singlePCService.executeSinglePostcodeCall("se57qj");

        mpcService = new MPCService();
        mpcService.executeMPCPostcodeRequest("se57qj, SE2 0HD");
        Map<String, Object> firstResponse = mpcService.getParsedJSONResponse().getResult().get(0);
        Map<String, Object> secondResponse = mpcService.getParsedJSONResponse().getResult().get(1);



    }

    @Test
    public void shouldAnswerWithTrue()
    {
        System.out.println(mpcService.getParsedJSONResponse().getStatus());
        System.out.println(mpcService.getParsedJSONResponse().getResult());
    }

}
