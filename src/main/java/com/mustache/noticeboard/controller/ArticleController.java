package com.mustache.noticeboard.controller;

import com.mustache.noticeboard.domain.dto.ArticleDto;
import com.mustache.noticeboard.domain.entity.Article;
import com.mustache.noticeboard.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping(value = "/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @GetMapping(value = "/{id}")
    public String selectSingle(@PathVariable long id, Model model) {
        Optional<Article> optArticle = articleRepository.findById(id);
        if (!optArticle.isEmpty()) {
            model.addAttribute("article", optArticle.get());
            return "articles/show";
        } else {
            return "articles/error"; //없는 주소값을 쓰면 에러페이지
        }
    }
    @PostMapping(value="/posts")
    public String add(ArticleDto articleDto) {
        log.info(articleDto.getTitle());
        Article savedArticle = articleRepository.save(articleDto.toEntity());
        log.info("generatedId:{}", savedArticle.getId());
        // souf %d %s
        return String.format("redirect:/articles/%d", savedArticle.getId());
    }
    @GetMapping(value="/list")
    public String list(Model model){
        List<Article> articles = articleRepository.findAll();
        model.addAttribute("articles", articles);
        return "articles/list"; // 뷰로 반환
    } // controller -> db -> model(객체) -> 뷰

    @GetMapping("")
    public String index(){
        return "redirect:/articles/list";
    }


    @GetMapping(value = "/{id}/edit")
    public String edit(@PathVariable long id, Model model) {
        Optional<Article> optionalArticle = articleRepository.findById(id);

        if (!optionalArticle.isEmpty()) {
            model.addAttribute("article", optionalArticle.get());
            return "articles/edit";
        } else {
            model.addAttribute("message",String.format("%d가 없습니다",id));
            return "articles/error"; //없는 주소값을 쓰면 에러페이지
        }
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id, Model model) {
        articleRepository.deleteById(id);
        model.addAttribute("message", String.format("id: %d가 지워졌습니다.",id));
        return "redirect:/articles";
    }
}
