package com.mustache.noticeboard.repository;

import com.mustache.noticeboard.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
