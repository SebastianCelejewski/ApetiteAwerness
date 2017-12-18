package pl.sebcel.aa.gui;

import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.DateField;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Gauge;

import pl.sebcel.aa.model.Feel;
import pl.sebcel.aa.model.Meal;

public class EditMeal extends Form {

	private DateField dateField = new DateField("Date", DateField.DATE_TIME);
	private Gauge hungerLevelBeforeMealField = new Gauge("Hunger level before", true, 7, 4);
	private Gauge hungerLevelAfterMealField = new Gauge("Hunger level after", true, 7, 4);
	private ChoiceGroup feelField = new ChoiceGroup("Feel", ChoiceGroup.EXCLUSIVE, new String[] { "Positive", "Neutral", "Negative" }, null);
	private ChoiceGroup foodAvailableField = new ChoiceGroup("Food available", ChoiceGroup.EXCLUSIVE,new String[] { "Yes", "No" }, null);
	private ChoiceGroup cdField = new ChoiceGroup("CD to...", ChoiceGroup.MULTIPLE, new String[] { "Start", "End" }, null);

	public EditMeal() {
		super("Edit Meal");
		this.append(dateField);
		this.append(hungerLevelBeforeMealField);
		this.append(hungerLevelAfterMealField);
		this.append(feelField);
		this.append(foodAvailableField);
		this.append(cdField);
	}

	public void setData(Meal meal) {
		this.dateField.setDate(meal.getDate());
		this.hungerLevelBeforeMealField.setValue(meal.getHungerLevelBeforeMeal());
		this.hungerLevelAfterMealField.setValue(meal.getHungerLevelAfterMeal());
		this.feelField.setSelectedFlags(new boolean[] { meal.getFeel() == Feel.POSITIVE, meal.getFeel() == Feel.NEUTRAL, meal.getFeel() == Feel.NEGATIVE });
		this.foodAvailableField.setSelectedFlags(new boolean[] { meal.isFoodAvailable(), !meal.isFoodAvailable() });
		this.cdField.setSelectedFlags(new boolean[] { meal.isCdToStart(), meal.isCdToFinish() });
	}

	public Meal getData() {
		Meal meal = new Meal();
		meal.setDate(dateField.getDate());
		return meal;
	}
}