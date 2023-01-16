package com.dev.VideoCatalog.infrastructure.mysql;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.dev.VideoCatalog.domain.entity.Category;

public interface SpringDataCategoryRepository extends PagingAndSortingRepository<Category, UUID> {

}
