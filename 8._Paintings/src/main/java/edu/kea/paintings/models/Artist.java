package edu.kea.paintings.models;

import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;

@Table(name="artists")  //sets table name for DB
@Entity                 //necessary for hibernate, marks the class as a model
@Data                   //adds getters, setters and no args constructor
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private int age;

    @Column
    private String primaryStyle;

    @Column(length=50) //sets size in database
    private String nationality;

    @Column
    private Date birthDate;

    @Enumerated(value = EnumType.STRING)
    @Column(length=50)
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "gallery_id")
    @Nullable
    private Gallery gallery;

}
