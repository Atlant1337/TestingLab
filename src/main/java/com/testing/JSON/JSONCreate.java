package com.testing.JSON;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class JSONCreate {
    public static void main(String[] args) {

        Map<Object, Object> obj2 = new LinkedHashMap<>();
        obj2.put("Id", "001");
        obj2.put("t1", "string");
        obj2.put("t2", "string");
        obj2.put("t3", "date or int");

        Map<Integer, String> array = new LinkedHashMap<>();
        array.put(1,"string");
        array.put(2,"string");
        obj2.put("listElements", array);
        obj2.put("t5", "int");

        JSONObject tag21 = new JSONObject();
        JSONObject tag1Value = new JSONObject();
        tag21.put("tag2", obj2);
        tag1Value.put("tag1", tag21);

        Map<Object, Object> obj22 = new LinkedHashMap<>();
        obj22.put("Id", "002");
        obj22.put("t1", "string");
        obj22.put("t2", "string");
        obj22.put("t3", "date or int");

        Map<Integer, String> array2 = new LinkedHashMap<>();
        array2.put(1,"string");
        array2.put(2,"string");
        obj22.put("listElements", array2);
        obj22.put("t5", "001");

        JSONObject tag22 = new JSONObject();
        tag22.put("tag2", obj22);

        Map<Object, Object> obj3 = new LinkedHashMap<>();
        obj3.put("Id", "003");
        obj3.put("t1", "string");
        obj3.put("t2", "string");
        obj3.put("t3", "date or int");

        Map<Integer, String> array3 = new LinkedHashMap<>();
        array3.put(1,"string");
        array3.put(2,"string");
        obj3.put("listElements", array3);
        obj3.put("t5", "int");

        JSONObject tag23 = new JSONObject();
        JSONObject tag1WithValue2 = new JSONObject();
        tag23.put("tag2", obj3);
        tag1WithValue2.put("tag1", tag23);

        Map<Object, Object> obj33 = new LinkedHashMap<>();
        obj33.put("Id", "004");
        obj33.put("t1", "string");
        obj33.put("t2", "string");
        obj33.put("t3", "date or int");

        Map<Integer, String> array4 = new LinkedHashMap<>();
        array4.put(1,"string");
        array4.put(2,"string");
        obj33.put("listElements", array4);
        obj33.put("t5", "002");

        JSONObject tag24 = new JSONObject();
        tag24.put("tag2", obj33);

        JSONArray tag1Id = new JSONArray();
        JSONArray tag1Id2 = new JSONArray();
        Map<Object, Object> m1 = new LinkedHashMap<>();
        m1.put("tag1Name", "t1Name1");
        m1.put("tagId", "1");
        tag1Id.add(m1);
        tag1Id.add(tag21);
        tag1Id.add(tag22);

        Map<Object, Object> map12 = new LinkedHashMap<>();
        map12.put("tag1Name", "t1Name2");
        map12.put("tagId", "2");
        tag1Id2.add(map12);
        tag1Id2.add(tag23);
        tag1Id2.add(tag24);

        JSONObject tag1 = new JSONObject();
        JSONObject tag12 = new JSONObject();
        tag1.put("tag1",tag1Id);
        tag12.put("tag1",tag1Id2);

        JSONObject tag0 = new JSONObject();
        JSONArray tag0List = new JSONArray();
        tag0List.add(tag1);
        tag0List.add(tag12);
        tag0.put("tag0", tag0List);

        try(FileWriter file = new FileWriter("CreateJSON.json")){
            file.write(tag0.toJSONString());
            file.flush();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}