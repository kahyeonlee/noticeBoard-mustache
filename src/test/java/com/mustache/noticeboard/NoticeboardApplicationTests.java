package com.mustache.noticeboard;

import com.mustache.noticeboard.domain.entity.Hospital;
import com.mustache.noticeboard.repository.HospitalRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class NoticeboardApplicationTests {
    @Autowired
    HospitalRepository hospitalRepository;

    @Test
    void findById() {
        Optional<Hospital> hospital = hospitalRepository.findById(1);
        Hospital hp = hospital.get();
        System.out.println(hp.getId());
        Assertions.assertEquals(1, hp.getId());
    }
}
