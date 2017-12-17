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

public class AAMonitoringForm extends MIDlet implements CommandListener {

	private MealList mealListView;
	private EditMeal editMealView;

	private Storage storage;

	private Command acceptCommand;
	private Command cancelCommand;

	public AAMonitoringForm() {

		storage = new Storage();

		mealListView = new MealList();
		editMealView = new EditMeal();

		Meal[] meals = storage.loadMeals();
		mealListView.onDataLoaded(meals);

		Display.getDisplay(this).setCurrent(mealListView);

		acceptCommand = new Command("Accept", Command.OK, 1);
		cancelCommand = new Command("Cancel", Command.CANCEL, 1);
		
		mealListView.setCommandListener(this);
		
		editMealView.addCommand(acceptCommand);
		editMealView.addCommand(cancelCommand);
		editMealView.setCommandListener(this);
	}

	public void commandAction(Command c, Displayable d) {
		if (c.getCommandType() == Command.SCREEN) {
			Display.getDisplay(this).setCurrent(editMealView);
		}
		
		if (c.getCommandType() == Command.OK) {
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