package pl.sebcel.aa.model;

import java.util.Vector;

public class Meals {
	
	private Vector data;
	
	public Meals() {
		data = new Vector();
	}
	
	public int size() {
		return data.size();
	}
	
	public Meal get(int idx) {
		return (Meal) data.elementAt(idx);
	}
	
	public void set(int idx, Meal meal) {
		data.setElementAt(meal,  idx);
	}
	
	public void add(Meal meal) {
		data.addElement(meal);
	}
	
}