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
}