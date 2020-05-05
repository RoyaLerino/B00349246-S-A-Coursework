package Step2;

import java.util.Scanner;

public class TeamMemberTest {

    private static Company company = new Company("Test Company");

    public static void main(String[] args) {
        while (true){
            switch (menu("Menu", "Add Team Member", "Remove Team Member", "Display Team Members", "Find a Team Member")){
                case 0:
                    exit();
                case 1:
                    company.addTeamMember(new TeamMember(getString("Please input Team Member name"),
                            getString("Please input Team Division Name"),
                            getString("Please input Team Member ID")));
                    break;
                case 2:
                    company.removeTeamMember(company.findTeamMemberByName(getString("Please input name of team member to remove")));
                    break;
                case 3:
                    company.displayAllTeamMembers();
                    break;
                case 4:
                    company.findAndDisplayTeamMemberByName(getString("Please input a team member name"));
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
            System.out.println("Error: Invalid input");
            return menu(prompt, options);
        }
    }

    private static String getString(String prompt){
        System.out.print(prompt + "\n> ");
        return new Scanner(System.in).nextLine();
    }

    private static int getInt(String prompt){
        try {
            return Integer.valueOf(getString(prompt));
        } catch (Exception e){
            System.out.println("Please input an integer");
            return getInt(prompt);
        }
    }
    private static void exit(){
        if(getString("Do you want to exit? (Yes/No)").equals("Yes")){
            System.exit(1);
        }
    }
}