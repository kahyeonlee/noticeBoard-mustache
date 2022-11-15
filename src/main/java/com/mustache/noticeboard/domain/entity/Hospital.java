package com.mustache.noticeboard.domain.entity;

import com.mustache.noticeboard.domain.dto.HospitalResponse;
import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nation_wide_hospitals")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Hospital {
    @Id
    private Integer id;

    @Column(name = "road_name_address")
    private String roadNameAddress;

    @Column(name = "hospital_name")
    private String hospitalName;
    private Integer patientRoomCount;
    private Integer totalNumberOfBeds;
    private String businessTypeName;
    private Integer businessStatusCode;
    private Float totalAreaSize;

    public static HospitalResponse of(Hospital hospital) {
        return new HospitalResponse();
    }

}