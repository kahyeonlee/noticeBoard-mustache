package com.mustache.noticeboard.domain.dto;

import com.mustache.noticeboard.domain.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public class ArticleAddResponse {
    private Long id;
    private String title;
    private String content;

}
