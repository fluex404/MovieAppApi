package com.fluex404.MovieApp.repository;

import com.fluex404.MovieApp.entity.Category;
import com.fluex404.MovieApp.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
