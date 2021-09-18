package com.fluex404.MovieApp.repository;

import com.fluex404.MovieApp.entity.MovieCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieCategoryRepository extends JpaRepository<MovieCategory, Long> {
}
