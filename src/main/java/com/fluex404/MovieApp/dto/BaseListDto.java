package com.fluex404.MovieApp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseListDto<T> {
    private T data;
    private Integer pageAt;
    private Integer pageSize;
    private String sortBy;
    private String sortDirection;
}
