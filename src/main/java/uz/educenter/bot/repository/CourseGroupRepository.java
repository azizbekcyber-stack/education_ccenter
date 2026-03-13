package uz.educenter.bot.repository;

import uz.educenter.bot.config.DatabaseConfig;
import uz.educenter.bot.model.CourseGroup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseGroupRepository {

    public List<CourseGroup> findActiveGroupsByCourseId(Long courseId) {
        List<CourseGroup> groups = new ArrayList<>();

        String sql = """
                SELECT id, course_id, group_name, days_text, start_time, end_time,
                       start_date, end_date, is_active, created_at
                FROM course_groups
                WHERE course_id = ? AND is_active = true
                ORDER BY id
                """;

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, courseId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    CourseGroup group = new CourseGroup();
                    group.setId(resultSet.getLong("id"));
                    group.setCourseId(resultSet.getLong("course_id"));
                    group.setGroupName(resultSet.getString("group_name"));
                    group.setDaysText(resultSet.getString("days_text"));
                    group.setStartTime(resultSet.getTime("start_time").toLocalTime());
                    group.setEndTime(resultSet.getTime("end_time").toLocalTime());
                    group.setStartDate(resultSet.getDate("start_date").toLocalDate());
                    group.setEndDate(resultSet.getDate("end_date").toLocalDate());
                    group.setIsActive(resultSet.getBoolean("is_active"));
                    group.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());

                    groups.add(group);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return groups;
    }

    public CourseGroup findById(Long groupId) {
        String sql = """
                SELECT id, course_id, group_name, days_text, start_time, end_time,
                       start_date, end_date, is_active, created_at
                FROM course_groups
                WHERE id = ?
                """;

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, groupId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    CourseGroup group = new CourseGroup();
                    group.setId(resultSet.getLong("id"));
                    group.setCourseId(resultSet.getLong("course_id"));
                    group.setGroupName(resultSet.getString("group_name"));
                    group.setDaysText(resultSet.getString("days_text"));
                    group.setStartTime(resultSet.getTime("start_time").toLocalTime());
                    group.setEndTime(resultSet.getTime("end_time").toLocalTime());
                    group.setStartDate(resultSet.getDate("start_date").toLocalDate());
                    group.setEndDate(resultSet.getDate("end_date").toLocalDate());
                    group.setIsActive(resultSet.getBoolean("is_active"));
                    group.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());

                    return group;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}