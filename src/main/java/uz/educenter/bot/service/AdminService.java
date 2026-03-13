package uz.educenter.bot.service;

import uz.educenter.bot.model.Admin;
import uz.educenter.bot.repository.AdminRepository;

public class AdminService {

    private final AdminRepository adminRepository;

    public AdminService() {
        this.adminRepository = new AdminRepository();
    }

    public Admin findActiveAdminByTelegramId(Long telegramId) {
        return adminRepository.findActiveByTelegramId(telegramId);
    }

    public boolean isAllowedAdmin(Long telegramId) {
        return findActiveAdminByTelegramId(telegramId) != null;
    }

    public boolean authenticate(Long telegramId, String password) {
        Admin admin = adminRepository.findActiveByTelegramId(telegramId);

        if (admin == null) {
            return false;
        }

        return admin.getPasswordHash().equals(password);
    }
}