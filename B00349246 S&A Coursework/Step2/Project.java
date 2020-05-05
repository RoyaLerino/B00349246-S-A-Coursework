package Step2;

import java.util.Date;

public class Project implements Comparable<Project> {
    private String title;
    private Date startDate, endDate;

    public Project(String title, Date startDate, Date endDate) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return title;
    }

    @Override
    public int compareTo(Project project) {
        return this.title.compareTo(project.title);
    }

    public Project(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
