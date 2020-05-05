package Step3;

public class ProjectBinaryTree {
    private ProjectTreeNode root;

    public boolean add(Project value){
        if(root == null){
            root = new ProjectTreeNode(value);
            return true;
        }
        return root.insert(value);
    }



    public void remove(Project value){
        this.root = root.removeNode(root, value);
    }

    @Override
    public String toString() {
        if(root!=null) return root.toString();
        else return null;
    }

    public void printTeamMemberSizes(){
        printTeamMembers(root);
    }

    public void printTeamMembers(ProjectTreeNode root){
        if(root.leftside != null) printTeamMembers(root.leftside);
        root.printMemberNumber();
        if(root.rightside != null) printTeamMembers(root.rightside);
    }

    public Project find(Project value){
        return root.find(value);
    }

    public ProjectTreeNode getRoot() {
        return root;
    }
}
