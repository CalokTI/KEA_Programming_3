package kea.server.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Table(name="stores")
@Entity
@Data
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String owner;

    @Column
    private String storeName;

    @Column
    @Enumerated(value = EnumType.STRING)
    private Type type;

    @Column
    @Enumerated(value = EnumType.STRING)
    private CountryOfOrigin madeIn;

    @OneToMany(mappedBy = "store", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Price> prices;
}
