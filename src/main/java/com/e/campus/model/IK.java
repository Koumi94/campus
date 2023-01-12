package com.e.campus.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
public class IK {
    private @Id
    @GeneratedValue long id ;
    private String name;
    private LocalDateTime createAt;


    public IK(String name){
        this.name = name;
        this.createAt =LocalDateTime.now();
    }

    public IK(){

    }
    public long getId() {
        return id;
    }
}
