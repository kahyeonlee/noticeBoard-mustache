package com.mustache.noticeboard.controller;

import com.mustache.noticeboard.domain.dto.HospitalResponse;
import com.mustache.noticeboard.domain.entity.Hospital;
import com.mustache.noticeboard.repository.HospitalRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
@RestController
@RequestMapping("/api/v1/hospitals")
public class HospitalRestController {

    private  final HospitalRepository hospitalRepository;


    public HospitalRestController(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<HospitalResponse> get(@PathVariable Integer id) {// resposeentity도 dto타입
        Optional<Hospital> hospital = hospitalRepository.findById(id); //entity
        HospitalResponse hospitalResponse = Hospital.of(hospital.get()); //dto
        return ResponseEntity.ok().body(hospitalResponse); //dto
    }

}
