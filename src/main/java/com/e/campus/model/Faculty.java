package com.e.campus.model;

import lombok.AllArgsConstructor;
import lombok.Data;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor

public  class Faculty {
    private @Id
    @GeneratedValue long id;
    private String name;
    private LocalDateTime createAt;




    public Faculty(String name) {
        this.name = name;
        this.createAt = LocalDateTime.now();

    }



    public Faculty() {

    }


}
