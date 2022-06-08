package Peaksoft.sixth;

import Peaksoft.Model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="actors")
@Getter
@Setter
@NoArgsConstructor
public class Actor extends Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name="last_name")
    private String lastName;
    private int age;
    private String film;



    @Override
    public String toString() {
        return  "\n______Actor_______________\n"+
                "| id_______ :"+id+"\n"+
                "| name_____ :"+name+"\n"+
                "| lastName_ :"+lastName+"\n"+
                "| age______ :"+age+"\n"+
                "| film____:"+film+"\n"+
                "|____________________________\n";
    }

}

