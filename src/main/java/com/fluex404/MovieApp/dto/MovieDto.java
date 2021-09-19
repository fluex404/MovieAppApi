package com.fluex404.MovieApp.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
public class MovieDto {
    private Long id;
    private String imageBase64;
    private String imageName;
    private String title;
    private String description;
    private Double rate;
    private List<Long> categories;
}
