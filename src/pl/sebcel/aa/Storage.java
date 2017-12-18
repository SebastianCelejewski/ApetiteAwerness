package pl.sebcel.aa;

import java.util.Date;

import javax.microedition.rms.RecordStore;

import pl.sebcel.aa.model.Feel;
import pl.sebcel.aa.model.Meal;
import pl.sebcel.aa.model.Meals;

public class Storage {

	public Meals loadData() {
		try {
			RecordStore recordStore = RecordStore.openRecordStore("AAT", true);

			Meals meals = new Meals();
			int numberOfRecords = recordStore.getNumRecords();
			for (int i = 0; i < numberOfRecords; i++) {
				byte[] record = recordStore.getRecord(i);
				Meal meal = deserializeMeal(record);
				meals.add(meal);
				recordStore.closeRecordStore();
			}

			return meals;

		} catch (Exception ex) {
			throw new RuntimeException("Failed to load data from the record store: " + ex.getMessage());
		}

	}

	public void saveData(Meals meals) {
		try {
			RecordStore recordStore = RecordStore.openRecordStore("AAT", true);
			for (int i = 0; i < meals.size(); i++) {
				Meal meal = meals.get(i);
				byte[] record = serializeMeal(meal);
				recordStore.addRecord(record, 0, record.length);
				recordStore.closeRecordStore();
			}

		} catch (Exception ex) {
			throw new RuntimeException("Failed to save data to the record store: " + ex.getMessage());
		}

	}

	private Meal deserializeMeal(byte[] data) {
		Meal meal = new Meal();
		meal.setDate(new Date());
		meal.setHungerLevelBeforeMeal(2);
		meal.setHungerLevelAfterMeal(4);
		meal.setFeel(Feel.NEGATIVE);
		meal.setFoodAvailable(false);
		meal.setCdToStart(false);
		meal.setCdToFinish(true);
		return meal;
	}

	private byte[] serializeMeal(Meal meal) {
		byte[] dateBytes = convertLongToByteArray(meal.getDate().getTime());
		
		byte[] data = new byte[10];
		data[0] = dateBytes[0];
		data[1] = dateBytes[1];
		data[2] = dateBytes[2];
		data[3] = dateBytes[3];
		
		data[4] = (byte) meal.getFeel();
		data[5] = (byte) meal.getHungerLevelBeforeMeal();
		data[6] = (byte) meal.getHungerLevelAfterMeal();
		data[7] = (byte) (meal.isFoodAvailable() ? 1 : 0);
		data[8] = (byte) (meal.isCdToStart() ? 1 : 0);
		data[9] = (byte) (meal.isCdToFinish() ? 1 : 0);
		
		return data;
	}

	private byte[] convertLongToByteArray(long l) {
		byte[] b = new byte[4];
	    for (int i=0; i<4; i++) {
	    	b[i] = (byte)(l % 256) ;
	    	l = l / 256;
	    }
	    
	    return b;
	}
}