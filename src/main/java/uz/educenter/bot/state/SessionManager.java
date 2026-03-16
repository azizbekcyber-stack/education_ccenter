package uz.educenter.bot.state;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SessionManager {

    private final Map<Long, UserState> userStates = new ConcurrentHashMap<>();
    private final Map<Long, PendingApplication> pendingApplications = new ConcurrentHashMap<>();
    private final Map<Long, Boolean> adminSessions = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Long, PendingCourseGroup> pendingCourseGroups = new ConcurrentHashMap<>();

    public UserState getUserState(Long telegramId) {
        return userStates.getOrDefault(telegramId, UserState.NONE);
    }

    public void setUserState(Long telegramId, UserState state) {
        userStates.put(telegramId, state);
    }

    public void clearUserState(Long telegramId) {
        userStates.remove(telegramId);
    }

    public PendingApplication getPendingApplication(Long telegramId) {
        return pendingApplications.get(telegramId);
    }

    public void createPendingApplication(Long telegramId) {
        pendingApplications.put(telegramId, new PendingApplication());
    }

    public void clearPendingApplication(Long telegramId) {
        pendingApplications.remove(telegramId);
    }

    public boolean isAdminAuthenticated(Long telegramId) {
        return adminSessions.getOrDefault(telegramId, false);
    }

    public void authenticateAdmin(Long telegramId) {
        adminSessions.put(telegramId, true);
    }
    public void createPendingCourseGroup(Long telegramId) {
        pendingCourseGroups.put(telegramId, new PendingCourseGroup());
    }

    public PendingCourseGroup getPendingCourseGroup(Long telegramId) {
        return pendingCourseGroups.get(telegramId);
    }

    public void clearPendingCourseGroup(Long telegramId) {
        pendingCourseGroups.remove(telegramId);
    }

    public void logoutAdmin(Long telegramId) {
        adminSessions.remove(telegramId);
    }
}