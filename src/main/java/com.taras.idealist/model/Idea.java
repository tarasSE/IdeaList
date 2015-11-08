package com.taras.idealist.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Idea extends BaseEntity {

    @Column(nullable = false)
    private Integer priority;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    private Category category;

}
