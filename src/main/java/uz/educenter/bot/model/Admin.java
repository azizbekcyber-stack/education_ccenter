package uz.educenter.bot.model;

import java.time.LocalDateTime;

public class Admin {

    private Long id;
    private Long telegramId;
    private String fullName;
    private String passwordHash;
    private Boolean isActive;
    private LocalDateTime createdAt;

    public Admin() {
    }

    public Admin(Long id, Long telegramId, String fullName, String passwordHash, Boolean isActive, LocalDateTime createdAt) {
        this.id = id;
        this.telegramId = telegramId;
        this.fullName = fullName;
        this.passwordHash = passwordHash;
        this.isActive = isActive;
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

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
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
        return "Admin{" +
                "id=" + id +
                ", telegramId=" + telegramId +
                ", fullName='" + fullName + '\'' +
                ", isActive=" + isActive +
                ", createdAt=" + createdAt +
                '}';
    }
}