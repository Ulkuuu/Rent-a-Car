package springengin.rantACar.entites.concretes;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@EqualsAndHashCode

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity


@Table(name="cars")
public class Car {
 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="plate")
    private String plate;
    @Column(name="dailyprice")
    private double dailyprice;
     @Column(name="modelyear")
    private int modelyear;
     @Column(name="state")
    private String state;

    @ManyToOne
    @JoinColumn(name="model_id")
    private Model model;

}
