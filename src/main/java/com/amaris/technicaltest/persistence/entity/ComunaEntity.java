package com.amaris.technicaltest.persistence.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ComunaEntity {

    private String name;
    private String code;
    private ContainedInEntity contained_in;
}

