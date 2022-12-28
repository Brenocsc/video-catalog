package com.dev.VideoCatalog.domain.entity;

import java.util.UUID;

public class Category extends BaseEntity {

  private String name;

  public Category() {
  }

  public Category(String name) {
    super.generateUUID();
    setName(name);
  }

  public Category(UUID id) {
    super.setId(id);
  }

  public Category(UUID id, String name) {
    super.setId(id);
    setName(name);
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    if (name == null)
      throw new IllegalArgumentException("");
    if (name.length() == 0)
      throw new IllegalArgumentException("");
    this.name = name;
  }
}
