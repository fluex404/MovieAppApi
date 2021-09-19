package com.fluex404.MovieApp.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseListResponse<T> {
    private T data;
    private Integer totalPages;
    private Long totalElements;
    private Integer numberOfElements;
    private boolean nextPage;
    private boolean lastPage;
}
