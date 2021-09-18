package com.fluex404.MovieApp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "movie")
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Double rate;
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate = new Date();
    @Column(name = "image_url")
    private String imageUrl;
    public Movie() {
    }

    public Movie(String title, Double rate, String description, String imageUrl) {
        this.title = title;
        this.rate = rate;
        this.description = description;
        this.imageUrl = imageUrl;
    }
}
