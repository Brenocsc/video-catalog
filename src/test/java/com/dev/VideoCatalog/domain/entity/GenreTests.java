package com.dev.VideoCatalog.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class GenreTests {

  @Test
  public void throwIllegalArgumentExceptionWhenNameIsNull() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> new Genre(null));
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains("name is marked non-null but is null"));
  }

  @Test
  public void throwIllegalArgumentExceptionWhenNameIsBlank() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> new Genre(""));
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains("name is marked non-blank but is blank"));
  }

  @Test
  public void throwIllegalArgumentExceptionWhenNameIsNullAndCategoriesIsNull() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> new Genre((String) null, null));
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains("name is marked non-null but is null"));
  }

  @Test
  public void throwIllegalArgumentExceptionWhenNameIsBlankAndCategoriesIsNull() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> new Genre("", null));
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains("name is marked non-blank but is blank"));
  }

  @Test
  public void createGenreWithName() {
    final Genre entity = new Genre("Genre 1");

    assertNotNull(entity);
    assertEquals(entity.getName(), "Genre 1");
    assertTrue(entity.isValidUUID(entity.getId().toString()));
  }

  @Test
  public void createGenreWithNameAndCategory() {
    final Category category = new Category("Category 1");

    List<Category> categories = new ArrayList<Category>();
    categories.add(category);

    final Genre entity = new Genre("Genre 1", categories);

    assertNotNull(categories);
    assertNotNull(entity);
    assertEquals(entity.getName(), "Genre 1");
    assertTrue(entity.isValidUUID(entity.getId().toString()));
    assertEquals(category.getName(), "Category 1");
    assertTrue(category.isValidUUID(category.getId().toString()));
    assertEquals(1, entity.getCategories().size());
  }

  @Test
  public void addCategoryToGenre() {
    final Genre entity = new Genre("Genre 1");
    assertNotNull(entity);
    assertNotNull(entity.getCategories());

    final Category category1 = new Category("Category 1");
    final Category category2 = new Category("Category 2");
    entity.addCategories(category1);
    entity.addCategories(category2);
    assertEquals(2, entity.getCategories().size());
  }

  @Test
  public void removeCategoryToGenre() {
    final Genre entity = new Genre("Genre 1");
    assertNotNull(entity);
    assertNotNull(entity.getCategories());

    final Category category1 = new Category("Category 1");
    final Category category2 = new Category("Category 2");
    entity.addCategories(category1);
    entity.addCategories(category2);
    assertEquals(2, entity.getCategories().size());
    entity.removeCategories(category1);
    assertEquals(1, entity.getCategories().size());
    entity.removeCategories(category2);
    assertEquals(0, entity.getCategories().size());
    assertNotNull(entity.getCategories());
  }
}
