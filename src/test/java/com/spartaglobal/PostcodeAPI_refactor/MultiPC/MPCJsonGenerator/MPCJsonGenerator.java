package com.spartaglobal.PostcodeAPI_refactor.MultiPC.MPCJsonGenerator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.apache.http.entity.StringEntity;

public class MPCJsonGenerator {
    //{"postcodes": [se57qj}

    private ObjectMapper objectMapper = new ObjectMapper();

    //http object, way to manage a http object
    //parsing it a lost of postcodes
    public StringEntity createMPCJsonQuery(String listOfPostcodesSplitByComma){

        ArrayNode postcodeArrayNode = objectMapper.createArrayNode();
        String MPCBaseNode = "{\"postcodes\":";
        String closeJsonBracket = "}";
        //breaks the string up by a particular point
        String [] postCodeArray = listOfPostcodesSplitByComma.split(",");

        //looping through the split and adding it to the postcode array node
        for (String postcode:postCodeArray){
            postcodeArrayNode.add(postcode.replaceAll("\\s", " "));
        }

        System.out.println(MPCBaseNode + postcodeArrayNode + closeJsonBracket);
        return new StringEntity(MPCBaseNode + postcodeArrayNode + closeJsonBracket, "UTF-8");
    }

}
