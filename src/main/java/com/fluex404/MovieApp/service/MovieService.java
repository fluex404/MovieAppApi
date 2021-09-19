package com.fluex404.MovieApp.service;

import com.fluex404.MovieApp.dto.BaseListDto;
import com.fluex404.MovieApp.dto.MovieDto;
import com.fluex404.MovieApp.dto.MovieSearchDto;
import com.fluex404.MovieApp.entity.Category;
import com.fluex404.MovieApp.entity.Movie;
import com.fluex404.MovieApp.entity.MovieCategory;
import com.fluex404.MovieApp.exception.CustomException;
import com.fluex404.MovieApp.repository.MovieRepository;
import com.fluex404.MovieApp.response.BaseListResponse;
import com.fluex404.MovieApp.response.MovieDetailResponse;
import com.fluex404.MovieApp.utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.orm.jpa.EntityManagerFactoryAccessor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.Join;
import javax.transaction.Transactional;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MyUtils myUtils;
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Movie saveOrUpdate(MovieDto data) throws CustomException {
        Movie m = new Movie();
        Optional<Movie> optional = movieRepository.findById(data.getId());
        if(optional.isPresent())
            m = optional.get();

        m.setTitle(data.getTitle());
        m.setDescription(data.getDescription());
        m.setRate(data.getRate());

        m = movieRepository.save(m);

        byte[] imageBytes = Base64.getDecoder().decode(data.getImageBase64());


        m.setImageUrl(myUtils.upload(imageBytes, data.getImageName(), m.getId()));

        m = movieRepository.save(m);


        /** category **/
        for (Long categoryId : data.getCategories()) {

        }

        return m;
    }
    public void delete(Long movieId) throws CustomException{
        movieRepository.deleteById(movieId);
    }
    public BaseListResponse<List<Movie>> search(BaseListDto<MovieSearchDto> data) throws CustomException {
        Pageable pageable = PageRequest.of(data.getPageAt() - 1 , data.getPageSize(), Sort.by(data.getSortBy()).ascending());

        if(data.getSortDirection().equals("DESC")) {
            pageable = PageRequest.of(data.getPageAt() - 1 , data.getPageSize(), Sort.by(data.getSortBy()).descending());
        }

        Specification filterDescription =
                (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("description"), "%"+data.getData().getQuery()+"%");
        Specification filterTitle =
                (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), "%"+data.getData().getQuery()+"%");
        Specification filterCategory = null;

        if(data.getData().getCategoryId() != null && data.getData().getCategoryId() != 0) {
            filterCategory = (root, criteriaQuery, criteriaBuilder) -> {
                Join<MovieCategory, Movie> joinMovieCategory = root.join("movieCategories");
                Join<Category, MovieCategory> joinCategory = joinMovieCategory.join("category");
                return criteriaBuilder.equal(joinCategory.get("id"), data.getData().getCategoryId());
            };
        }

        Page page = movieRepository.findAll(
                Specification.where(filterDescription.or(filterTitle))
                        .and(filterCategory),
                pageable
        );

        BaseListResponse<List<Movie>> b = new BaseListResponse();

        b.setData(page.getContent());
        b.setLastPage(page.isLast());
        b.setNextPage(page.isFirst());
        b.setTotalPages(page.getTotalPages());
        b.setNumberOfElements(page.getNumberOfElements());
        b.setTotalElements(page.getTotalElements());

        return b;
    }
    public MovieDetailResponse detail(Long movieId) throws CustomException {
        Optional<Movie> optional = movieRepository.findById(movieId);

        if(!optional.isPresent()) {
            throw new CustomException("movieId: "+movieId+" not found!", HttpStatus.NOT_FOUND);
        }

        return new MovieDetailResponse();
    }
}
