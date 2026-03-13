package uz.educenter.bot.state;

public class PendingApplication {

    private Long courseId;
    private Long courseGroupId;
    private String fullName;
    private String phone;
    private String message;

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
}