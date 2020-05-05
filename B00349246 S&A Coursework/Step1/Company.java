package Step1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Company {
    private String name;
    private Queue<Project> projects = new LinkedList<>();

    public Company(String name) {
        this.name = name;
    }

    public void addProject(Project p){
    	if(this.projects.add(p))
            System.out.println(p.getTitle() + " added successfully");
            else System.out.println("Project already exists with this name");
        }

    public boolean removeProject(Project p){
        if(this.projects.remove(p)){
            System.out.println(p.getTitle() + " has been removed successfully");
            return true;
        } else {
            System.out.println(p.getTitle() + " cannot be found");
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

    public void displayProject(String title){
        System.out.println(findProjectByTitle(title));
    }

    public void displayProject(Project p){
        System.out.println(p.toString());
    }

    public void displayAllProjects(){
        System.out.println("TITLE\t\t\t\t\tMEMBERS");
        Arrays.sort(projects.toArray());
        for(Project p : projects) System.out.println(p.toString());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Queue<Project> getProjects() {
        return projects;
    }

    public void setProjects(Queue<Project> projects) {
        this.projects = projects;
    }
}
