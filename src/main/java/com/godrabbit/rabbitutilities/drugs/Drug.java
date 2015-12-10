package com.godrabbit.rabbitutilities.drugs;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public abstract class Drug {
	AddictionRate _rate;
	//ItemStack _addictive; //holds current addictive material. it holds it's stats in the nbt
	//drug ID, drug addiction rate [1-100]
	int _ID=0;
	
	public Drug(int ID, AddictionRate rate)
	{
		_rate=rate;
		_ID=ID;
	}
	
	public void onConsume(int level, World world, EntityPlayer player)
	{
		; //here are the positive [?] effects for when you consume the drug
		//level must play a role here as drugs get less effective the more 
		//your addiction level is higher;
		
		//you should put here only temporary buffs!
		//potion effects and such.  something that happens once!
	}
	
	public void onIntoxication(int level, World world, EntityPlayer player)
	{
		; //what happens after prolonged use of the drug, every now and then...
		//level must play a role here as the effects of intoxication are extreme
		//as you get addicted;
		
		//you should put here only temporary debuffs!
		//potion effects, mob spawning and such. something that happens once!
	}
	
	public AddictionRate getAddictionRate()
	{
		return _rate;
	}
}
