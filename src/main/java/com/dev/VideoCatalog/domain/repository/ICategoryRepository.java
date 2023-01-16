package com.dev.VideoCatalog.domain.repository;

import com.dev.VideoCatalog.domain.entity.Category;

public interface ICategoryRepository {

  Iterable<Category> findAllCategories();
}
