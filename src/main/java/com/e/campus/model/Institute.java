package com.e.campus.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
public class Institute {

    private @Id
    @GeneratedValue long id ;
    private String name;
    private LocalDateTime createAt;



    public Institute(String name) {

        this.name = name;
        this.createAt = LocalDateTime.now();


    }

    public Institute(){

    }
}
