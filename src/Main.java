import Common.Utilities.FileOperations;
import entities.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class  Main
{
    public static void main(String args[]) throws IOException {
        System.out.println("######### Starting mentorship calculator ###########");

        String fileName= "C:\\rough\\f_find_great_mentors.in.txt";
        List<Contributors> contributorsList = new ArrayList<>();
        List<Project> projectsList = new ArrayList<>();
        FileOperations.readInput(fileName, contributorsList, projectsList);

        List<ProjectAssignments> projectAssignments = assignContributorsToProjects(contributorsList, projectsList);
        FileOperations.writeOutput(fileName, projectAssignments);

        System.out.println("######### Ending mentorship calculator ###########");
    }

    private static List<ProjectAssignments> assignContributorsToProjects(List<Contributors> contributorsList, List<Project> projectsList) {
        List<ProjectAssignments> projectAssignments = new ArrayList<>();
        for (Project project: projectsList){
            ProjectAssignments projectAssignment = new ProjectAssignments();
            projectAssignment.setProject(project);
            List<Contributors> contributors = new ArrayList<>();
            String contributorsNames = "";
            for(Skill projectSkill:project.getRequiredSkills()){
                for(Contributors contributor: contributorsList){
                    for(Skill contributorSkill: contributor.getSkill()){
                        //contributor should not repeat for the same project and meet requirements
                        if(contributorSkill.getName().equals(projectSkill.getName()) &&
                                contributorSkill.getLevel() >= projectSkill.getLevel() &&
                                !contributorsNames.contains(contributor.getName())){
                            contributors.add(contributor);
                            contributorsNames = contributorsNames + contributor.getName();
                        }
                    }
                }
            }
            projectAssignment.setContributors(contributors);
            if(contributors.size()!=0){
                projectAssignments.add(projectAssignment);
            }
        }
        return projectAssignments;
    }
}  