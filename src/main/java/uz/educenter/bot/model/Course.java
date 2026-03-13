package uz.educenter.bot.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Course {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String courseDuration;
    private Boolean isActive;
    private LocalDateTime createdAt;

    public Course() {
    }

    public Course(Long id, String name, String description, BigDecimal price, String courseDuration, Boolean isActive, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.courseDuration = courseDuration;
        this.isActive = isActive;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", courseDuration='" + courseDuration + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}