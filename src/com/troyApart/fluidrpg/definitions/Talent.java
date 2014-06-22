package com.troyApart.fluidrpg.definitions;

import java.util.ArrayList;

public class Talent {
	//Something that can be learned given a pre-obtained skill
		private String name;
		private String description;
		private Skill skill;
		private int reqSkillLevel;

		public Talent(String name, String description, Skill skill, int reqSkillLevel) {
			this.name = name;
			this.description = description;
			this.skill = skill;
			this.reqSkillLevel = reqSkillLevel;
		}

		public String getName() {
			return name;
		}
		public String getDescription() {
			return description;
		}
		public Skill getSkill() {
			return skill;
		}
		public int getRequiredSkillLevel() {
			return reqSkillLevel;
		}
		public void setName(String name) {
			this.name = name;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public void setSkill(Skill skill) {
			this.skill = skill;
		}
		public void setRequiredSkillLevel(int reqSkillLevel) {
			this.reqSkillLevel = reqSkillLevel;
		}

		//Pass in Array of Strings and 
		public int findSkillLevelByName(ArrayList<Skill> skills, Skill skill) {
			for (Skill s : skills) {
				if (skill.getName().equals(s.getName())) {
					return s.getLevel();
				}
			}
			System.out.println("Skill not found!");
			return -1;
		}
}
