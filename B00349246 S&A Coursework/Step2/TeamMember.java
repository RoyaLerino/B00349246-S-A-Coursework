package Step2;

public class TeamMember implements Comparable<TeamMember> {

    private String employeename, divisionname, id;

    public TeamMember(String employeename, String divisionname, String id) {
        this.employeename = employeename;
        this.divisionname = divisionname;
        this.id = id;
    }

    @Override
    public int compareTo(TeamMember teamMember) {
        return this.employeename.compareTo(teamMember.employeename);
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }

    public String getDivisionname() {
        return divisionname;
    }

    public void setDivisionname(String divisionname) {
        this.divisionname = divisionname;
    }

    public String getId() {
        return id;
    }



    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return employeename + "\t\t" + divisionname + "\t\t\t" + id ;
    }
}
