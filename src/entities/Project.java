package entities;

import java.util.List;

public class Project {
    String name;
    int daysToComplete;
    int finalScore;
    int bestBefore;
    List<Skill> requiredSkills;

    public Project(String name, int daysToComplete, int finalScore, int bestBefore, List<Skill> requiredRoles){
        this.name = name;
        this.bestBefore = bestBefore;
        this.daysToComplete = daysToComplete;
        this.finalScore =  finalScore;
        this.requiredSkills = requiredRoles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDaysToComplete() {
        return daysToComplete;
    }

    public void setDaysToComplete(int daysToComplete) {
        this.daysToComplete = daysToComplete;
    }

    public int getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(int finalScore) {
        this.finalScore = finalScore;
    }

    public int getBestBefore() {
        return bestBefore;
    }

    public void setBestBefore(int bestBefore) {
        this.bestBefore = bestBefore;
    }

    public List<Skill> getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(List<Skill> requiredSkills) {
        this.requiredSkills = requiredSkills;
    }
}
