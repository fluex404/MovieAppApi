package com.fluex404.MovieApp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "movie_category")
@Getter
@Setter
public class MovieCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_movie")
    private Movie movie;
    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

    public MovieCategory(Movie movie, Category category) {
        this.movie = movie;
        this.category = category;
    }
}
