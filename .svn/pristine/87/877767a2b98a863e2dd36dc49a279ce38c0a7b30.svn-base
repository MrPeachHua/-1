package com.boxiang.weixin.utils;

import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;

public class JsonMapper {

    private static ObjectMapper m = new ObjectMapper();
    private static JsonFactory jf = new JsonFactory();

    public static <T> Object fromJson(String jsonAsString, Class<T> pojoClass)
            throws JsonMappingException, JsonParseException, IOException {
        return m.readValue(jsonAsString, pojoClass);
    }

    public static <T> Object fromJson(FileReader fr, Class<T> pojoClass)
            throws JsonParseException, IOException {
        return m.readValue(fr, pojoClass);
    }


 /*   public static String toJson(Object pojo, boolean prettyPrint)
            throws JsonMappingException, JsonGenerationException, IOException {
        StringWriter sw = new StringWriter();
        JsonGenerator jg = jf.createJsonGenerator(sw);
        if (prettyPrint) {
            jg.useDefaultPrettyPrinter();
        }
        m.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
        m.writeValue(jg, pojo);
        return sw.toString();
    }*/

    public static void toJson(Object pojo, FileWriter fw, boolean prettyPrint)
            throws JsonMappingException, JsonGenerationException, IOException {
        JsonGenerator jg = jf.createJsonGenerator(fw);
        if (prettyPrint) {
            jg.useDefaultPrettyPrinter();
        }
        m.writeValue(jg, pojo);
    }

    public static String getJsonString(HttpServletRequest request) throws IOException {
        String jsonString = null;
        jsonString = getJsonByRequestParameter(request);
        if (jsonString == null || jsonString.trim().length() == 0) {
            jsonString = getJsonByInputStream(request);
        }
        return jsonString;
    }

    public static String getJsonByInputStream(HttpServletRequest request) throws IOException {
        String jsonString = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int len = 0;
        InputStream is = request.getInputStream();
        while ((len = is.read(buf)) != -1) {
            baos.write(buf, 0, len);
        }
        baos.flush();
        jsonString = baos.toString("UTF-8");
        baos.close();
        is.close();
        return jsonString;
    }

    public static String getJsonByRequestParameter(HttpServletRequest request) {
        String jsonString = null;
        Enumeration<String> enumeration = request.getParameterNames();
        while (enumeration.hasMoreElements()) {
            jsonString = enumeration.nextElement();
        }
        return jsonString;
    }
}
