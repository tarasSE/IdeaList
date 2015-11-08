package com.idealist.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Min;

@Data
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue
    @Min(value = 1)
    @Column(nullable = false, unique = true, updatable = false)
    private long id;
}
