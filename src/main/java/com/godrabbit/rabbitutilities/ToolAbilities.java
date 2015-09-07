package com.godrabbit.rabbitutilities;

public enum ToolAbilities {
	repair(100, "repair"), //imp!
	luck(1, "luck"), //imp
	luckChance(100, "luckChance"),  //imp
	//light(1, "light"), //tool can light up places on r click
	haste(20, "haste"), //dig speed //imp!
	sharpness(10, "sharpness"), //raw damage //imp!
	smite(10, "smite"), //damage against undead and witches //imp!
	durability(300, "durability"), //extra durability to the tool
	unbreaking(10, "unbreaking"), //a chance the tool wont lose durability //imp!
	speed(5, "speed"), //gives speed to player on succsesful use //imp!
	flame(10, "flame"), //entities damaged are set on fire for several secs //imp!
	//furnace(1, "furnace"), //smelt blocks the tool break
	//silk(1, "silk"), //harvest the block as is.
	fishy(100, "fishy"), //a chance to drop fish when using the tool //imp
	midas(100, "midas"), //a chance to drop gold nuggets while using the tool //imp
	beheading(100, "beheading"), //a chance to drop a head of the monster you atacking //imp
	quickSilver(10, "quicksilver"), //kills wolves faster //imp!
	repel(10, "repel"), //extra damage against spiders and bats //imp!
	lifesteal(100, "lifesteal"), //heal you every time you dmg a mob //imp!
	feeding(10, "feeding"), //gives hunger pts on hit, //imp
	knockback(5, "knockback"), //imp!
	slow(10,  "slow"), //slow the target for 10 seconds //imp
	//slowChance(100, "slowChance"),
	//milky(1, "milky"), //removes bad potion effects on block break
	poison(10, "poison"), //poison the target for 5 secs //imp
	evil(3, "evil"), //wither the target for 5 secs //imp
	frozen(1, "frozen"); //a 1% chance to spawn snow golem on hit //imp
	
	
	int _maxlvl;
	String _name;
	
	ToolAbilities(int maxLevel, String name)
	{
		_maxlvl=maxLevel;
		_name=name;
	}
	
	public int getMaxLevel()
	{
		return this._maxlvl;
	}
	
	public String getName()
	{
		return _name;
	}

}
