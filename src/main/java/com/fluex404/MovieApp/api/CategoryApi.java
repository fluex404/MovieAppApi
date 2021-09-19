package com.fluex404.MovieApp.api;

import com.fluex404.MovieApp.dto.BaseListDto;
import com.fluex404.MovieApp.dto.CategoryDto;
import com.fluex404.MovieApp.exception.CustomException;
import com.fluex404.MovieApp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryApi {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/saveOrUpdate")
    public ResponseEntity saveOrUpdate(@RequestBody CategoryDto data) throws CustomException {
        return ResponseEntity.ok(categoryService.saveOrUpdate(data));
    }

    @DeleteMapping("/delete/{categoryId}")
    public ResponseEntity delete(@PathVariable("categoryId") Long categoryId) throws CustomException {
        categoryService.delete(categoryId);
        return ResponseEntity.ok("success");
    }

    @PostMapping("/search")
    public ResponseEntity search(@RequestBody BaseListDto<String> data) throws CustomException {
        return ResponseEntity.ok(categoryService.search(data));
    }

}
