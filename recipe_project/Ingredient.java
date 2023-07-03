package recipe_project;

import java.util.ArrayList;
import java.util.Objects;

import extra.Utils;

public class Ingredient {

	private String name;
	private double mass;
	private ArrayList<PreparationStep> instructions;
	 
	public Ingredient(String name, 
					  double mass, 
					  ArrayList<PreparationStep> instructions) {
		super();
		this.name = name;
		this.mass = mass;
		setInstructions(instructions);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMass() {
		return mass;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}

	public ArrayList<PreparationStep> getInstructions() {
		return instructions;
	}

	public void setInstructions(ArrayList<PreparationStep> instructions) {
		this.instructions = Utils.copyList(instructions);
	}

	@Override
	public int hashCode() {
		return Objects.hash(instructions, mass, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Ingredient)) {
			return false;
		}
		Ingredient other = (Ingredient) obj;
		return Objects.equals(instructions, other.instructions)
				&& Double.doubleToLongBits(mass) == Double.doubleToLongBits(other.mass)
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Ingredient [name=" + name + ", mass=" + mass + ", instructions=" + instructions + "]";
	}

}
