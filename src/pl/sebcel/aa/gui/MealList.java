package pl.sebcel.aa.gui;

import javax.microedition.lcdui.List;

import pl.sebcel.aa.events.DataLoadedListener;
import pl.sebcel.aa.model.Meal;
import pl.sebcel.aa.utils.DateUtils;

public class MealList extends List implements DataLoadedListener {

	private Meal[] meals;
	
	public MealList() {
		super("Meal List", List.IMPLICIT);
	}

	public void onDataLoaded(Meal[] meals) {
		this.deleteAll();
		this.meals = meals;
		for (int i = 0; i < meals.length; i++) {
			this.append(DateUtils.toString(meals[i].getDate()), null);
		}
	}
	
	public Meal getSelectedMeal() {
		return meals[this.getSelectedIndex()];
	}
}