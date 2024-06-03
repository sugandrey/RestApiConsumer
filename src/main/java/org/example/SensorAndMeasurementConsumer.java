package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class SensorAndMeasurementConsumer {
    public static void main(String[] args) throws JsonProcessingException {
        final String postSensorUrl = "http://localhost:7080/sensors/registration";
        final String getSensorUrl = "http://localhost:7080/sensors";
        final String postMeasurements = "http://localhost:7080/measurements/add";
        final String getMeasurements = "http://localhost:7080/measurements";
        final Class sensorClass = SensorClient.class;
        final Field[] sensorFields = sensorClass.getDeclaredFields();
        final RestTemplate restTemplate = new RestTemplate();
        final String sensor = restTemplate.getForObject(getSensorUrl, String.class);
        final ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(sensor);
        final List<String> sensors = new ArrayList<>();
//        for (int i = 0; i < jsonNode.size(); i++) {
//            sensors.add(jsonNode.get(i).get("sensorName").textValue());
//        }
//        final Class measurementClient = MeasurementClient.class;
//        final Field[] measurementFields = measurementClient.getDeclaredFields();
//        final String measurementValueField = measurementFields[0].getName();
//        final String measurementRainingField = measurementFields[1].getName();
//        final String sensorField = measurementFields[2].getName();
//        final int min = -100;
//        final int max = 100;
//        final Random rainingRandom = new Random();
//        final Random randomSensor = new Random();
//        for (int k = 0; k < 1000; k++) {
//            final String randomSensorName = sensors.get(randomSensor.nextInt(sensors.size()));
//            final String randomRainingValue = String.valueOf(rainingRandom.nextBoolean());
//            final long randomTemperatureValue = (long)(Math.random() * (max - min + 1)) + min;
//            final Map<String, Object> measureMap = new HashMap<>();
//            final SensorClient sensorClient = new SensorClient();
//            sensorClient.setSensorName(randomSensorName);
//            measureMap.put(measurementValueField, randomTemperatureValue);
//            measureMap.put(measurementRainingField, randomRainingValue);
//            measureMap.put(sensorField, sensorClient);
//            final HttpEntity<Map<String, Object>> request = new HttpEntity<>(measureMap);
//            final String response = restTemplate.postForObject(postMeasurements, request, String.class);
//        }



//        final String sensorFieldName = sensorFields[0].getName();
//        for (int i = 0; i < 20; i++) {
//            final RestTemplate restTemplate = new RestTemplate();
//            final Map<String, String> sensorMap = new HashMap<>();
//            final SensorClient sensorClient = new SensorClient("testSensor" + i);
//            sensorMap.put(sensorFieldName, sensorClient.getSensorName());
//            final HttpEntity<Map<String, String>> request = new HttpEntity<>(sensorMap);
//            SensorClient response = restTemplate.postForObject(postSensorUrl, request, SensorClient.class);
//            System.out.println(response.getSensorName());
//    }
        final String measurements = restTemplate.getForObject(getMeasurements, String.class);
        jsonNode = objectMapper.readTree(measurements);
        List<Double> temperatures = new ArrayList<>();
        List<Double> numbers = new ArrayList<>();
        for (int i = 0; i < jsonNode.size(); i++) {
            String value = jsonNode.get(i).get("value").asText();
            String raining = jsonNode.get(i).get("raining").textValue();
            String sens = jsonNode.get(i).get("sensor").get("sensorName").textValue();
            temperatures.add(jsonNode.get(i).get("value").asDouble());
            numbers.add((double)i);
//            System.out.println(temperatures.get(i) + " : " + numbers.get(i));
        }
        XYChart chart = QuickChart.getChart("Sample Chart", "X", "Y", "y(x)", numbers, temperatures);
        new SwingWrapper(chart).displayChart();

    }
    }


