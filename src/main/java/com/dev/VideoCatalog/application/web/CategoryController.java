package com.dev.VideoCatalog.application.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.VideoCatalog.application.service.ICategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

  @Autowired
  private ICategoryService categoryService;

  // public CategoryController(ICategoryService categoryService) {
  // this.categoryService = categoryService;
  // }

  @GetMapping
  public ResponseEntity findAll() {
    try {
      return ResponseEntity.ok().body(
          this.categoryService.findAll());
    } catch (Exception e) {
      // TODO: handle exception
    }
    return null;
  }
}
