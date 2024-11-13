package com.BookShopFlexisaf.Project.repository;

import com.BookShopFlexisaf.Project.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}