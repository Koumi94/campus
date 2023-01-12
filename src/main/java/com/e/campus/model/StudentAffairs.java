
package com.e.campus.model;
import lombok.AllArgsConstructor;
import lombok.Data;


import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Data
@AllArgsConstructor
public class StudentAffairs {

    private @Id
    @GeneratedValue long id;

    private String name;

    private LocalDateTime createAt;

    public StudentAffairs(String name) {
        this.name = name;
        this.createAt = LocalDateTime.now();
    }

    public StudentAffairs() {

    }
}
