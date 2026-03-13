package uz.educenter.bot.repository;

import uz.educenter.bot.config.DatabaseConfig;
import uz.educenter.bot.model.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseRepository {

    public List<Course> findAllActiveCourses() {
        List<Course> courses = new ArrayList<>();

        String sql = """
                SELECT id, name, description, price, course_duration, is_active, created_at
                FROM courses
                WHERE is_active = true
                ORDER BY id
                """;

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Course course = new Course();
                course.setId(resultSet.getLong("id"));
                course.setName(resultSet.getString("name"));
                course.setDescription(resultSet.getString("description"));
                course.setPrice(resultSet.getBigDecimal("price"));
                course.setCourseDuration(resultSet.getString("course_duration"));
                course.setIsActive(resultSet.getBoolean("is_active"));
                course.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());

                courses.add(course);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return courses;
    }

    public Course findById(Long courseId) {
        String sql = """
                SELECT id, name, description, price, course_duration, is_active, created_at
                FROM courses
                WHERE id = ?
                """;

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, courseId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Course course = new Course();
                    course.setId(resultSet.getLong("id"));
                    course.setName(resultSet.getString("name"));
                    course.setDescription(resultSet.getString("description"));
                    course.setPrice(resultSet.getBigDecimal("price"));
                    course.setCourseDuration(resultSet.getString("course_duration"));
                    course.setIsActive(resultSet.getBoolean("is_active"));
                    course.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
                    return course;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}