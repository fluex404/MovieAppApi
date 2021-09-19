package com.fluex404.MovieApp.api;

import com.fluex404.MovieApp.dto.BaseListDto;
import com.fluex404.MovieApp.dto.MovieDto;
import com.fluex404.MovieApp.dto.MovieSearchDto;
import com.fluex404.MovieApp.exception.CustomException;
import com.fluex404.MovieApp.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieApi {

    @Autowired
    private MovieService movieService;

    @PostMapping("/saveOrUpdate")
    public ResponseEntity saveOrUpdate(
            @RequestBody MovieDto data
            ) throws CustomException {
        return ResponseEntity.ok(movieService.saveOrUpdate(data));
    }

    @PostMapping("/delete/{movieId}")
    public ResponseEntity delete(@PathVariable("movieId") Long movieId) throws CustomException {
        movieService.delete(movieId);
        return ResponseEntity.ok(movieId+" deleted!");
    }

    @PostMapping("/search")
    public ResponseEntity findAll(@RequestBody BaseListDto<MovieSearchDto> data) throws CustomException {
        return ResponseEntity.ok(movieService.search(data));
    }
}
