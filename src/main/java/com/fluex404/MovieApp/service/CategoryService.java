package com.fluex404.MovieApp.service;

import com.fluex404.MovieApp.dto.BaseListDto;
import com.fluex404.MovieApp.dto.CategoryDto;
import com.fluex404.MovieApp.entity.Category;
import com.fluex404.MovieApp.entity.Movie;
import com.fluex404.MovieApp.exception.CustomException;
import com.fluex404.MovieApp.repository.CategoryRepository;
import com.fluex404.MovieApp.response.BaseListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category saveOrUpdate(CategoryDto data) throws CustomException {
        Optional<Category> optional = categoryRepository.findById(data.getId());

        Category category = new Category();
        if(optional.isPresent()) {
            category = optional.get();
        }

        category.setName(data.getName());

        return categoryRepository.save(category);
    }

    public void delete(Long categoryId) throws CustomException {
        categoryRepository.deleteById(categoryId);
    }

    public BaseListResponse<List<Category>> search(BaseListDto<String> data) throws CustomException {

        Pageable pageable = PageRequest.of(data.getPageAt() - 1 , data.getPageSize(), Sort.by(data.getSortBy()).ascending());

        if(data.getSortDirection().equals("DESC")) {
            pageable = PageRequest.of(data.getPageAt() - 1 , data.getPageSize(), Sort.by(data.getSortBy()).descending());
        }

        Page<Category> page = categoryRepository.findByNameIsLike(data.getData(), pageable);

        BaseListResponse<List<Category>> b = new BaseListResponse();

        b.setData(page.getContent());
        b.setLastPage(page.isLast());
        b.setNextPage(page.isFirst());
        b.setTotalPages(page.getTotalPages());
        b.setNumberOfElements(page.getNumberOfElements());
        b.setTotalElements(page.getTotalElements());

        return b;
    }
}
