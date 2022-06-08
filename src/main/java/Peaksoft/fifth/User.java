package Peaksoft.fifth;

import Peaksoft.Model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="users")
    @Getter
    @Setter
    @NoArgsConstructor

    public class User extends Model {
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private Long id;
        private String name;
        private int age;



    @Override
    public String toString() {
        return "\n_________User___________\n"+
                "| id________"+id+"\n"+
                "| name______"+name+"\n"+
                "| age_______"+age+"\n"+
                "|_____________________________\n";
    }
}
