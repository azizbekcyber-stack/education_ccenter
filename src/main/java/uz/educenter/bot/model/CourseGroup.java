package uz.educenter.bot.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class CourseGroup {

    private Long id;
    private Long courseId;
    private String groupName;
    private String daysText;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean isActive;
    private LocalDateTime createdAt;

    public CourseGroup() {
    }

    public CourseGroup(Long id, Long courseId, String groupName, String daysText, LocalTime startTime, LocalTime endTime,
                       LocalDate startDate, LocalDate endDate, Boolean isActive, LocalDateTime createdAt) {
        this.id = id;
        this.courseId = courseId;
        this.groupName = groupName;
        this.daysText = daysText;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isActive = isActive;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDaysText() {
        return daysText;
    }

    public void setDaysText(String daysText) {
        this.daysText = daysText;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
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
        return "CourseGroup{" +
                "id=" + id +
                ", courseId=" + courseId +
                ", groupName='" + groupName + '\'' +
                ", daysText='" + daysText + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", isActive=" + isActive +
                '}';
    }
}