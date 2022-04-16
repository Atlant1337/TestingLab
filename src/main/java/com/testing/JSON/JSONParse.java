package com.testing.JSON;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.util.Iterator;

public class JSONParse{

    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("CreateJson.json"));
            JSONObject jsonObject = (JSONObject) obj;

            JSONArray tag = (JSONArray) jsonObject.get("tag0");

            Iterator<JSONObject> iterator = tag.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}