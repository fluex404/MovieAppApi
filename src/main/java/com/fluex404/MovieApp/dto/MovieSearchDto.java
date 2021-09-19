package com.fluex404.MovieApp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieSearchDto {
    private Long categoryId;
    private String query;
}
