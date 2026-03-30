package com.karthick.pds_jan.repository;

import com.karthick.pds_jan.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category save(Category category);

    Optional<Category> getCategoryByName(String catName);

    List<Category> getCategoriesByNameContaining(String text);
}
