package uz.educenter.bot.repository;

import uz.educenter.bot.config.DatabaseConfig;
import uz.educenter.bot.model.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminRepository {

    public Admin findActiveByTelegramId(Long telegramId) {
        String sql = """
                SELECT id, telegram_id, full_name, password_hash, is_active, created_at
                FROM admins
                WHERE telegram_id = ? AND is_active = true
                """;

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, telegramId);

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

    private Admin mapRow(ResultSet resultSet) throws Exception {
        Admin admin = new Admin();
        admin.setId(resultSet.getLong("id"));
        admin.setTelegramId(resultSet.getLong("telegram_id"));
        admin.setFullName(resultSet.getString("full_name"));
        admin.setPasswordHash(resultSet.getString("password_hash"));
        admin.setIsActive(resultSet.getBoolean("is_active"));
        admin.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
        return admin;
    }
}