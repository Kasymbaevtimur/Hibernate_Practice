package Peaksoft.third;

import Peaksoft.Model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="phones")

@NoArgsConstructor
@Getter
@Setter
public class Phone extends Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String company;

    private int price;


    @Override
    public String toString() {
        return  "\n______Phone_______________\n"+
                "| id_______ :"+id+"\n"+
                "| name_____ :"+name+"\n"+
                "| lastName_ :"+company+"\n"+
                "| age______ :"+price+"\n"+
                "|____________________________\n";
    }


}
