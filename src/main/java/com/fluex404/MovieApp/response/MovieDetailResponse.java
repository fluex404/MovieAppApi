package com.fluex404.MovieApp.response;

import com.fluex404.MovieApp.dto.MovieDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MovieDetailResponse {
    private MovieDto movieDto;
    private List<MovieDto> recomends;
}
