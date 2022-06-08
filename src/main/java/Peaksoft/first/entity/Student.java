package Peaksoft.first.entity;

import Peaksoft.Model;

import javax.persistence.*;

@Entity
@Table(name="students")

public class Student extends Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    private int age;

    public Student() {
    }

    public Student(Long id, String name, String lastName, int age) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "\n_________Student___________\n"+
                "| id__"+id+"\n"+
                "| name______"+name+"\n"+
                "| lastName__"+lastName+"\n"+
                "| age_______"+age+"\n"+
                "|_____________________________\n";
    }


}
