package com.godrabbit.rabbitutilities;

public enum MiningLevels {
	gravel(0),
	stone(1),
	aikinite(2),
	coal(3),
	anapaite(4),
	iron(5), //incl apatite
	gold(6), //incl lizardite
	redstone(7), //incl. halite, mixite and onyx	
	diamond(8), //incl opal, jordanite , galena	, linarite
	obsidian(9), //incl hematite and krennerite	
	rutile(10),
	sylvite(11);
	
	int _id;
	
	MiningLevels(int id)
	{
		_id=id;
	}
	
	public int getId()
	{
		return this._id;
	}
	
	public static MiningLevels getFromId(int id)
	{
		for(MiningLevels lvl : MiningLevels.values())
		{
			if(lvl._id == id)
				return lvl;
		}
		return gravel;
		
	}
	
	
}
