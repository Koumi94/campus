package com.e.campus.model;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class YukseklisansOgrenci {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String name;
    private Integer identity;

    private String tel;

    private String email;
    private LocalDateTime createAt;


    public YukseklisansOgrenci(String name, Integer identity,String tel, String email) {
        this.identity = identity;
        this.tel = tel;
        this.name = name;
        this.email = email;
        this.createAt = LocalDateTime.now();


    }

    public YukseklisansOgrenci() {

    }
}
