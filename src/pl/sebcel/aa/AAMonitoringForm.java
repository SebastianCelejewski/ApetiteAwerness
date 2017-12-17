package pl.sebcel.aa;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

import pl.sebcel.aa.model.Meal;

public class AAMonitoringForm extends MIDlet implements CommandListener {

	private MealList mealList;
	private Storage storage;
	
	public AAMonitoringForm() {
		
		storage = new Storage();
		mealList = new MealList();
		Meal[] meals = storage.loadMeals();
		mealList.onDataLoaded(meals);
		
		Display.getDisplay(this).setCurrent(mealList);
		
	}

	public void commandAction(Command c, Displayable d) {
	}

	protected void startApp() throws MIDletStateChangeException {
	}

	protected void destroyApp(boolean unconditional) throws MIDletStateChangeException {
	}

	protected void pauseApp() {
	}

}