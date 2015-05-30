package com.jdc.fx.day2.ep4;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Exam {

	private IntegerProperty burmese = new SimpleIntegerProperty();
	private IntegerProperty english = new SimpleIntegerProperty();
	private IntegerProperty maths = new SimpleIntegerProperty();
	private IntegerProperty physics = new SimpleIntegerProperty();
	private IntegerProperty chemistry = new SimpleIntegerProperty();
	private IntegerProperty biology = new SimpleIntegerProperty();
	
	public IntegerProperty burmeseProperty() {
		return burmese;
	}
	
	public IntegerProperty englishProperty() {
		return english;
	}
	
	public IntegerProperty mathsProperty() {
		return maths;
	}
	
	public IntegerProperty physicsProperty() {
		return physics;
	}
	
	public IntegerProperty chemistryProperty() {
		return chemistry;
	}
	
	public IntegerProperty biologyProperty() {
		return biology;
	}

	private NumberBinding total = new IntegerBinding() {

		{
			super.bind(burmese, 
					english, maths, 
					physics, chemistry, 
					biology);
		}

		@Override
		protected int computeValue() {
			return Bindings.add(
					burmese.add(biology).add(english),
					maths.add(physics).add(chemistry))
						.intValue();
		}
	};
	
	private NumberBinding average = total.divide(6);

	public int getTotal() {
		return total.intValue();
	}
	
	public int getAverage() {
		return average.intValue();
	}
	
	public NumberBinding averageProperty() {
		return average;
	}

	public NumberBinding totalProperty() {
		return total;
	}

	public int getBurmese() {
		return burmese.get();
	}

	public void setBurmese(int burmese) {
		this.burmese.set(burmese);
		;
	}

	public int getEnglish() {
		return english.get();
	}

	public void setEnglish(int english) {
		this.english.set(english);
		;
	}

	public int getMaths() {
		return maths.get();
	}

	public void setMaths(int maths) {
		this.maths.set(maths);
	}

	public int getPhysics() {
		return physics.get();
	}

	public void setPhysics(int physics) {
		this.physics.set(physics);
	}

	public int getChemistry() {
		return chemistry.get();
	}

	public void setChemistry(int chemistry) {
		this.chemistry.set(chemistry);
	}

	public int getBiology() {
		return biology.get();
	}

	public void setBiology(int biology) {
		this.biology.set(biology);
	}

}
