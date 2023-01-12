package com.e.campus.model;

import lombok.Data;
import org.hibernate.mapping.List;
import org.mockito.stubbing.Answer;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Ogrenci {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String name;
    private Integer identity;

    private String tel;

    private String email;
    private LocalDateTime createAt;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "OgrenciIsleri_id")

    private Ogrenci ogrenci;


    public Ogrenci (String name, Integer identity,String tel, String email){
        this.name = name;
        this.identity = identity;
        this.tel = tel;
        this.email = email;
        this.createAt = LocalDateTime.now();
    }

    public  Ogrenci(){

    };

}
