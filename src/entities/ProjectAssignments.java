package entities;

import java.util.List;

public class ProjectAssignments {
    Project project;
    List<Contributors> contributors;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Contributors> getContributors() {
        return contributors;
    }

    public void setContributors(List<Contributors> contributors) {
        this.contributors = contributors;
    }
}
