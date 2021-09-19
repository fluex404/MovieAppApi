package com.fluex404.MovieApp.repository;

import com.fluex404.MovieApp.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Page<Category> findByNameIsLike(String name, Pageable pageable);
}
