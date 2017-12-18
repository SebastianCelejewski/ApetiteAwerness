package pl.sebcel.aa.gui;

import javax.microedition.lcdui.List;

import pl.sebcel.aa.model.Meal;
import pl.sebcel.aa.model.Meals;
import pl.sebcel.aa.utils.DateUtils;

public class MealList extends List {

	private Meals meals;

	public MealList() {
		super("Meal List", List.IMPLICIT);
	}

	public void setData(Meals meals) {
		this.deleteAll();
		this.meals = meals;
		for (int i = 0; i < meals.size(); i++) {
			this.append(DateUtils.toString(meals.get(i).getDate()), null);
		}
	}

	public Meal getSelectedMeal() {
		return meals.get(this.getSelectedIndex());
	}
}