package springengin.rantACar.entites.concretes;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Table(name="models")
@ToString
@Setter
@EqualsAndHashCode
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;
    @ManyToOne
    @JoinColumn(name="brand=id")
    private Brand brand;

     @OneToMany(mappedBy = "model")
    private List<Car> cars;

}
