package com.test01.test01;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="countries")
@Getter @Setter @NoArgsConstructor
public class Countrie {
    
    @Id
    private Integer id;

    @Column(name = "name")
    private String name;
}
