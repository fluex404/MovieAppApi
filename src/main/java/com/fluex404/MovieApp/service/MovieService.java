package com.fluex404.MovieApp.service;

import com.fluex404.MovieApp.entity.Movie;
import com.fluex404.MovieApp.exception.CustomException;
import com.fluex404.MovieApp.repository.MovieRepository;
import com.fluex404.MovieApp.utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MyUtils myUtils;

    public Movie saveOrUpdate(Long id, MultipartFile file, String title, String description, Double rate) throws CustomException {
        Movie m = new Movie();
        Optional<Movie> optional = movieRepository.findById(id);
        if(optional.isPresent())
            m = optional.get();

        m.setTitle(title);
        m.setDescription(description);
        m.setRate(rate);

        m = movieRepository.save(m);

        m.setImageUrl(myUtils.upload(file, m.getId()));

        m = movieRepository.save(m);

        return m;
    }
}
