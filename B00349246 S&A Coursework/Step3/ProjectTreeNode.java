package Step3;

public class ProjectTreeNode {
    private Project project;
    public ProjectTreeNode leftside;
    public ProjectTreeNode rightside;

    public ProjectTreeNode(Project project) {
        this.project = project;
    }

    public void printMemberNumber(){
        System.out.println(this.project.getTitle() + "       " + this.project.getTeamSize());
    }

    @Override
    public String toString() {
        String s = "";
        if(leftside != null) s += leftside.toString() + "\n";
        s += this.project.toString() + "\n";
        if(rightside != null) s += rightside.toString() + "\n";
        return s;
    }

    public boolean hasNext(){
        return this.leftside != null || this.rightside != null;
    }

    public Project getProject() {
        return this.project;
    }

    public Project find(Project value){
        if(this.project.equals(value)) return this.project;
        Project leftFind = null, rightFind = null;
        if(this.leftside != null) if(this.project.compareTo(value) > 0) leftFind = leftside.find(value);
        if(leftFind != null) return leftFind;
        if(this.rightside != null) if(this.project.compareTo(value) < 0) rightFind = rightside.find(value);
        if(rightFind != null) return rightFind;
        else return null;
    }

    public boolean insert(Project value){
        if(this.project.compareTo(value) > 0) {
            if (this.leftside == null) {
                this.leftside = new ProjectTreeNode(value);
                return true;
            } else this.leftside.insert(value);
        }
        if(this.project.compareTo(value) < 0) {
            if (this.rightside == null) {
                this.rightside = new ProjectTreeNode(value);
                return true;
            } else this.rightside.insert(value);
        }
        return false;
    }

    public ProjectTreeNode removeNode(ProjectTreeNode root, Project value) {
        if (root == null)  return root;
        if (this.project.compareTo(value) < 0)
            root.leftside = removeNode(root.leftside, value);
        else if (this.project.compareTo(value) > 0)
            root.rightside = removeNode(root.rightside, value);
        else{
            if (root.leftside == null) return root.rightside;
            else if (root.rightside == null) return root.leftside;
            root.project = findMinNode(root.rightside).project;
            root.rightside = removeNode(root.rightside, root.project);
        }
        return root;
    }

    public ProjectTreeNode findMinNode(ProjectTreeNode root) {
        if(root.leftside != null) return findMinNode(root.leftside);
        else return root;
    }

}
