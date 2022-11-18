package com.mustache.noticeboard.service;
import com.mustache.noticeboard.domain.dto.HospitalRequest;
import com.mustache.noticeboard.domain.dto.HospitalResponse;
import com.mustache.noticeboard.domain.entity.Hospital;
import com.mustache.noticeboard.repository.HospitalRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class HospitalServiceTest {

    private HospitalRepository hospitalRepository = Mockito.mock(HospitalRepository.class);

    private HospitalService hospitalService;

    @BeforeEach
    void setUp() {
        hospitalService = new HospitalService(hospitalRepository);
    }

    @Test
    @DisplayName("13일때 영업중, 3일때 폐업")
    void businessStatusName3() {
        Hospital hospital1 = Hospital.builder()
                .id(718457)
                .businessStatusCode(3)
                .build();
        Hospital hospital2 = Hospital.builder()
                .id(4)
                .businessStatusCode(13)
                .build();
        // 폐업
        Mockito.when(hospitalRepository.findById(any()))
                .thenReturn(Optional.of(hospital1));
        HospitalResponse closedHospitalResponse = hospitalService.getHospital(71857);
        assertEquals("폐업", closedHospitalResponse.getBusinessStatusName());
        // 영업중
        Mockito.when(hospitalRepository.findById(any()))
                .thenReturn(Optional.of(hospital2));
        HospitalResponse hospitalResponse = hospitalService.getHospital(4);
        assertEquals("영업중", hospitalResponse.getBusinessStatusName());
    }
}
