package com.mustache.noticeboard.domain.dto;

import com.mustache.noticeboard.domain.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
public class ArticleDto {
    private String title;
    private String content;

    public Article toEntity(){
        return new Article(title,content);
    }
}
