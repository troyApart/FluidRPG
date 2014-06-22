package com.troyApart.fluidrpg.definitions;

import java.util.ArrayList;
import java.util.Random;

public class Character {
	private String name;
	private String race;
	private int age;
	private int weightInPounds;
	private int heightInInches;
	private ArrayList<Skill> skills;
	private int skillPoints;
	private ArrayList<Talent> talents;
	private int talentPoints;

	public Character() {
		this.name = "Nameless";
		this.race = "Raceless";
		Random rand = new Random();
		this.age = rand.nextInt(100) + 1;
		this.skills = new ArrayList<Skill>();
		this.skillPoints = 0;
		this.talents = new ArrayList<Talent>();
		this.talentPoints = 0;
	}
	public Character(String name) {
		this.name = name;
		
	}

	public String getName() {
		return name;
	}

	//Prints all Skills Obtainable by Character and its current level
	public void getSkills() {
		for (Skill s : skills) {
			System.out.println("Name, " + s.getName() + " --- Level, " + s.getLevel());
		}
	}

	//Prints all skills that have been leveled at least once (Level 1 or higher)
	public void getLeveledSkills() {
		for (Skill s : skills) {
			if (s.getLevel() == 0) { 
				continue; 
			} else {
				System.out.println("Name, " + s.getName() + " --- Level, " + s.getLevel());
			}
		}
	}

	public void getTalents() {
		for (Talent t : talents) {
			System.out.println("Name, " + t.getName() + " --- , " + t.getRequiredSkillLevel());
		}
	}

	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public int getSkillPoints() {
		return skillPoints;
	}
	public void setSkillPoints(int skillPoints) {
		this.skillPoints = skillPoints;
	}
	public int getTalentPoints() {
		return talentPoints;
	}
	public void setTalentPoints(int talentPoints) {
		this.talentPoints = talentPoints;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSkills(ArrayList<Skill> skills) {
		this.skills = skills;
	}
	public void setTalents(ArrayList<Talent> talents) {
		this.talents = talents;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getWeightInPounds() {
		return weightInPounds;
	}
	public void setWeightInPounds(int weightInPounds) {
		this.weightInPounds = weightInPounds;
	}
	public int getHeightInInches() {
		return heightInInches;
	}
	public void setHeightInInches(int heightInInches) {
		this.heightInInches = heightInInches;
	}
	//Returns a boolean: True if skill can be improved and points will be deducted, False if Character does not have enough skill points
	public boolean improveSkill(int skillPosition) {
		Skill skillToImprove = skills.get(skillPosition);
		int requiredPoints = skillToImprove.checkPointsToLevelSkill(skillToImprove);
		if (requiredPoints <= skillPoints) {
			// skills.add(new Skill("Melee", "Hit Shit", 1));
			skillToImprove.setLevel(requiredPoints);
			this.skillPoints -= requiredPoints;
			System.out.println("Skill, " + skillToImprove.getName() + ", has improved to level " + requiredPoints + "!");
			return true;
		} else {
			System.out.println("Insufficient Points!");
			return false;
		}
	}

	public boolean acquireTalent(int talentPosition) {
		Talent talentToAcquire = talents.get(talentPosition);
		int skillLevel = talentToAcquire.findSkillLevelByName(skills, talentToAcquire.getSkill());
		if (talentPoints > 0 && talentToAcquire.getRequiredSkillLevel() <= skillLevel) {
			System.out.println("Talent, " + talentToAcquire.getName() + ", has been acquired!");
			return true;
		} else {
			if (talentPoints == 0) {
				System.out.println("Insufficient Points!");
			} else {
				System.out.println("Skill Level Not High Enough!");
			}
			return false;
		}

	}
}
