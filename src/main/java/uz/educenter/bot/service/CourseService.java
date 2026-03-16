package uz.educenter.bot.service;

import uz.educenter.bot.model.Course;
import uz.educenter.bot.model.CourseGroup;
import uz.educenter.bot.repository.CourseGroupRepository;
import uz.educenter.bot.repository.CourseRepository;

import java.util.List;

public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseGroupRepository courseGroupRepository;

    public CourseService() {
        this.courseRepository = new CourseRepository();
        this.courseGroupRepository = new CourseGroupRepository();
    }

    public List<Course> getAllActiveCourses() {
        return courseRepository.findAllActiveCourses();
    }

    public Course getCourseById(Long courseId) {
        return courseRepository.findById(courseId);
    }

    public List<CourseGroup> getActiveGroupsByCourseId(Long courseId) {
        return courseGroupRepository.findActiveGroupsByCourseId(courseId);
    }

    public CourseGroup getCourseGroupById(Long groupId) {
        return courseGroupRepository.findById(groupId);
    }
    public CourseGroup createCourseGroup(CourseGroup courseGroup) {
        if (courseGroup == null) {
            throw new IllegalArgumentException("Course group null bo‘lishi mumkin emas");
        }

        if (courseGroup.getCourseId() == null) {
            throw new IllegalArgumentException("Course tanlanmagan");
        }

        if (courseGroup.getGroupName() == null || courseGroup.getGroupName().isBlank()) {
            throw new IllegalArgumentException("Guruh nomi bo‘sh bo‘lishi mumkin emas");
        }

        if (courseGroup.getDaysText() == null || courseGroup.getDaysText().isBlank()) {
            throw new IllegalArgumentException("Dars kunlari bo‘sh bo‘lishi mumkin emas");
        }

        if (courseGroup.getStartTime() == null || courseGroup.getEndTime() == null) {
            throw new IllegalArgumentException("Vaqtlar kiritilishi kerak");
        }

        if (!courseGroup.getEndTime().isAfter(courseGroup.getStartTime())) {
            throw new IllegalArgumentException("Tugash vaqti boshlanish vaqtidan keyin bo‘lishi kerak");
        }

        if (courseGroup.getStartDate() == null || courseGroup.getEndDate() == null) {
            throw new IllegalArgumentException("Sanalar kiritilishi kerak");
        }

        if (courseGroup.getEndDate().isBefore(courseGroup.getStartDate())) {
            throw new IllegalArgumentException("Tugash sanasi boshlanish sanasidan oldin bo‘lishi mumkin emas");
        }

        courseGroup.setIsActive(true);
        return courseGroupRepository.save(courseGroup);
    }
}