package com.example.LeadManagement.repository;

import com.example.LeadManagement.entity.LeadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeadRepository extends JpaRepository<LeadEntity, Integer> {
    LeadEntity findByLeadId(Integer id);

}
