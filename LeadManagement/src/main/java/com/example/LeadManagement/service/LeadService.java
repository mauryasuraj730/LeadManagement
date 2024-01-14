package com.example.LeadManagement.service;

import com.example.LeadManagement.entity.LeadEntity;
import com.example.LeadManagement.modal.LeadPayload;
import com.example.LeadManagement.repository.LeadRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class LeadService {
    @Autowired
    LeadRepository leadRepository;


    public List<LeadEntity> getAllLead(){
       List<LeadEntity>  leadEntitiesList= leadRepository.findAll();
       return leadEntitiesList;
    }

    public boolean saveLeadInfo(LeadPayload payload) {
       boolean isPresent=false;
        LeadEntity leadEntity = leadRepository.findByLeadId(Integer.valueOf(payload.getLeadId()));
        try {
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
                log.info("data saved successfully " + leadEntity);
            } else {
                isPresent=true;
                log.info("data already present in db " + leadEntity);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isPresent;
    }
}
