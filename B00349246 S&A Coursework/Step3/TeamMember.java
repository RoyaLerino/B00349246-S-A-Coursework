package Step3;

public class TeamMember implements Comparable<TeamMember> {

    private String name;
    private String id;
	private String divisionname;

    public TeamMember(String name, String divisionname, String id) {
        this.name = name;
        this.divisionname = divisionname;
        this.id = id;
    }

	public TeamMember(String string, int int1) {
	}

	@Override
    public boolean equals(Object obj) {
        try {
            return this.name.equals(((TeamMember) obj).name);
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public String toString() {
        return name;
    }


    public String getName() {
        return name;
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
    public int compareTo(TeamMember teamMember) {
        return this.name.compareTo(teamMember.name);
    }
}
