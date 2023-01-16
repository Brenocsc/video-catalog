package com.dev.VideoCatalog.application.service;

import java.util.Optional;
import java.util.UUID;

import com.dev.VideoCatalog.domain.entity.Category;

public interface ICategoryService {

  Iterable<Category> findAll();

  Optional<Category> findById(UUID id);
}
