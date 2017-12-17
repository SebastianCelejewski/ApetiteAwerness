package pl.sebcel.aa.events;

import pl.sebcel.aa.model.Meal;

public interface DataLoadedListener {
	
	void onDataLoaded(Meal[] meals);

}