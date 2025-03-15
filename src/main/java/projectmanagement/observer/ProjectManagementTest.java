package projectmanagement.observer;

public class ProjectManagementTest {
    public static void main(String[] args) {
        // Create subjects (Tasks)
        Task frontendTask = new Task("FE-01", "Implement User Dashboard");
        Task backendTask = new Task("BE-01", "Create REST API");

        // Create observers (Team Members)
        TeamMember developer1 = new TeamMember("Alice", "Frontend Developer");
        TeamMember developer2 = new TeamMember("Bob", "Backend Developer");
        TeamMember designer = new TeamMember("Carol", "UI/UX Designer");
        TeamMember projectManager = new TeamMember("Dave", "Project Manager");

        // Register observers to tasks
        frontendTask.register(developer1);
        frontendTask.register(designer);
        frontendTask.register(projectManager);

        backendTask.register(developer2);
        backendTask.register(projectManager);

        // Attach observers to subjects
        developer1.setSubject(frontendTask);
        designer.setSubject(frontendTask);
        developer2.setSubject(backendTask);
        projectManager.setSubject(frontendTask);  // Project manager observes both tasks
        projectManager.setSubject(backendTask);

        // Update task statuses
        frontendTask.updateStatus("In Progress");
        backendTask.updateStatus("In Progress");

        System.out.println("\n--- After some time ---\n");

        frontendTask.updateStatus("Ready for Review");
        backendTask.updateStatus("Testing");

        System.out.println("\n--- Final stages ---\n");

        frontendTask.updateStatus("Completed");
        backendTask.updateStatus("Completed");
    }
}
