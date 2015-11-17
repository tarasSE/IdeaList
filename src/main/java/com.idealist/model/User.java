package com.idealist.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name =  "users")
@EnableAutoConfiguration
public class User extends BaseEntity {

//    @Min(value = 6)
    @Column(nullable = false, unique = true, length = 50)
    private String name;

//    @Min(value = 6)
    @Column(nullable = false, length = 50)
    private String password;

}
