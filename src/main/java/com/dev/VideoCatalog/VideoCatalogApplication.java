package com.dev.VideoCatalog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dev.VideoCatalog.domain.entity.Category;
import com.dev.VideoCatalog.domain.entity.Genre;

@SpringBootApplication
public class VideoCatalogApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(VideoCatalogApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Genre genre = new Genre("Genre 1");
		Category category1 = new Category("Category 1");
		genre.addCategories(category1);
		System.out.println("Genre name: " + genre.getName() + genre.getId() + genre.getCategories());
	}

}
