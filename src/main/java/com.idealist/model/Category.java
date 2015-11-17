package com.idealist.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "categories")
@EnableAutoConfiguration
public class Category extends BaseEntity implements Serializable{

    @Column(nullable = false, unique = true,length = 30)
    private String name;

}
