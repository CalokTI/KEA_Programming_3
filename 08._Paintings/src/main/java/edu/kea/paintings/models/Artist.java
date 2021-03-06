package edu.kea.paintings.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
    private String image;

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

    @JsonIgnore
    @ManyToMany(mappedBy = "artists", fetch = FetchType.LAZY)
    private List<Painting> paintings;

}
