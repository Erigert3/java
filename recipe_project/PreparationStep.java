package recipe_project;

import java.util.Objects;

public class PreparationStep {

	private int number;
	private String instructions;
	 
	public PreparationStep(int number, String instructions) {
		super();
		this.number = number;
		this.instructions = instructions;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	@Override
	public int hashCode() {
		return Objects.hash(instructions, number);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PreparationStep)) {
			return false;
		}
		PreparationStep other = (PreparationStep) obj;
		return Objects.equals(instructions, other.instructions) && 
			   number == other.number;
	}

	@Override
	public String toString() {
		return "PreparationStep [number=" + number + ", instructions=" + instructions + "]";
	} 

}
