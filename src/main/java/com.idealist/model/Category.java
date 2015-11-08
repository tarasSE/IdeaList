package com.idealist.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Category extends BaseEntity {

    @Column(nullable = false)
    private String name;

}
