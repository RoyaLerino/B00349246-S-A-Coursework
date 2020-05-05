package Step3;

public class Company {
    private String name;
    private ProjectBinaryTree projects = new ProjectBinaryTree();

    public Company(String name) {
        this.name = name;
    }

    public void addTeamMemberToProject(Project project, TeamMember teamMember){
        project.addTeamMember(teamMember);
    }

    public void removeTeamMemberFromProject(Project project, TeamMember teamMember){
        project.removeTeamMember(teamMember);
    }

    public void addProject(Project p){
        if(this.projects.add(p))
        System.out.println(p.getTitle() + " added successfully");
        else System.out.println("Project already exists with this name");
    }

    public void removeProject(Project p){
        this.projects.remove(p);
    }

    public void findAndDisplayByTitle(String s){
        Project p = findProjectByTitle(s);
        System.out.println(p!=null?("TITLE\t\t\t\t\tMEMBERS\n"+p.toString()):"Project " + s + " not found");
    }

    public Project findProjectByTitle(String s){
        return projects.find(new Project(s));
    }

    public void displayAllProjects(){
        String s = projects.toString();
        if(s != null)System.out.println("TITLE\t\t\t\t\tMEMBERS\n" + s);
        else System.out.println("No Projects");
    }

    public void displayMemberNumbersForAllProjects() {
        System.out.println("TITLE\t\t\tMEMBERS");
        projects.printTeamMemberSizes();
    }
}
