package com.fluex404.MovieApp.api;

import com.fluex404.MovieApp.exception.CustomException;
import com.fluex404.MovieApp.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieApi {

    @Autowired
    private MovieService movieService;

    @PostMapping("/saveOrUpdate")
    public ResponseEntity saveOrUpdate(
            @RequestParam("id")Long id,
            @RequestParam("image")MultipartFile image,
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("rate") Double rate
            ) throws CustomException {
        return ResponseEntity.ok(movieService.saveOrUpdate(id, image, title, description, rate));
    }
}
