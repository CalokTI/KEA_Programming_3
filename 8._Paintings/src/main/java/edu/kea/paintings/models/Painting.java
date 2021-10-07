package edu.kea.paintings.models;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Table(name="paintings")
@Entity
@Data
public class Painting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @ApiModelProperty(notes = "Name of the artist")
    private String artist;

    @Column
    private String title;

    @Column
    private double price;

    @Column
    private String genre;

    @Column
    private int year;
}
