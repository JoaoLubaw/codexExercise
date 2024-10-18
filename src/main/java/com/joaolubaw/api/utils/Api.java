package com.joaolubaw.api.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.ZonedDateTime;

@Service
public class Api {
    private final HttpClient client;
    private final Gson gson;

    public Api() {
        this.client = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public ZonedDateTime getCurrentUTCTime() {
        String url = "http://worldclockapi.com/api/json/utc/now";
        return sendGetRequestTime(url);
    }

    public String[] getCPNJInfos(String cnpjNumber) {
        String url = "https://open.cnpja.com/office/" + cnpjNumber;
        return sendGetRequestCNPJ(url);
    }

    private String[] sendGetRequestCNPJ(String url) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept", "application/json")
                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
                String alias = jsonObject.get("alias").getAsString();
                String mainActivity = jsonObject.getAsJsonObject("mainActivity").get("text").getAsString();
                return new String[]{alias, mainActivity};
            } else {
                System.out.println("Requisition failed. Status code:" + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    private ZonedDateTime sendGetRequestTime(String url) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept", "application/json")
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
                String currentUTCDateTimeStr = jsonObject.get("currentDateTime").getAsString();
                ZonedDateTime currentUTCDateTime = ZonedDateTime.parse(currentUTCDateTimeStr);
            return currentUTCDateTime;
            } else {
                System.out.println("Requisition failed. Status Code: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
