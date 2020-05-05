package Step2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Company {
    private String name;
    private Queue<Project> projects = new LinkedList<>();
    private ArrayList<TeamMember> members = new ArrayList<>();

    public Company(String name) {
        this.name = name;
    }

    public void addTeamMember(TeamMember teamMember){
    	if(this.members.add(teamMember))
            System.out.println(teamMember.getEmployeename() + " added successfully");
            else System.out.println("User already exists within this project.");
        }

    public boolean removeTeamMember(TeamMember teamMember){
        if(this.members.remove(teamMember)){
            System.out.println(teamMember.getEmployeename() + " removed successfully");
            return true;
        } else {
            System.out.println(teamMember.getEmployeename() + " not found");
            return false;
        }
    }

    public void displayAllTeamMembers(){
        System.out.println("NAME\t\tDIVISION\t\tID");
        Arrays.sort(members.toArray());
        for(TeamMember t : members) System.out.println(t.toString());
    }

    public TeamMember findTeamMemberByName(String s){
        for (TeamMember t: members) {
            if(t.getEmployeename().toLowerCase().contains(s.toLowerCase())) return t;
        }
        return null;
    }

    public void addProject(Project p){
    	if(this.projects.add(p))
            System.out.println(p.getTitle() + " added successfully");
            else System.out.println("Project already exists with this name");
        }
    public boolean removeProject(Project p){
        if(this.projects.remove(p)){
            System.out.println(p.getTitle() + " removed successfully");
            return true;
        } else {
            System.out.println(p.getTitle() + " not found");
            return false;
        }
    }

    public void findAndDisplayByTitle(String s){
        Project p = findProjectByTitle(s);
        System.out.println(p!=null?("TITLE\t\t\t\t\tMEMBERS\n"+p.toString()):"Project " + s + " not found");
    }

    public Project findProjectByTitle(String s){
        for (Project p: projects) {
            if(p.getTitle().toLowerCase().equals(s.toLowerCase())) return p;
        }
        return null;
    }

    public void displayAllProjects(){
        System.out.println("TITLE\t\t\t\t\tMEMBERS");
        Arrays.sort(projects.toArray());
        for(Project p : projects) System.out.println(p.toString());
    }

    public void findAndDisplayTeamMemberByName(String n) {
        TeamMember t = findTeamMemberByName(n);
        System.out.println(t!=null?("NAME\t\tDIVISION\t\tID\n"+t.toString()):"Team Member " + n + " not found");
    }
}
