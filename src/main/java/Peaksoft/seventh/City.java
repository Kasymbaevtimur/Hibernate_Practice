package Peaksoft.seventh;

import Peaksoft.Model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name="cites")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class City extends Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int population;
    private String square;



    @Override
    public String toString() {
        return  "\n______Actor_______________\n"+
                "| id_______ :"+id+"\n"+
                "| name_____ :"+name+"\n"+
                "| population______ :"+population+"\n"+
                "| square____:"+square+"\n"+
                "|____________________________\n";
    }

}
