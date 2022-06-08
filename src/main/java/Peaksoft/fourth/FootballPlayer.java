package Peaksoft.fourth;

import Peaksoft.Model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name="footballer")
@NoArgsConstructor
@Getter
@Setter

public class  FootballPlayer extends Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name="last_name")
    private String lastName;
    private int age;
    private String team;


    @Override
    public String toString() {
        return  "\n______Footballer_______________\n"+
                "| id_______ :"+id+"\n"+
                "| name_____ :"+name+"\n"+
                "| lastName_ :"+lastName+"\n"+
                "| age______ :"+age+"\n"+
                "| team_____ :"+team+"\n"+
                "|____________________________\n";
    }

}
