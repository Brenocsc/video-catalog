package com.dev.VideoCatalog.domain.entity;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

public class Video extends BaseEntity {
  private String title;
  private String description;
  private Integer yearLaunched;
  private Boolean opened;
  private String rating;
  private Float duration;
  private List<Category> categories = new ArrayList<Category>();
  private List<Genre> genres = new ArrayList<Genre>();
  private List<CastMember> castMembers = new ArrayList<CastMember>();
  private List<VideoFile> videoFiles = new ArrayList<VideoFile>();

  // public Video() {
  // }

  public Video(UUID id, String title, String description, Integer yearLaunched, Boolean opened) {
    this.setId(id);
    this.setTitle(title);
    this.setDescription(description);
    this.setYearLaunched(yearLaunched);
    this.setOpened(opened);
  }

  public Video(String title, String description, Integer yearLaunched, Boolean opened) {
    this.generateUUID();
    this.setTitle(title);
    this.setDescription(description);
    this.setYearLaunched(yearLaunched);
    this.setOpened(opened);
  }

  public Video(String title, String description, Integer yearLaunched, Boolean opened, String rating, Float duration) {
    this.generateUUID();
    this.setTitle(title);
    this.setDescription(description);
    this.setYearLaunched(yearLaunched);
    this.setOpened(opened);
    this.setRating(rating);
    this.setDuration(duration);
  }

  public Video(String title, String description, Integer yearLaunched, Float duration) {
    this.generateUUID();
    this.setTitle(title);
    this.setDescription(description);
    this.setYearLaunched(yearLaunched);
    this.setDuration(duration);
  }

  public Video(String title, String description, Integer yearLaunched, Float duration, List<VideoFile> files) {
    this.generateUUID();
    this.setTitle(title);
    this.setDescription(description);
    this.setYearLaunched(yearLaunched);
    this.setDuration(duration);
    this.setVideoFiles(files);
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    if (title == null)
      throw new IllegalArgumentException("title is marked non-null but is null");
    if (title.length() == 0)
      throw new IllegalArgumentException("title is marked non-blank but is blank");
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getYearLaunched() {
    return yearLaunched;
  }

  public void setYearLaunched(Integer yearLaunched) {
    int currentYear = Calendar.getInstance().get(Calendar.YEAR);
    if (yearLaunched > currentYear)
      throw new IllegalArgumentException("yearLaunched is greater than current year");
    this.yearLaunched = yearLaunched;
  }

  public Boolean getOpened() {
    return opened;
  }

  public void setOpened(Boolean opened) {
    this.opened = opened;
  }

  public String getRating() {
    return rating;
  }

  public void setRating(String rating) {
    this.rating = rating;
  }

  public Float getDuration() {
    return duration;
  }

  public void setDuration(Float duration) {
    DecimalFormat decimalFormat = new DecimalFormat("#.##");
    this.duration = Float.valueOf(decimalFormat.format(duration));
  }

  public List<Category> getCategories() {
    return this.categories;
  }

  public void setCategories(List<Category> categories) {
    if (categories == null)
      throw new IllegalArgumentException("categories is marked non-null but is null");
    this.categories = categories;
  }

  public List<Genre> getGenres() {
    return this.genres;
  }

  public void setGenres(List<Genre> genres) {
    if (genres == null)
      throw new IllegalArgumentException("genres is marked non-null but is null");
    this.genres = genres;
  }

  public List<CastMember> getCastMembers() {
    return this.castMembers;
  }

  public void setCastMembers(List<CastMember> castMembers) {
    if (castMembers == null)
      throw new IllegalArgumentException("castMembers is marked non-null but is null");
    this.castMembers = castMembers;
  }

  public List<VideoFile> getVideoFiles() {
    return this.videoFiles;
  }

  public void setVideoFiles(List<VideoFile> files) {
    if (files == null)
      throw new IllegalArgumentException("files is marked non-null but is null");
    this.videoFiles = files;
  }

  public void addCategory(Category category) {
    if (category == null)
      throw new IllegalArgumentException("category is marked non-null but is null");
    this.categories.add(category);
  }

  public void removeCategory(Category category) {
    if (category == null)
      throw new IllegalArgumentException("category is marked non-null but is null");
    this.categories.removeIf(c -> c.equals(category));
  }

  public void addGenre(Genre genre) {
    if (genre == null)
      throw new IllegalArgumentException("genre is marked non-null but is null");
    this.genres.add(genre);
  }

  public void removeGenre(Genre genre) {
    if (genre == null)
      throw new IllegalArgumentException("genre is marked non-null but is null");
    this.genres.removeIf(c -> c.equals(genre));
  }

  public void addCastMember(CastMember member) {
    if (member == null)
      throw new IllegalArgumentException("member is marked non-null but is null");
    this.castMembers.add(member);
  }

  public void removeCastMember(CastMember member) {
    if (member == null)
      throw new IllegalArgumentException("member is marked non-null but is null");
    this.castMembers.removeIf(c -> c.equals(member));
  }

  public Video createVideoWithFiles(String title, String description, Integer yearLaunched, Float duration,
      List<Category> categories, List<Genre> genres, List<CastMember> castMembers, List<VideoFile> files) {
    this.setTitle(title);
    this.setDescription(description);
    this.setYearLaunched(yearLaunched);
    this.setDuration(duration);
    this.setCategories(categories);
    this.setGenres(genres);
    this.setCastMembers(castMembers);
    this.setVideoFiles(files);
    return this;
  }

  public Video createVideoWithoutFile(String title, String description, Integer yearLaunched, Float duration,
      List<Category> categories, List<Genre> genres, List<CastMember> castMembers) {
    this.setTitle(title);
    this.setDescription(description);
    this.setYearLaunched(yearLaunched);
    this.setDuration(duration);
    this.setCategories(categories);
    this.setGenres(genres);
    this.setCastMembers(castMembers);
    return this;
  }
}
