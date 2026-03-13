package uz.educenter.bot.service;

import uz.educenter.bot.model.Application;
import uz.educenter.bot.model.ApplicationStatus;
import uz.educenter.bot.model.CourseGroup;
import uz.educenter.bot.repository.ApplicationRepository;
import uz.educenter.bot.repository.CourseGroupRepository;

import java.util.List;

public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final CourseGroupRepository courseGroupRepository;

    public ApplicationService() {
        this.applicationRepository = new ApplicationRepository();
        this.courseGroupRepository = new CourseGroupRepository();
    }

    public Application createApplication(Application application) {
        validateApplication(application);
        return applicationRepository.save(application);
    }

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    public List<Application> getApplicationsByStatus(ApplicationStatus status) {
        return applicationRepository.findAllByStatus(status);
    }

    public boolean markAsViewed(Long applicationId) {
        return applicationRepository.updateStatus(applicationId, ApplicationStatus.VIEWED);
    }

    private void validateApplication(Application application) {
        if (application == null) {
            throw new IllegalArgumentException("Application cannot be null");
        }

        if (application.getUserId() == null) {
            throw new IllegalArgumentException("User ID is required");
        }

        if (application.getCourseId() == null) {
            throw new IllegalArgumentException("Course ID is required");
        }

        if (application.getCourseGroupId() == null) {
            throw new IllegalArgumentException("Course group ID is required");
        }

        if (application.getFullName() == null || application.getFullName().isBlank()) {
            throw new IllegalArgumentException("Full name is required");
        }

        if (application.getPhone() == null || application.getPhone().isBlank()) {
            throw new IllegalArgumentException("Phone is required");
        }

        CourseGroup group = courseGroupRepository.findById(application.getCourseGroupId());

        if (group == null) {
            throw new IllegalArgumentException("Selected group not found");
        }

        if (!group.getCourseId().equals(application.getCourseId())) {
            throw new IllegalArgumentException("Selected group does not belong to selected course");
        }

        if (application.getStatus() == null) {
            application.setStatus(ApplicationStatus.NEW);
        }
    }
}