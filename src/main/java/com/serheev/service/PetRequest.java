package com.serheev.service;

import com.serheev.model.Pet;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.IOException;

public class PetRequest {

    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    private static org.apache.log4j.Logger log = Logger.getLogger(PetRequest.class);

    private static String uri = "https://petstore.swagger.io/v2/pet/";
    private static int statusCode;

    public void close() throws IOException {
        httpClient.close();
    }

    public int doGet(int id) throws Exception {

        HttpGet request = new HttpGet(uri + id);

        try (CloseableHttpResponse response = httpClient.execute(request)) {
            statusCode = response.getStatusLine().getStatusCode();
            HttpEntity entity = response.getEntity();
            Header headers = entity.getContentType();
            log.info(headers);
            if (entity != null) {
                String result = EntityUtils.toString(entity);
                log.info(result);
            }
        }
        return statusCode;
    }

    public int doPost(Pet pet) throws Exception {

        HttpPost post = new HttpPost(uri);
        post.addHeader("accept", "application/json");
        post.addHeader("content-type", "application/json");

        StringBuilder json = new StringBuilder();
        json.append("{ \"id\": " + pet.getId() + ", \"category\": { \"id\": " + pet.getCategory_id() + ", \"name\": \"" + pet.getCategory_name() + "\" }, \"name\": \"" + pet.getName() + "\", \"photoUrls\": [ \"string\" ], \"tags\": [ { \"id\": 0, \"name\": \"animals\" } ], \"status\": \"" + pet.getStatus() + "\"}");

        post.setEntity(new StringEntity(json.toString()));

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {
            statusCode = response.getStatusLine().getStatusCode();
            log.info(EntityUtils.toString(response.getEntity()));
        }
        return statusCode;
    }

    public int doPut(Pet pet) throws Exception {

        HttpPut put = new HttpPut(uri);
        put.addHeader("accept", "application/json");
        put.addHeader("content-type", "application/json");

        StringBuilder json = new StringBuilder();
        json.append("{ \"id\": " + pet.getId() + ", \"category\": { \"id\": " + pet.getCategory_id() + ", \"name\": \"" + pet.getCategory_name() + "\" }, \"name\": \"" + pet.getName() + "\", \"photoUrls\": [ \"string\" ], \"tags\": [ { \"id\": 0, \"name\": \"animals\" } ], \"status\": \"" + pet.getStatus() + "\"}");

        put.setEntity(new StringEntity(json.toString()));

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(put)) {
            statusCode = response.getStatusLine().getStatusCode();
            log.info(EntityUtils.toString(response.getEntity()));
        }
        return statusCode;
    }

    public int doDelete(int id) throws Exception {

        HttpDelete delete = new HttpDelete(uri + id);
        delete.addHeader("accept", "application/json");

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(delete)) {
            statusCode = response.getStatusLine().getStatusCode();
        }
        return statusCode;
    }
}
