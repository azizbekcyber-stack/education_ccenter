package uz.educenter.bot.service;

import uz.educenter.bot.model.User;
import uz.educenter.bot.repository.UserRepository;

import java.util.Objects;

public class UserService {

    private final UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }

    public User getOrCreateUser(Long telegramId, String fullName, String username) {
        User user = userRepository.findByTelegramId(telegramId);

        if (user != null) {
            boolean fullNameChanged = !Objects.equals(user.getFullName(), fullName);
            boolean usernameChanged = !Objects.equals(user.getUsername(), username);

            if (fullNameChanged || usernameChanged) {
                userRepository.updateTelegramProfile(user.getId(), fullName, username);
                User updatedUser = userRepository.findById(user.getId());
                return updatedUser != null ? updatedUser : user;
            }

            return user;
        }

        User newUser = new User();
        newUser.setTelegramId(telegramId);
        newUser.setFullName(fullName);
        newUser.setUsername(username);
        newUser.setPhone(null);

        return userRepository.save(newUser);
    }

    public User findByTelegramId(Long telegramId) {
        return userRepository.findByTelegramId(telegramId);
    }
    public User findById(Long id) {
        return userRepository.findById(id);
    }

    public boolean updatePhone(Long userId, String phone) {
        return userRepository.updatePhone(userId, phone);
    }
}