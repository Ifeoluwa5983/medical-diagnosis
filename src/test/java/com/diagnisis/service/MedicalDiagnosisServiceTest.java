package com.diagnisis.service;

import com.diagnisis.request.Symptoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MedicalDiagnosisServiceTest {

    @Autowired
    MedicalDiagnosisService medicalDiagnosisService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void login() {
        medicalDiagnosisService.login();
    }
    @Test
    void diagnose(){
        int[] symptom = new int[] { 235};

        Symptoms symptoms = new Symptoms();
        symptoms.setLanguage("de-ch");
        symptoms.setGender("female");
        symptoms.setToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6Im8uaWZlb2x1d2FoQGdtYWlsLmNvbSIsInJvbGUiOiJVc2VyIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvc2lkIjoiMTA5MjMiLCJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3ZlcnNpb24iOiIyMDAiLCJodHRwOi8vZXhhbXBsZS5vcmcvY2xhaW1zL2xpbWl0IjoiOTk5OTk5OTk5IiwiaHR0cDovL2V4YW1wbGUub3JnL2NsYWltcy9tZW1iZXJzaGlwIjoiUHJlbWl1bSIsImh0dHA6Ly9leGFtcGxlLm9yZy9jbGFpbXMvbGFuZ3VhZ2UiOiJlbi1nYiIsImh0dHA6Ly9zY2hlbWFzLm1pY3Jvc29mdC5jb20vd3MvMjAwOC8wNi9pZGVudGl0eS9jbGFpbXMvZXhwaXJhdGlvbiI6IjIwOTktMTItMzEiLCJodHRwOi8vZXhhbXBsZS5vcmcvY2xhaW1zL21lbWJlcnNoaXBzdGFydCI6IjIwMjItMDctMTUiLCJpc3MiOiJodHRwczovL3NhbmRib3gtYXV0aHNlcnZpY2UucHJpYWlkLmNoIiwiYXVkIjoiaHR0cHM6Ly9oZWFsdGhzZXJ2aWNlLnByaWFpZC5jaCIsImV4cCI6MTY1ODA3NjQwOCwibmJmIjoxNjU4MDY5MjA4fQ.dJu4nS_ywb6aY2Ksc5eacPN6_LJibRJZEdZZZmvhNXw");
        symptoms.setYearOfBirth(1998);
//        System.out.println(symptom[1]);
        symptoms.setSymptoms(Arrays.toString(symptom));
        System.out.println(medicalDiagnosisService.getDiagnosis(symptoms));
    }
}