package pl.sebcel.aa.model;

import java.util.Date;

public class Meal {

	private Date date;
	private int hungerLevelBeforeMeal;
	private int hungerLevelAfterMeal;
	private int feel;
	private boolean foodAvailable;
	private boolean cdToStart;
	private boolean cdToFinish;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getHungerLevelBeforeMeal() {
		return hungerLevelBeforeMeal;
	}

	public void setHungerLevelBeforeMeal(int hungerLevelBeforeMeal) {
		this.hungerLevelBeforeMeal = hungerLevelBeforeMeal;
	}

	public int getHungerLevelAfterMeal() {
		return hungerLevelAfterMeal;
	}

	public void setHungerLevelAfterMeal(int hungerLevelAfterMeal) {
		this.hungerLevelAfterMeal = hungerLevelAfterMeal;
	}

	public int getFeel() {
		return feel;
	}

	public void setFeel(int feel) {
		this.feel = feel;
	}

	public boolean isFoodAvailable() {
		return foodAvailable;
	}

	public void setFoodAvailable(boolean foodAvailable) {
		this.foodAvailable = foodAvailable;
	}

	public boolean isCdToStart() {
		return cdToStart;
	}

	public void setCdToStart(boolean cdToStart) {
		this.cdToStart = cdToStart;
	}

	public boolean isCdToFinish() {
		return cdToFinish;
	}

	public void setCdToFinish(boolean cdToFinish) {
		this.cdToFinish = cdToFinish;
	}

}