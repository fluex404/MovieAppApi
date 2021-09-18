package com.fluex404.MovieApp;

import com.fluex404.MovieApp.entity.Category;
import com.fluex404.MovieApp.entity.Movie;
import com.fluex404.MovieApp.entity.MovieCategory;
import com.fluex404.MovieApp.repository.CategoryRepository;
import com.fluex404.MovieApp.repository.MovieCategoryRepository;
import com.fluex404.MovieApp.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class InitData implements CommandLineRunner {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MovieCategoryRepository movieCategoryRepository;

    @Override
    public void run(String... args) throws Exception {

        Category comedyCategory = new Category("Comedy");
        Category actionCategory = new Category("Action");
        Category romanceCategory = new Category("Romance");
        Category animeCategory = new Category("Anime");
        Category horrorCategory = new Category("Horror");

        Movie aladinMovie = new Movie("Aladin Live Action", 8.9, "ini description", "https://cdn0-production-images-kly.akamaized.net/dcKUIZ_9KDP76l46JIzE5u2exd0=/640x640/smart/filters:quality(75):strip_icc():format(jpeg)/kly-media-production/medias/2813882/original/041137800_1558602130-aladdin.jpg");
        Movie xmanMovie = new Movie("X man", 9.0, "ini description", "https://www.wallpapertip.com/wmimgs/9-93843_x-man-wallpaper-4k.jpg");
        Movie test1Movie = new Movie("Test 1", 7.2, "ini description", "https://www.wallpaperkiss.com/wimg/b/124-1244700_big.jpg");
        Movie test2Movie = new Movie("Test 2", 8.2, "ini description", "https://www.wallpaperkiss.com/wimg/b/124-1244700_big.jpg");
        Movie test3Movie = new Movie("Test 3", 8.0, "ini description", "https://www.wallpaperkiss.com/wimg/b/124-1244700_big.jpg");

        List<MovieCategory> aladinCategories = Arrays.asList(
                new MovieCategory(aladinMovie, comedyCategory),
                new MovieCategory(aladinMovie, actionCategory),
                new MovieCategory(aladinMovie, romanceCategory)
        );
        List<MovieCategory> xmanCategories = Arrays.asList(
                new MovieCategory(xmanMovie, actionCategory)
        );
        List<MovieCategory> test1Categories = Arrays.asList(
                new MovieCategory(test1Movie, animeCategory),
                new MovieCategory(test1Movie, horrorCategory)
        );
        List<MovieCategory> test2Categories = Arrays.asList(
                new MovieCategory(test2Movie, actionCategory),
                new MovieCategory(test2Movie, horrorCategory)
        );
        List<MovieCategory> test3Categories = Arrays.asList(
                new MovieCategory(test1Movie, romanceCategory),
                new MovieCategory(test1Movie, horrorCategory)
        );

        categoryRepository.save(comedyCategory);
        categoryRepository.save(actionCategory);
        categoryRepository.save(romanceCategory);
        categoryRepository.save(animeCategory);
        categoryRepository.save(horrorCategory);

        movieRepository.save(aladinMovie);
        movieRepository.save(xmanMovie);
        movieRepository.save(test1Movie);
        movieRepository.save(test2Movie);
        movieRepository.save(test3Movie);

        movieCategoryRepository.saveAll(xmanCategories);
        movieCategoryRepository.saveAll(aladinCategories);
        movieCategoryRepository.saveAll(test1Categories);
        movieCategoryRepository.saveAll(test2Categories);
        movieCategoryRepository.saveAll(test3Categories);
    }
}
