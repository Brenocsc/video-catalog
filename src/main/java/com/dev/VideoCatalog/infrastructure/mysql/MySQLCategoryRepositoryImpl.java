package com.dev.VideoCatalog.infrastructure.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dev.VideoCatalog.domain.entity.Category;
import com.dev.VideoCatalog.domain.repository.ICategoryRepository;

@Repository
public class MySQLCategoryRepositoryImpl implements ICategoryRepository {

  @Autowired
  private SpringDataCategoryRepository springDataCategoryRepository;

  // public MySQLCategoryRepositoryImpl(SpringDataCategoryRepository
  // springDataCategoryRepository) {
  // this.springDataCategoryRepository = springDataCategoryRepository;
  // }

  @Override
  public Iterable<Category> findAllCategories() {
    return this.springDataCategoryRepository.findAll();
  }

  @Override
  public Category create(Category toAdd) {
    return this.springDataCategoryRepository.save(toAdd);
  }

}
