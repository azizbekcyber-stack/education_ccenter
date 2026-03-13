package uz.educenter.bot.model;

import java.time.LocalDateTime;

public class User {

    private Long id;
    private Long telegramId;
    private String fullName;
    private String username;
    private String phone;
    private LocalDateTime createdAt;

    public User() {
    }

    public User(Long id, Long telegramId, String fullName, String username, String phone, LocalDateTime createdAt) {
        this.id = id;
        this.telegramId = telegramId;
        this.fullName = fullName;
        this.username = username;
        this.phone = phone;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTelegramId() {
        return telegramId;
    }

    public void setTelegramId(Long telegramId) {
        this.telegramId = telegramId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", telegramId=" + telegramId +
                ", fullName='" + fullName + '\'' +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}