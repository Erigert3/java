package recipe_project;

import java.util.ArrayList;
import java.util.Objects;

import extra.Utils;

public class Recipe {

	private static int nextId = 0;
	
	private int id;
	private String name;
	private ArrayList<Ingredient> ingredients;
	private ArrayList<PreparationStep> steps;
	private String description;
	
	private Recipe original;
	
	private final static ArrayList<Recipe> EXISTING = new ArrayList<Recipe>();
	
	public Recipe(String name, 
				  ArrayList<Ingredient> ingredients,
				  ArrayList<PreparationStep> steps) {
		this(++nextId, name, ingredients, steps, "", null);
	}
	 
	public Recipe(String name, 
				  ArrayList<Ingredient> ingredients,
				  ArrayList<PreparationStep> steps,
				  String description) {
		this(++nextId, name, ingredients, steps, description, null);
	}

	public Recipe(String name, 
				  ArrayList<Ingredient> ingredients,
				  ArrayList<PreparationStep> steps,
				  String description,
				  Recipe original) {
		this(++nextId, name, ingredients, steps, description, original);
	}

	public Recipe(int id,
				  String name, 
				  ArrayList<Ingredient> ingredients,
				  ArrayList<PreparationStep> steps,
				  String description,
				  Recipe original) { 
		if(exists(id)) {
			id = getNextId();
		}
		this.id = id;
		this.name = name;
		setIngredients(ingredients);
		setSteps(steps);
		this.description = description;
		this.original = original;
		EXISTING.add(this);
	}
	
	private void setSteps(ArrayList<PreparationStep> steps) {
		this.steps = Utils.copyList(steps); 
	}

	public void setIngredients(ArrayList<Ingredient> ingredients) {
		this.ingredients = Utils.copyList(ingredients);
	}

	private int getNextId() {
		while(exists(++nextId));
		return nextId;
	}

	private static boolean exists(int id) {
		for(Recipe r : EXISTING) {
			if(r.id == id) {
				return true;
			}
		}
		return false;
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

	public Recipe getOriginal() {
		return original;
	}

	public void setOriginal(Recipe original) {
		this.original = original;
	}

	public ArrayList<Ingredient> getIngredients() {
		return ingredients;
	}

	public ArrayList<PreparationStep> getSteps() {
		return steps;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		if(this.id != 0) {
			return;
		}
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id, ingredients, name, original, steps);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Recipe)) {
			return false;
		}
		Recipe other = (Recipe) obj;
		return Objects.equals(description, other.description) && id == other.id
				&& Objects.equals(ingredients, other.ingredients) && Objects.equals(name, other.name)
				&& Objects.equals(original, other.original) && Objects.equals(steps, other.steps);
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", name=" + name + ", ingredients=" + ingredients + ", steps=" + steps
				+ ", description=" + description + ", original=" + original + "]";
	}
	
}
