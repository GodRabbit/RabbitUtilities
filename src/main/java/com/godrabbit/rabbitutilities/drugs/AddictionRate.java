package com.godrabbit.rabbitutilities.drugs;

public class AddictionRate {
	public static final AddictionRate nonAddictive = new AddictionRate(0.0, 100.5, 100.5);
	public static final AddictionRate hardlyAddictive = new AddictionRate(1.0, 5.0, 1.0);
	public static final AddictionRate slightlyAddictive = new AddictionRate(5.0, 1.0, 0.5);
	public static final AddictionRate Addictive= new AddictionRate(10.0, 2.0, 1.0);
	public static final AddictionRate highlyAddictive =  new AddictionRate(20.0, 1.0, 0.5);
	public static final AddictionRate extremelyAddictive = new AddictionRate(40.0, 0.5, 0.3); 
	
	public double addictionPerUse; //how much your addiction [1-100] grows with each use;
	public double dsGrowthRate; //ds (drug saturation) per day; 100 ds = start recovering addiction
	public double recoveringRate; //how much you recover per day [only when your ds is 100]. max is 100;
	
	 AddictionRate(double addictionRate, double satGrowthRate, double recoveringRate)
	{
		this.addictionPerUse=addictionRate;
		this.dsGrowthRate=satGrowthRate;
		this.recoveringRate=recoveringRate;
	}

	public double getAddictionPerUse() {
		return addictionPerUse;
	}

	public void setAddictionPerUse(double addictionPerUse) {
		this.addictionPerUse = addictionPerUse;
	}

	public double getDsGrowthRate() {
		return dsGrowthRate;
	}

	public void setDsGrowthRate(double dsGrowthRate) {
		this.dsGrowthRate = dsGrowthRate;
	}

	public double getRecoveringRate() {
		return recoveringRate;
	}

	public void setRecoveringRate(double recoveringRate) {
		this.recoveringRate = recoveringRate;
	}
	 
	
}
