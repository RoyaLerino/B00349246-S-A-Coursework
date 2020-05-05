package Step3;

import java.util.ArrayList;
import java.util.Arrays;

public class Project implements Comparable<Project> {
    private String title;
    private ArrayList<TeamMember> teamMembers = new ArrayList<>();

    public Project(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object obj) {
        try {
            return this.title.equals(((Project) obj).title);
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public String toString() {
        String s = title;
        if(teamMembers.isEmpty()) {
            s += "\t\t No Members";
        }else {
            s+="\t\t";
            for (TeamMember t : teamMembers) {
                s += " " + t.getName() + " ";
            }
        }
        return s;
    }

    @Override
    public int compareTo(Project project) {
        return this.title.compareTo(project.title);
    }

    public int getTeamSize(){
        return this.teamMembers.size();
    }

    public void addTeamMember(TeamMember teamMember) {
        this.teamMembers.add(teamMember);
    }

    public boolean removeTeamMember(TeamMember teamMember){
        if(this.teamMembers.remove(teamMember)){
            System.out.println(teamMember.getName() + " removed successfully");
            return true;
        } else {
            System.out.println(teamMember.getName() + " not found");
            return false;
        }
    }

    public void displayAllTeamMembers(){
        System.out.println("NAME\t\tDIVISION\t\tID");
        Arrays.sort(teamMembers.toArray());
        for(TeamMember t : teamMembers) System.out.println(t.toString());
    }

    public TeamMember findTeamMemberByName(String s){
        for (TeamMember t: teamMembers) {
            if(t.getName().toLowerCase().contains(s.toLowerCase())) return t;
        }
        return null;
    }

    public void findAndDisplayTeamMemberByName(String string) {
        TeamMember t = findTeamMemberByName(string);
        System.out.println(t!=null?("NAME\t\tDIVISION\t\tID\n"+t.toString()):"Team Member " + t + " not found");
    }

    public ArrayList<TeamMember> getTeamMembers() {
        return this.teamMembers;
    }

    public String getTitle() {
        return title;
    }
}
