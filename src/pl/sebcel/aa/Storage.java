package pl.sebcel.aa;

import java.util.Date;

import javax.microedition.rms.RecordStore;

import pl.sebcel.aa.model.Meal;
import pl.sebcel.aa.model.Meals;

public class Storage {

	public Meals loadData() {
		System.out.println("Loading data");
		try {

			RecordStore recordStore = RecordStore.openRecordStore("AAT", true);

			Meals meals = new Meals();
			int numberOfRecords = recordStore.getNumRecords();
			for (int i = 1; i <= numberOfRecords; i++) {
				byte[] record = recordStore.getRecord(i);
				Meal meal = deserializeMeal(record);
				meals.add(meal);
			}
			recordStore.closeRecordStore();
			System.out.println("Data loaded successfully");
			return meals;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("Failed to load data from the record store: " + ex.getMessage());
		}

	}

	public void saveData(Meals meals) {
		System.out.println("Saving data");
		try {
			RecordStore.deleteRecordStore("AAT");

			RecordStore recordStore = RecordStore.openRecordStore("AAT", true);
			for (int i = 0; i < meals.size(); i++) {
				Meal meal = meals.get(i);
				byte[] record = serializeMeal(meal);
				recordStore.addRecord(record, 0, record.length);
			}
			recordStore.closeRecordStore();
			System.out.println("Data saved successfully");
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("Failed to save data to the record store: " + ex.getMessage());
		}

	}
	
	private Meal deserializeMeal(byte[] data) {
		Meal meal = new Meal();
		
		byte[] dateBytes = new byte[8];
		for (int i = 0; i < 7; i++) {
			dateBytes[i] = data[i];
		}

		meal.setDate(new Date(bytesToLong(dateBytes)));
		meal.setFeel(data[8]);
		meal.setHungerLevelBeforeMeal(data[9]);
		meal.setHungerLevelAfterMeal(data[10]);
		meal.setFoodAvailable(data[11] == 1 ? true : false);
		meal.setCdToStart(data[12] == 1 ? true : false);
		meal.setCdToFinish(data[13] == 1 ? true : false);
		return meal;
	}

	private byte[] serializeMeal(Meal meal) {
		byte[] dateBytes = longToBytes(meal.getDate().getTime());

		byte[] data = new byte[14];
		for (int i = 0; i < 7; i++) {
			data[i] = dateBytes[i];
		}

		data[8] = (byte) meal.getFeel();
		data[9] = (byte) meal.getHungerLevelBeforeMeal();
		data[10] = (byte) meal.getHungerLevelAfterMeal();
		data[11] = (byte) (meal.isFoodAvailable() ? 1 : 0);
		data[12] = (byte) (meal.isCdToStart() ? 1 : 0);
		data[13] = (byte) (meal.isCdToFinish() ? 1 : 0);

		return data;
	}

	public static byte[] longToBytes(long l) {
		byte[] result = new byte[8];
		for (int i = 7; i >= 0; i--) {
			result[i] = (byte) (l & 0xFF);
			l >>= 8;
		}
		return result;
	}

	public static long bytesToLong(byte[] b) {
		long result = 0;
		for (int i = 0; i < 8; i++) {
			result <<= 8;
			result |= (b[i] & 0xFF);
		}
		return result;
	}
}