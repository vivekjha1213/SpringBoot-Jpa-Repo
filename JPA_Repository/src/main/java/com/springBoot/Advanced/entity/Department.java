package com.springBoot.Advanced.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Department {


    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long departmentId;

    private String departmentName;
    private  String departmentAddress;
    private String departmentCode;
}
