package pl.sebcel.aa;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

import pl.sebcel.aa.gui.EditMeal;
import pl.sebcel.aa.gui.MealList;
import pl.sebcel.aa.model.Meal;
import pl.sebcel.aa.model.Meals;

public class AAMonitoringForm extends MIDlet implements CommandListener {

	private MealList mealListView;
	private EditMeal editMealView;

	private Storage storage;

	private Command addCommand;
	private Command acceptCommand;
	private Command cancelCommand;

	private Meals meals;
	
	public AAMonitoringForm() {

		storage = new Storage();

		mealListView = new MealList();
		editMealView = new EditMeal();

		meals = storage.loadData();
		mealListView.setData(meals);

		Display.getDisplay(this).setCurrent(mealListView);

		addCommand = new Command("Add", Command.ITEM, 1);
		acceptCommand = new Command("Accept", Command.OK, 1);
		cancelCommand = new Command("Cancel", Command.CANCEL, 1);

		mealListView.addCommand(addCommand);
		mealListView.setCommandListener(this);

		editMealView.addCommand(acceptCommand);
		editMealView.addCommand(cancelCommand);
		editMealView.setCommandListener(this);
	}

	public void commandAction(Command c, Displayable d) {
		if (c.getCommandType() == Command.SCREEN) {
			Meal selectedMeal = mealListView.getSelectedMeal();
			editMealView.setData(selectedMeal);
			editMealView.setMode(EditMeal.EDIT);
			Display.getDisplay(this).setCurrent(editMealView);
		}

		if (c.getCommandType() == Command.ITEM) {
			Meal newMeal = new Meal();
			editMealView.setData(newMeal);
			editMealView.setMode(EditMeal.ADD);
			Display.getDisplay(this).setCurrent(editMealView);
		}

		if (c.getCommandType() == Command.OK) {
			Meal meal = editMealView.getData();
			
			if (editMealView.getMode() == EditMeal.ADD) {
				meals.add(meal);
			} else {
				meals.set(mealListView.getSelectedIndex(), meal);
			}
			
			mealListView.setData(meals);
			storage.saveData(meals);
			Display.getDisplay(this).setCurrent(mealListView);
		}

		if (c.getCommandType() == Command.CANCEL) {
			Display.getDisplay(this).setCurrent(mealListView);
		}
	}

	protected void startApp() throws MIDletStateChangeException {
	}

	protected void destroyApp(boolean unconditional) throws MIDletStateChangeException {
	}

	protected void pauseApp() {
	}

}