package com.automation.utils;

import com.automation.pojo.UpdatedResourcePojo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import com.automation.pojo.CreateResourcePojo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RestAssuredUtils {

    static RequestSpecification requestSpecification = RestAssured.given();
    static String endPoint;
    static Response response;

    public static void setEndPoint(String endPoint) {
        RestAssuredUtils.endPoint = endPoint;
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }

    public static void setHeader(String key, String value) {
        requestSpecification = requestSpecification.header(key, value);
    }

    public static void sendBody(String fileName) {
        String folderPath = ConfigReader.getValue("json.folder.path");
        String body = readData(folderPath + fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        CreateResourcePojo createResourcePojo;
        try {
            createResourcePojo = objectMapper.readValue(body, CreateResourcePojo.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        requestSpecification = requestSpecification.body(createResourcePojo);
    }

    public static void sendUpdatedBody(String fileName) {
        String folderPath = ConfigReader.getValue("json.folder.path");
        String body = readData(folderPath + fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        UpdatedResourcePojo updatedResourcePojo;
        try {
            updatedResourcePojo = objectMapper.readValue(body, UpdatedResourcePojo.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        requestSpecification = requestSpecification.body(updatedResourcePojo);
    }

    public static String readData(String fileName) {
        String content;
        try {
            content = new Scanner(new FileInputStream(fileName)).useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return content;
    }

    public static Response post() {
        response = requestSpecification.post(endPoint);
        response.then().log().all();
        return response;
    }

    public static Response get() {
        response = requestSpecification.get(endPoint);
        response.then().log().all();
        return response;
    }


    public static Response put() {
        response = requestSpecification.put(endPoint);
        response.then().log().all();
        return response;
    }

    public static Response patch() {
        response = requestSpecification.patch(endPoint);
        response.then().log().all();
        return response;
    }


    public static Response delete() {
        response = requestSpecification.delete(endPoint);
        response.then().log().all();
        return response;
    }


    public static Response getResponse() {
        return response;
    }

    public static int getStatusCode() {
        return response.getStatusCode();
    }

}
