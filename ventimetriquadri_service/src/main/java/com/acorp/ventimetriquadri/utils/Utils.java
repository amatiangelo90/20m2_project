package com.acorp.ventimetriquadri.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.text.SimpleDateFormat;

public class Utils {

    public static SimpleDateFormat globalDTFormat = new SimpleDateFormat("yyyy-MM-dd");

    private static ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

    public static String jsonFormat(Object object){
        try {
            return ow.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Errore durante la conversione dell'oggetto in String JSON";
        }
    }

}
