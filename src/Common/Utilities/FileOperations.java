package Common.Utilities;

import entities.Contributors;
import entities.Project;
import entities.ProjectAssignments;
import entities.Skill;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileOperations {

    public static void readInput(String fileName, List<Contributors> contributorsList, List<Project> projectsList) throws IOException {
        File file = new File(fileName);

        BufferedReader br = new BufferedReader(new FileReader(file));
        String inputString;
        while ((inputString = br.readLine()) != null) {

            int contributors, projects;
            contributors = Integer.parseInt(inputString.split(" ")[0]);
            projects = Integer.parseInt(inputString.split(" ")[1]);

            //read contributors
            while (contributors != 0 && (inputString = br.readLine()) != null) {
                String contributorName = inputString.split(" ")[0];
                int noOfSkills = Integer.parseInt(inputString.split(" ")[1]);
                List<Skill> skills = new ArrayList<>(noOfSkills);
                //read skills
                while (noOfSkills != 0 && (inputString = br.readLine()) != null) {
                    String skillName = inputString.split(" ")[0];
                    int skillLevel = Integer.parseInt(inputString.split(" ")[1]);
                    Skill skill = new Skill(skillName, skillLevel);
                    skills.add(skill);
                    noOfSkills--;
                }
                contributorsList.add(new Contributors(contributorName, skills));
                contributors--;
            }

            //read projects
            while (projects != 0 && (inputString = br.readLine()) != null) {
                String projectName = inputString.split(" ")[0];
                int daysToComplete = Integer.parseInt(inputString.split(" ")[1]);
                int finalScore = Integer.parseInt(inputString.split(" ")[2]);
                int bestBefore = Integer.parseInt(inputString.split(" ")[3]);
                int noOfSkills = Integer.parseInt(inputString.split(" ")[4]);
                List<Skill> skills = new ArrayList<>(noOfSkills);
                //read roles
                while (noOfSkills != 0 && (inputString = br.readLine()) != null) {
                    String skillName = inputString.split(" ")[0];
                    int skillLevel = Integer.parseInt(inputString.split(" ")[1]);
                    Skill skill = new Skill(skillName, skillLevel);
                    skills.add(skill);
                    noOfSkills--;
                }
                projectsList.add(new Project(projectName, daysToComplete, finalScore, bestBefore, skills));
                projects--;
            }

        }
    }

    public static void writeOutput(String fileName, List<ProjectAssignments> projectAssignments) throws IOException {
        try {
            FileWriter myWriter = new FileWriter(fileName.replace("_", "-"));
            // no of completed projects
            myWriter.write(Integer.toString(projectAssignments.size())+"\n");
            // projects and their respective contributors
            for (ProjectAssignments projectAssignment:projectAssignments) {
                myWriter.write(projectAssignment.getProject().getName()+"\n");
                String finalContributors = "";
                for (Contributors contributor:projectAssignment.getContributors()) {
                    finalContributors = finalContributors + contributor.getName() + " ";
                }
                finalContributors.trim();
                myWriter.write(finalContributors);
                myWriter.write("\n");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
