package uz.educenter.bot;

import uz.educenter.bot.model.Application;
import uz.educenter.bot.model.ApplicationStatus;
import uz.educenter.bot.model.Course;
import uz.educenter.bot.model.CourseGroup;
import uz.educenter.bot.model.User;
import uz.educenter.bot.service.AdminService;
import uz.educenter.bot.service.ApplicationService;
import uz.educenter.bot.service.CourseService;
import uz.educenter.bot.service.UserService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CourseService courseService = new CourseService();
        UserService userService = new UserService();
        AdminService adminService = new AdminService();
        ApplicationService applicationService = new ApplicationService();

        System.out.println("=== COURSES ===");
        List<Course> courses = courseService.getAllActiveCourses();
        for (Course course : courses) {
            System.out.println(course);
        }

        System.out.println("\n=== GROUPS OF COURSE ID 1 ===");
        List<CourseGroup> groups = courseService.getActiveGroupsByCourseId(1L);
        for (CourseGroup group : groups) {
            System.out.println(group);
        }

        System.out.println("\n=== USER TEST ===");
        User user = userService.getOrCreateUser(999999999L, "Test User", "test_user");
        System.out.println(user);

        System.out.println("\n=== ADMIN TEST ===");
        System.out.println("Allowed admin: " + adminService.isAllowedAdmin(123456789L));
        System.out.println("Password check: " + adminService.authenticate(123456789L, "admin123"));

        System.out.println("\n=== APPLICATION SAVE TEST ===");
        Application application = new Application();
        application.setUserId(user.getId());
        application.setCourseId(1L);
        application.setCourseGroupId(1L);
        application.setFullName("Test User");
        application.setPhone("+998901112233");
        application.setMessage("Java backend kursiga yozilmoqchiman");
        application.setStatus(ApplicationStatus.NEW);

        Application savedApplication = applicationService.createApplication(application);
        System.out.println(savedApplication);

        System.out.println("\n=== NEW APPLICATIONS ===");
        List<Application> newApplications = applicationService.getApplicationsByStatus(ApplicationStatus.NEW);
        for (Application app : newApplications) {
            System.out.println(app);
        }

        if (savedApplication != null) {
            System.out.println("\n=== UPDATE STATUS TO VIEWED ===");
            boolean updated = applicationService.markAsViewed(savedApplication.getId());
            System.out.println("Updated: " + updated);
        }

        System.out.println("\n=== ALL APPLICATIONS ===");
        List<Application> allApplications = applicationService.getAllApplications();
        for (Application app : allApplications) {
            System.out.println(app);
        }
    }
}