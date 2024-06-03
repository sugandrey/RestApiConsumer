package org.example;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class Consumer {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> jsonToSend = new HashMap<>();
        jsonToSend.put("name", "test name");
        jsonToSend.put("job", "test job");
        HttpEntity<Map<String, String>> httpEntity = new HttpEntity(jsonToSend);
        String url = "https://reqres.in/api/users/2";
        String response = restTemplate.getForObject(url, String.class);

        String url2 = "https://reqres.in/api/users";
        String response2 = restTemplate.postForObject(url2, httpEntity, String.class);
        System.out.println(response2);
    }
}
