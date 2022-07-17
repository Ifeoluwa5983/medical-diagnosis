package com.diagnisis.service;

import com.diagnisis.request.Symptoms;
import com.diagnisis.response.Diagnosis;
import com.diagnisis.response.LoginResponse;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.digest.HmacUtils;

//import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.*;
import org.springframework.util.Base64Utils;

import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.nio.charset.StandardCharsets;

@Service
public class MedicalDiagnosisService {

    RestTemplate restTemplate = new RestTemplate();

    String api_key = "j3RLy_GMAIL_COM_AUT";
    static String secret_key = "i2C6Pop5S7FeHz3w4";
    static byte[] secretBytes = secret_key.getBytes(StandardCharsets.UTF_8);
    String computedHashString = "";

    public static byte[] hmacMd5() {
//        Digest digest = getHashDigest("HmacMD5");
//
//        HMac hMac = new HMac(digest);
        String uri
                = "https://sandbox-authservice.priaid.ch/login";
        byte[] dataBytes = uri.getBytes(StandardCharsets.UTF_8);
        String computedHashString = new HmacUtils("HmacMD5", secret_key).hmacHex(uri);
//        return hmac;
        System.out.println(computedHashString);
        byte[] computedHash = computedHashString.getBytes();

        System.out.println(computedHash);
        return computedHash;
    }


    public String login(){
        computedHashString = Base64Utils.encodeToString(hmacMd5());
        System.out.println(computedHashString);
        String url
                = "https://sandbox-authservice.priaid.ch/login";
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth("Bearer " +  api_key + ":" + computedHashString);
        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        ResponseEntity<LoginResponse> loginResponse = restTemplate.exchange(url, HttpMethod.POST, request , LoginResponse.class);
        ObjectMapper objectMapper = new ObjectMapper();
        return loginResponse.getBody().getToken();
    }

    public Object getDiagnosis(Symptoms symptoms){
        String url
                = "https://sandbox-healthservice.priaid.ch/diagnosis";
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("gender",symptoms.getGender())
                .queryParam("symptoms",symptoms.getSymptoms())
                .queryParam("year_of_birth",symptoms.getYearOfBirth())
                .queryParam("token",symptoms.getToken())
                .queryParam("language",symptoms.getLanguage())
                .build();
        System.out.println(builder.toUriString());
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        ResponseEntity<Object> diagnosisResponseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, request , Object.class);
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
//        objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
//        objectMapper.convertValue(diagnosisResponseEntity.getBody(), Diagnosis.class);
        return diagnosisResponseEntity.getBody();
    }
}
