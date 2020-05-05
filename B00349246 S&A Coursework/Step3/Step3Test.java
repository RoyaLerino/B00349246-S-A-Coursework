package Step3;

import java.util.Scanner;

public class Step3Test {
    private static Company company = new Company("Test Company");

    public static void main(String[] args) {
        while (true){
            switch (menu("Main Menu",
                    "Add Project",
                    "Add Team Member",
                    "Remove Team Member",
                    "Remove Project",
                    "Display Team Members For Project",
                    "Display Projects",
                    "Display Amount of Team Members in  Projects")){
                case 0:
                    exit();
                case 1:
                    company.addProject(new Project(getString("Please input project title")));
                    break;
                case 2:
                    company.addTeamMemberToProject(
                            company.findProjectByTitle(getString("Please input the title of project to add team member to")),
                            new TeamMember(getString("Enter Team Member Name"), 0)
                    );
                    break;
                case 3:
                    company.removeTeamMemberFromProject(
                            company.findProjectByTitle(getString("Please input the title of project to remove the team member from")),
                            new TeamMember(getString("Enter Team Member Name"),0)
                    );
                    break;
                case 4:
                    Project project = company.findProjectByTitle(getString("Please input the title of project to remove"));
                    if(project != null){
                        company.removeProject(project);
                        System.out.println(project.getTitle() + " successfully removed");
                    }
                    else System.out.println("Project not found");
                    break;
                case 5:
                    company.findAndDisplayByTitle(getString("Please input the project title"));
                    break;
                case 6:
                    company.displayAllProjects();
                    break;
                case 7:
                    company.displayMemberNumbersForAllProjects();
                    break;
            }
        }
    }

    private static void exit(){
        if(getString("Do you want to exit? (Yes/No)").equals("Yes")){
            System.exit(1);
        }
    }

    private static int menu(String prompt, String... options){
        System.out.println(" -- " + prompt + " -- ");
        int k = 1;
        for(String s : options){
            System.out.println(k++ + ") "+ s);
        }
        System.out.print("0) Quit\n> ");

        @SuppressWarnings("resource")
		String response = new Scanner(System.in).nextLine();
        try {
            int responseInt = Integer.valueOf(response);
            if(responseInt >= 0 || responseInt <= k) return responseInt;
            else throw new Exception();
        } catch (Exception e){
            System.out.println("Error: Invalid input");
            return menu(prompt, options);
        }
    }

    @SuppressWarnings("resource")
	private static String getString(String prompt){
        System.out.print(prompt + "\n> ");
        return new Scanner(System.in).nextLine();
    }
}
