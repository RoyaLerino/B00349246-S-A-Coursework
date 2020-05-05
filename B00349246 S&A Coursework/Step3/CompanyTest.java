package Step3;

import java.util.Scanner;

public class CompanyTest {

    private static Company testCompany = new Company("Test Company");

    public static void main(String[] args) {
        while (true){
            switch (menu("Main Menu", "Add Project", "Remove Project", "Display Projects", "Find a project")){
                case 0:
                    exit();
                case 1:
                    testCompany.addProject(new Project(getString("Please provide a title for your new project.")));
                    break;
                case 2:
                    testCompany.removeProject(testCompany.findProjectByTitle(getString("Please type which project you would like to remove.")));
                    break;
                case 3:
                    testCompany.displayAllProjects();
                    break;
                case 4:
                    testCompany.findAndDisplayByTitle(getString("Please input project title to search."));
                    break;
            }
        }
    }

    private static int menu(String prompt, String... options){
        System.out.println(" -- " + prompt + " -- ");
        int k = 1;
        for(String s : options){
            System.out.println(k++ + ") "+ s);
        }
        System.out.print("0) Quit\n> ");

        String response = new Scanner(System.in).nextLine();
        try {
            int responseInt = Integer.valueOf(response);
            if(responseInt >= 0 || responseInt <= k) return responseInt;
            else throw new Exception();
        } catch (Exception e){
            System.out.println("Invalid input");
            return menu(prompt, options);
        }
    }

    private static void exit(){
        if(getString("Do you want to exit? (y/n)").equals("y")){
            System.exit(1);
        }
    }

    private static String getString(String prompt){
        System.out.print(prompt + "\n> ");
        return new Scanner(System.in).nextLine();
    }

}
