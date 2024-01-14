package com.example.LeadManagement.controller;

import com.example.LeadManagement.entity.LeadEntity;
import com.example.LeadManagement.modal.LeadPayload;
import com.example.LeadManagement.service.LeadService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/lead")
public class LeadController {
    @Autowired
    private LeadService leadService;

    @PostMapping("/save")
    public ResponseEntity<Map<String, Object>> saveLead(@Valid @RequestBody LeadPayload leadPayload) {
        log.info(" lead payload====>" + leadPayload);
        return leadService.saveLeadInfo(leadPayload);
    }


    @GetMapping("/get")
    public List<LeadEntity> getLead() {
        List<LeadEntity> leadEntitiesList = leadService.getAllLead();
        log.info(" lead payload====>");
        return leadEntitiesList;
    }
}


