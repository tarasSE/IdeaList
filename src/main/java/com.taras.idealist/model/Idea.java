package com.taras.idealist.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Idea extends BaseEntity {

    private Integer priority;

    private String description;

    @ManyToOne
    private Category category;

}
