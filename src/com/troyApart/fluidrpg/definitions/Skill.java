package com.troyApart.fluidrpg.definitions;

public class Skill {
	private String name;
	private String description;
	private int level;

	public Skill(String name, String description) {
		this.name = name;
		this.description = description;
		this.level = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	//Skill rank cost is the value of the rank (ie. rank 5: cost = 5 skill pts) and cost is cumulative, ie. to acheive rank 2 cost == 1 + 2 == 3
	public int checkPointsToLevelSkill(Skill skill) {
		return skill.getLevel() + 1;
	}
}
