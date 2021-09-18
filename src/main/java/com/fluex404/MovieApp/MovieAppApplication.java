package com.fluex404.MovieApp;

import com.fluex404.MovieApp.entity.Category;
import com.fluex404.MovieApp.entity.Movie;
import com.fluex404.MovieApp.entity.MovieCategory;
import com.fluex404.MovieApp.repository.CategoryRepository;
import com.fluex404.MovieApp.repository.MovieCategoryRepository;
import com.fluex404.MovieApp.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MovieAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieAppApplication.class, args);
	}

}
