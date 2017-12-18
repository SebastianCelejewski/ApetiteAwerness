package pl.sebcel.aa.events;

import pl.sebcel.aa.model.Meals;

public interface DataLoadedListener {
	
	void onDataLoaded(Meals meals);

}