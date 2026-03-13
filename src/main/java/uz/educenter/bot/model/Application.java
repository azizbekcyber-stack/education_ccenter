package uz.educenter.bot.model;

import java.time.LocalDateTime;

public class Application {

    private Long id;
    private Long userId;
    private Long courseId;
    private Long courseGroupId;
    private String fullName;
    private String phone;
    private String message;
    private ApplicationStatus status;
    private LocalDateTime createdAt;

    public Application() {
    }

    public Application(Long id, Long userId, Long courseId, Long courseGroupId, String fullName,
                       String phone, String message, ApplicationStatus status, LocalDateTime createdAt) {
        this.id = id;
        this.userId = userId;
        this.courseId = courseId;
        this.courseGroupId = courseGroupId;
        this.fullName = fullName;
        this.phone = phone;
        this.message = message;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getCourseGroupId() {
        return courseGroupId;
    }

    public void setCourseGroupId(Long courseGroupId) {
        this.courseGroupId = courseGroupId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", userId=" + userId +
                ", courseId=" + courseId +
                ", courseGroupId=" + courseGroupId +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                ", createdAt=" + createdAt +
                '}';
    }
}