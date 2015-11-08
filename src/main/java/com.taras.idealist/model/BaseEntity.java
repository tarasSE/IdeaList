package com.taras.idealist.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private long id;
}
