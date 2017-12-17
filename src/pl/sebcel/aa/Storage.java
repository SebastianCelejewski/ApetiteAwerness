package pl.sebcel.aa;

import java.util.Date;

import pl.sebcel.aa.model.Meal;

public class Storage {

	public Meal[] loadMeals() {
		Meal[] meals = new Meal[5];
		for (int i = 0; i < meals.length; i++) {
			Meal meal = new Meal();
			meal.setDate(new Date());
			meals[i] = meal;
		}
		return meals;
	}
}