package com.example.LeadManagement.service;

import com.example.LeadManagement.entity.LeadEntity;
import com.example.LeadManagement.modal.LeadPayload;
import com.example.LeadManagement.repository.LeadRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class LeadService {
    @Autowired
    LeadRepository leadRepository;


    public List<LeadEntity> getAllLead() {
        List<LeadEntity> leadEntitiesList = leadRepository.findAll();
        return leadEntitiesList;
    }

    public ResponseEntity<Map<String, Object>> saveLeadInfo(LeadPayload payload) {
        log.info("inside saveLeadInfo=========begin==========");
        LeadEntity leadEntity = leadRepository.findByLeadId(Integer.valueOf(payload.getLeadId()));
        Map<String, Object> map = new HashMap<>();

        if (leadEntity == null) {
            leadEntity = new LeadEntity();
            leadEntity.setLeadId(Integer.valueOf(payload.getLeadId()));
            leadEntity.setDob(payload.getDob());
            leadEntity.setFirstName(payload.getFirstName());
            leadEntity.setMiddleName(payload.getMiddleName());
            leadEntity.setLastName(payload.getLastName());
            leadEntity.setGender(payload.getGender());
            leadEntity.setMobileNumber(payload.getMobileNumber());
            leadEntity.setEmail(payload.getEmail());
            leadRepository.save(leadEntity);
            map.put("status", "success");
            map.put("data", "Created Leads Successfully");
            return new ResponseEntity<>(map, HttpStatus.OK);

        } else {
            Map<String, Object> map1 = new HashMap<>();
            List<String> list = new ArrayList<>();
            list.add("Lead Already Exists in the database with the lead id");
            map1.put("code", "E10010");
            map1.put("messages", list);
            map.put("status", "Error");
            map.put("errorResponse", map1);

            return new ResponseEntity<>(map, HttpStatus.OK);
        }

    }
}
