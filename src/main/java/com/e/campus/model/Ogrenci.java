package com.e.campus.model;

import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Ogrenci {
    private @Id
    @GeneratedValue long id ;

    @Column(unique = true, nullable = false)
    private String name;
    private Integer identity;

    private String tel;

    private String email;
    private LocalDateTime createAt;


    @ManyToOne
    @JoinColumn(name = "ogrenci_id")
    private Ogrenci ogrenci;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ogrenci_course", joinColumns = @JoinColumn(name = "ogrenci_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }

    public Ogrenci(String name, Integer identity,String tel, String email) {
        this.name = name;
        this.identity = identity;
        this.tel = tel;
        this.email = email;
        this.createAt = LocalDateTime.now();
        this.courses = new ArrayList<>();
    }





    public Integer getOgrenciIdentity(Integer identity) {
        this.identity = identity;
        return identity;
    };


}
