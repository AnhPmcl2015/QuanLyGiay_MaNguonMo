package com.shoe.ObjectToJson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertToJson {
    public static String ToJson(Object o){
        ObjectMapper mapper = new ObjectMapper();
        String json ="";
        try {

            json = mapper.writeValueAsString(o);
        }   catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
}
