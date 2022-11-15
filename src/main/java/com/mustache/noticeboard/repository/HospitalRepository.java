package com.mustache.noticeboard.repository;


import com.mustache.noticeboard.domain.entity.Hospital;
import com.mustache.noticeboard.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

    List<Hospital> findByBusinessTypeNameIn(List<String> inClues);
    List<Hospital> findByRoadNameAddressContaining(String keyword);
    List<Hospital> findByHospitalNameStartsWith(String keyword);
    List<Hospital> findByHospitalNameEndsWith(String keyword);

    List<Hospital> findByPatientRoomCountBetween(int startRoomCount, int endRoomCount);

    List<Hospital> findByPatientRoomCountBetweenOrderByPatientRoomCountDesc(int a, int b);

}