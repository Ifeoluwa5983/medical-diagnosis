package com.diagnisis.controller;

import com.diagnisis.request.Symptoms;
import com.diagnisis.service.MedicalDiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MedicalDiagnosisController {

    @Autowired
    MedicalDiagnosisService medicalDiagnosisService;

    @PostMapping("/diagonise")
    public ResponseEntity<?> diagoise(@RequestBody Symptoms symptoms){
        Object object = medicalDiagnosisService.getDiagnosis(symptoms);
        return ResponseEntity.status(200).body(object);
    }
}
