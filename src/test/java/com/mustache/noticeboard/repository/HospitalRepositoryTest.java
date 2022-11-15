package com.mustache.noticeboard.repository;

import com.mustache.noticeboard.domain.entity.Hospital;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HospitalRepositoryTest {
    @Autowired
    HospitalRepository hospitalRepository;

    @Test
    @DisplayName("보건소/보건지소/보건진료소인 데이터가 잘나오는지")
    void findByBusinessTypeNameIn() {
        List<String> inClues = new ArrayList<>();
        inClues.add("보건소");
        inClues.add("보건지소");
        inClues.add("보건진료소");
        List<Hospital> hospitals = hospitalRepository.findByBusinessTypeNameIn(inClues);
        for (var hospital :
                hospitals) {
            System.out.println(hospital.getHospitalName());
        }
    }

    @Test
    void containing(){
        List<Hospital> hospitals = hospitalRepository.findByRoadNameAddressContaining("송파구");
        printHospitalNameAndAddress(hospitals);
    }
    //테스트 출력
    void printHospitalNameAndAddress(List<Hospital> hospitals) {
        for (var hospital : hospitals) {
            System.out.printf("%s | %s %f\n", hospital.getHospitalName(), hospital.getRoadNameAddress(), hospital.getTotalAreaSize());
        }

        System.out.println(hospitals.size());
    }

    @Test
    void startsWith() {
        List<Hospital> hospitals = hospitalRepository.findByHospitalNameStartsWith("경희");// 가톨릭 서울 연세 경희
        printHospitalNameAndAddress(hospitals);
    }

    @Test
    void endsWith() {
        List<Hospital> hospitals = hospitalRepository.findByHospitalNameEndsWith("병원");// 의원, 병원, 이비인후과, 치과
        printHospitalNameAndAddress(hospitals);
    }

    @Test
    void between() {
        List<Hospital> hospitals = hospitalRepository.findByPatientRoomCountBetween(10,20);
        printHospitalNameAndAddress(hospitals);
    }

    @Test
    void betweenOrderBy() {
        List<Hospital> hospitals = hospitalRepository.findByPatientRoomCountBetweenOrderByPatientRoomCountDesc(10,20);
        printHospitalNameAndAddress(hospitals);
    }
}