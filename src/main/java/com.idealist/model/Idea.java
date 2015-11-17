package com.idealist.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import javax.validation.constraints.Min;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "ideas")
@EnableAutoConfiguration
public class Idea extends BaseEntity {

    @Column(nullable = false)
    private Integer priority;

    @Min(value = 20)
    @Column(nullable = false, unique = true, length = 1000)
    private String description;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;

}
