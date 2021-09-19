package com.fluex404.MovieApp.response;

import com.fluex404.MovieApp.dto.MovieDto;
import com.fluex404.MovieApp.entity.Movie;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MovieDetailResponse {
    private Movie movie;
    private List<Movie> recomends;
}
