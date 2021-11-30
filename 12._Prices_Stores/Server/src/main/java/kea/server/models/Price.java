package kea.server.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Table(name="prices")
@Entity
@Data
public class Price {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column
    private double price;

    @Column
    private double priceOfPrice;

    @Column
    private String size;

    @Column
    private String color;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
}
