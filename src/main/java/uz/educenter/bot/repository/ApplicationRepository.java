package uz.educenter.bot.repository;

import uz.educenter.bot.config.DatabaseConfig;
import uz.educenter.bot.model.Application;
import uz.educenter.bot.model.ApplicationStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ApplicationRepository {

    public Application save(Application application) {
        String sql = """
                INSERT INTO applications (user_id, course_id, course_group_id, full_name, phone, message, status)
                VALUES (?, ?, ?, ?, ?, ?, ?)
                """;

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setLong(1, application.getUserId());
            preparedStatement.setLong(2, application.getCourseId());
            preparedStatement.setLong(3, application.getCourseGroupId());
            preparedStatement.setString(4, application.getFullName());
            preparedStatement.setString(5, application.getPhone());
            preparedStatement.setString(6, application.getMessage());
            preparedStatement.setString(7, application.getStatus().name());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        application.setId(generatedKeys.getLong(1));
                    }
                }
                return findById(application.getId());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Application> findAll() {
        List<Application> applications = new ArrayList<>();

        String sql = """
                SELECT id, user_id, course_id, course_group_id, full_name, phone, message, status, created_at
                FROM applications
                ORDER BY created_at DESC
                """;

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                applications.add(mapRow(resultSet));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return applications;
    }

    public List<Application> findAllByStatus(ApplicationStatus status) {
        List<Application> applications = new ArrayList<>();

        String sql = """
                SELECT id, user_id, course_id, course_group_id, full_name, phone, message, status, created_at
                FROM applications
                WHERE status = ?
                ORDER BY created_at DESC
                """;

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, status.name());

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    applications.add(mapRow(resultSet));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return applications;
    }

    public boolean updateStatus(Long applicationId, ApplicationStatus status) {
        String sql = """
                UPDATE applications
                SET status = ?
                WHERE id = ?
                """;

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, status.name());
            preparedStatement.setLong(2, applicationId);

            return preparedStatement.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    private Application mapRow(ResultSet resultSet) throws Exception {
        Application application = new Application();
        application.setId(resultSet.getLong("id"));
        application.setUserId(resultSet.getLong("user_id"));
        application.setCourseId(resultSet.getLong("course_id"));
        application.setCourseGroupId(resultSet.getLong("course_group_id"));
        application.setFullName(resultSet.getString("full_name"));
        application.setPhone(resultSet.getString("phone"));
        application.setMessage(resultSet.getString("message"));
        application.setStatus(ApplicationStatus.valueOf(resultSet.getString("status")));
        application.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());

        return application;
    }

    public Application findById(Long applicationId) {
        String sql = """
            SELECT id, user_id, course_id, course_group_id, full_name, phone, message, status, created_at
            FROM applications
            WHERE id = ?
            """;

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, applicationId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapRow(resultSet);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}