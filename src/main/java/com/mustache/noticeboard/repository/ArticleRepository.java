package com.mustache.noticeboard.repository;

import com.mustache.noticeboard.domain.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {
}
