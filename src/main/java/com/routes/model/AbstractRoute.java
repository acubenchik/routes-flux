package com.routes.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
abstract class AbstractRoute {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private String name;

}