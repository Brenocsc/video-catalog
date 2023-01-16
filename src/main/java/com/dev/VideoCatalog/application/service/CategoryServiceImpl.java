package com.dev.VideoCatalog.application.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.VideoCatalog.domain.entity.Category;
import com.dev.VideoCatalog.domain.repository.ICategoryRepository;

@Service
public class CategoryServiceImpl implements ICategoryService {

  @Autowired
  private ICategoryRepository categoryRepository;

  // public CategoryServiceImpl(ICategoryRepository categoryRepository) {
  // this.categoryRepository = categoryRepository;
  // }

  @Override
  public Iterable<Category> findAll() {
    return this.categoryRepository.findAllCategories();
  }

  @Override
  public Optional<Category> findById(UUID id) {
    // TODO Auto-generated method stub
    return Optional.empty();
  }

}
