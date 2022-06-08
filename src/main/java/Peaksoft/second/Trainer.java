package Peaksoft.second;

import Peaksoft.Model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="trainers")

@Getter
@Setter
@NoArgsConstructor

public class Trainer extends Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name="last_name")
    private String lastName;
    private int age;
    private String sport;
    private String team;


    @Override
    public String toString() {
        return  "\n______Trainer_______________\n"+
                "| id_______ :"+id+"\n"+
                "| name_____ :"+name+"\n"+
                "| lastName_ :"+lastName+"\n"+
                "| age______ :"+age+"\n"+
                "| sports____:"+sport+"\n"+
                "| team_____ :"+team+"\n"+
                "|____________________________\n";
    }

}
