package com.mustache.noticeboard.service;

import com.mustache.noticeboard.domain.dto.ArticleAddRequest;
import com.mustache.noticeboard.domain.dto.ArticleAddResponse;
import com.mustache.noticeboard.domain.dto.ArticleDto;
import com.mustache.noticeboard.domain.dto.HospitalResponse;
import com.mustache.noticeboard.domain.entity.Article;
import com.mustache.noticeboard.domain.entity.Hospital;
import com.mustache.noticeboard.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleService {

    public final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public ArticleDto getArticleById(Long id){
        Optional<Article> optArticle = articleRepository.findById(id);
        ArticleDto articleDto = Article.of(optArticle.get());
        return articleDto;

    }
    public ArticleAddResponse add(ArticleAddRequest dto){
        Article article =dto.toEntity();
        Article savedArticle = articleRepository.save(article);
        return new ArticleAddResponse(savedArticle.getId(), savedArticle.getTitle(), savedArticle.getContent());
    }

}