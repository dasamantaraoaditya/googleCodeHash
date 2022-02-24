package entities;
import entities.*;

import java.util.List;

public class Contributors {
    String name;
    List<Skill> skill;
    public Contributors(String n, List<Skill> s){
    this.name = n;
    this.skill = s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Skill> getSkill() {
        return skill;
    }

    public void setSkill(List<Skill> skill) {
        this.skill = skill;
    }
}
