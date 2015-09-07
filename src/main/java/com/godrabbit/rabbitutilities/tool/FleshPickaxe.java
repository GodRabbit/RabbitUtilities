package com.godrabbit.rabbitutilities.tool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.godrabbit.rabbitutilities.MiningLevels;
import com.godrabbit.rabbitutilities.ToolAbilities;
import com.godrabbit.rabbitutilities.interfaces.IFleshTool;
import com.godrabbit.rabbitutilities.interfaces.IRabbitMiningLevel;
import com.godrabbit.rabbitutilities.libs.RandomStack;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class FleshPickaxe extends Item implements IFleshTool{
	
	ArrayList<Block> _gravel=new ArrayList<Block>();
	ArrayList<Block> _stone=new ArrayList<Block>();
	ArrayList<Block> _coal=new ArrayList<Block>();
	ArrayList<Block> _iron=new ArrayList<Block>();
	ArrayList<Block> _gold=new ArrayList<Block>();
	ArrayList<Block> _redstone=new ArrayList<Block>();
	ArrayList<Block> _diamond=new ArrayList<Block>();
	ArrayList<Block> _obsidian=new ArrayList<Block>();
	
	RandomStack _luckHit=new RandomStack();
	//RandomStack _luckDig=new RandomStack();
	
	
	public FleshPickaxe() 
	{
		this.setMaxStackSize(1);
		this.setMaxDamage(350);
		
		_gravel.add(Blocks.gravel);
		_gravel.add(Blocks.sand);
		_gravel.add(Blocks.dirt);
		_gravel.add(Blocks.grass);
	
		_stone.add(Blocks.cobblestone);
		_stone.add(Blocks.stone);
		_stone.add(Blocks.furnace);
		_stone.add(Blocks.glass);
		_stone.add(Blocks.glowstone);
		_stone.add(Blocks.brick_block);
		_stone.add(Blocks.brick_stairs);
		_stone.add(Blocks.mossy_cobblestone);
		
		_coal.add(Blocks.coal_ore);
		_coal.add(Blocks.coal_block);
		_coal.add(Blocks.sponge);
		_coal.add(Blocks.netherrack);
		_coal.add(Blocks.nether_brick);
		_coal.add(Blocks.nether_brick_fence);
		_coal.add(Blocks.nether_brick_stairs);
		
		_iron.add(Blocks.iron_ore);
		_iron.add(Blocks.iron_block);
		_iron.add(Blocks.iron_door);
		_iron.add(Blocks.iron_bars);
		_iron.add(Blocks.iron_trapdoor);
		_iron.add(Blocks.cauldron);
		
		_gold.add(Blocks.gold_ore);
		_gold.add(Blocks.gold_block);
		_gold.add(Blocks.quartz_ore);
		_gold.add(Blocks.quartz_block);
		_gold.add(Blocks.quartz_stairs);
		
		_redstone.add(Blocks.redstone_ore);
		_redstone.add(Blocks.redstone_block);
		
		_diamond.add(Blocks.diamond_block);
		_diamond.add(Blocks.diamond_ore);
		
		_obsidian.add(Blocks.obsidian);
		_obsidian.add(Blocks.enchanting_table);
		
		_luckHit.addStack(Items.blaze_rod, 10);
		_luckHit.addStack(Items.wheat, 20);
		_luckHit.addStack(Items.apple, 15);
		_luckHit.addStack(Items.rotten_flesh, 30);
		_luckHit.addStack(Items.bone, 20);
		_luckHit.addStack(Items.arrow, 20);
		_luckHit.addStack(Items.ender_pearl, 5);
		_luckHit.addStack(Items.leather, 20);
		_luckHit.addStack(Items.feather, 25);
		_luckHit.addStack(Items.blaze_powder, 15);
		_luckHit.addStack(Items.book, 10);
		_luckHit.addStack(Items.redstone, 10);
		_luckHit.addStack(Items.carrot, 15);
		_luckHit.addStack(Items.string, 15);
		_luckHit.addStack(Items.fermented_spider_eye, 15);
		_luckHit.addStack(Items.gunpowder, 10);
		_luckHit.addStack(Items.sugar,20);
		_luckHit.addStack(Items.skull, 2);
		_luckHit.addStack(Items.potato,15);
		_luckHit.addStack(Items.glowstone_dust, 5);
		_luckHit.addStack(Items.fire_charge, 20);
		_luckHit.addStack(Items.ghast_tear, 6);
		_luckHit.addStack(Items.coal, 20);
		_luckHit.addStack(Items.slime_ball, 10);
		_luckHit.addStack(Items.diamond, 3);
		_luckHit.addStack(Items.emerald, 1);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if(stack.getTagCompound() == null)
			stack.setTagCompound(new NBTTagCompound()); 
		if(!stack.getTagCompound().hasKey("miningLvl"))
			stack.getTagCompound().setInteger("miningLvl", 0);
		if(!stack.getTagCompound().hasKey("lvl"))
			stack.getTagCompound().setInteger("lvl", 1);
		if(!stack.getTagCompound().hasKey("xp"))
			stack.getTagCompound().setLong("xp", 0);
		if(!stack.getTagCompound().hasKey("repair"))
			stack.getTagCompound().setInteger("repair", 0);
		if(!stack.getTagCompound().hasKey("luck"))
			stack.getTagCompound().setInteger("luck", 0);
		if(!stack.getTagCompound().hasKey("luckChance"))
			stack.getTagCompound().setInteger("luckChance", 0);
		/*if(!stack.getTagCompound().hasKey("light"))
			stack.getTagCompound().setInteger("light", 0);*/
		if(!stack.getTagCompound().hasKey("haste"))
			stack.getTagCompound().setInteger("haste", 0);
		if(!stack.getTagCompound().hasKey("sharpness"))
			stack.getTagCompound().setInteger("sharpness", 0);
		if(!stack.getTagCompound().hasKey("smite"))
			stack.getTagCompound().setInteger("smite", 0);
		if(!stack.getTagCompound().hasKey("durability"))
			stack.getTagCompound().setInteger("surability", 0);
		if(!stack.getTagCompound().hasKey("unbreaking"))
			stack.getTagCompound().setInteger("unbreakling", 0);
		if(!stack.getTagCompound().hasKey("speed"))
			stack.getTagCompound().setInteger("speed", 0);
		if(!stack.getTagCompound().hasKey("flame"))
			stack.getTagCompound().setInteger("flame", 0);
		if(!stack.getTagCompound().hasKey("furnace"))
			stack.getTagCompound().setInteger("furnace", 0);
		/*if(!stack.getTagCompound().hasKey("silk"))
			stack.getTagCompound().setInteger("silk", 0);*/
		if(!stack.getTagCompound().hasKey("fidhy"))
			stack.getTagCompound().setInteger("fishy", 0);
		if(!stack.getTagCompound().hasKey("midas"))
			stack.getTagCompound().setInteger("midas", 0);
		if(!stack.getTagCompound().hasKey("beheading"))
			stack.getTagCompound().setInteger("beheading", 0);
		if(!stack.getTagCompound().hasKey("quicksilver"))
			stack.getTagCompound().setInteger("quicksilver", 0);
		if(!stack.getTagCompound().hasKey("repel"))
			stack.getTagCompound().setInteger("repel", 0);
		if(!stack.getTagCompound().hasKey("lifesteal"))
			stack.getTagCompound().setInteger("lifesteal", 0);
		if(!stack.getTagCompound().hasKey("feeding"))
			stack.getTagCompound().setInteger("feeding", 0);
		if(!stack.getTagCompound().hasKey("knockback"))
			stack.getTagCompound().setInteger("knockback", 0);
		if(!stack.getTagCompound().hasKey("slow"))
			stack.getTagCompound().setInteger("slow", 0);
		/*if(!stack.getTagCompound().hasKey("slowChance"))
			stack.getTagCompound().setInteger("slowChance", 0);*/
		if(!stack.getTagCompound().hasKey("milky"))
			stack.getTagCompound().setInteger("milky", 0);
		if(!stack.getTagCompound().hasKey("maxdmg"))
			stack.getTagCompound().setInteger("maxdmg", 350);
		if(!stack.getTagCompound().hasKey("poison"))
			stack.getTagCompound().setInteger("poison", 0);
		if(!stack.getTagCompound().hasKey("evil"))
			stack.getTagCompound().setInteger("evil", 0);
		if(!stack.getTagCompound().hasKey("frozen"))
			stack.getTagCompound().setInteger("frozen", 0);
		
		/*//int mlvl=stack.getTagCompound().getInteger("miningLevel");
		if(player.isSneaking())
		{
			stack.getTagCompound().setInteger("repair", 1);
			stack.getTagCompound().setInteger("lifesteal", 2);
			stack.getTagCompound().setInteger("frozen", 1);
			stack.getTagCompound().setInteger("maxdmg", 500);
			stack.getTagCompound().setInteger("knockback", 3);
			stack.getTagCompound().setInteger("luck", 2);
			stack.getTagCompound().setInteger("luckChance", 50);
			stack.getTagCompound().setInteger("evil", 1);
			stack.getTagCompound().setInteger("miningLevel", 4);
			stack.getTagCompound().setInteger("haste", 10);
			stack.getTagCompound().setInteger("beheading", 50);
		}*/

		return stack;
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World world,
			Block blockIn, BlockPos pos, EntityLivingBase player) {
		
		if(stack.getTagCompound() == null)
			stack.setTagCompound(new NBTTagCompound()); 
		if(!stack.getTagCompound().hasKey("miningLvl"))
			stack.getTagCompound().setInteger("miningLvl", 0);
		if(!stack.getTagCompound().hasKey("lvl"))
			stack.getTagCompound().setInteger("lvl", 1);
		if(!stack.getTagCompound().hasKey("xp"))
			stack.getTagCompound().setLong("xp", 0);
		long currXP=stack.getTagCompound().getLong("xp")+1; //curr XP in the current lvl+1 xp
		int currlevel=stack.getTagCompound().getInteger("lvl");
		long toNextLevel=this.getXPToLvl(currlevel+1);
		
		if(toNextLevel<=currXP) //pick has enough xp to go 1 level up
		{
			currlevel++;
			currXP=currXP-toNextLevel;
			this.onLevelUp(stack,(EntityPlayer)player);
		}
		stack.getTagCompound().setInteger("lvl", currlevel);
		stack.getTagCompound().setLong("xp", currXP);
		
		//handling speed bonus
		int speed=stack.getTagCompound().getInteger("speed");
		if(speed>0)
		{
			player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 200, speed, false, false));
		}
		
		//handle luck and luckChance;
		int luck=stack.getTagCompound().getInteger("luck");
		int luckc=stack.getTagCompound().getInteger("luckChance"); //luck chance
		if(luck>0)
		{
			Random rand=new Random(player.ticksExisted); //just some semi random seed to begin with
			int n=rand.nextInt(100);
			if(n<=luckc)
			{
				ItemStack prize=_luckHit.getRandomStack(rand);
				player.dropItem(prize.getItem(), 1);
			}
		}
		
		//handle unbreaking
		int unbreaking=stack.getTagCompound().getInteger("unbreaking");
		Random rand=new Random(player.getAge());
		int n=1+rand.nextInt(19);
		if(n>unbreaking)
			stack.damageItem(1, player);
		return true;
	}
	
	@Override
	public boolean onBlockStartBreak(ItemStack stack, BlockPos pos,
			EntityPlayer player) {
		IBlockState ibs= player.worldObj.getBlockState(pos);
		
		return !this.canHarvestBlock(ibs.getBlock(), stack);
	}
	
	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player) {
		
		if(stack.getTagCompound() == null)
			stack.setTagCompound(new NBTTagCompound()); 
		if(!stack.getTagCompound().hasKey("miningLvl"))
			stack.getTagCompound().setInteger("miningLvl", 0);
		if(!stack.getTagCompound().hasKey("lvl"))
			stack.getTagCompound().setInteger("lvl", 1);
		if(!stack.getTagCompound().hasKey("xp"))
			stack.getTagCompound().setLong("xp", 0);
		if(!stack.getTagCompound().hasKey("repair"))
			stack.getTagCompound().setInteger("repair", 0);
		if(!stack.getTagCompound().hasKey("luck"))
			stack.getTagCompound().setInteger("luck", 0);
		if(!stack.getTagCompound().hasKey("luckChance"))
			stack.getTagCompound().setInteger("luckChance", 0);
		/*if(!stack.getTagCompound().hasKey("light"))
			stack.getTagCompound().setInteger("light", 0);*/
		if(!stack.getTagCompound().hasKey("haste"))
			stack.getTagCompound().setInteger("haste", 0);
		if(!stack.getTagCompound().hasKey("sharpness"))
			stack.getTagCompound().setInteger("sharpness", 0);
		if(!stack.getTagCompound().hasKey("smite"))
			stack.getTagCompound().setInteger("smite", 0);
		if(!stack.getTagCompound().hasKey("durability"))
			stack.getTagCompound().setInteger("surability", 0);
		if(!stack.getTagCompound().hasKey("unbreaking"))
			stack.getTagCompound().setInteger("unbreakling", 0);
		if(!stack.getTagCompound().hasKey("speed"))
			stack.getTagCompound().setInteger("speed", 0);
		if(!stack.getTagCompound().hasKey("flame"))
			stack.getTagCompound().setInteger("flame", 0);
		if(!stack.getTagCompound().hasKey("furnace"))
			stack.getTagCompound().setInteger("furnace", 0);
		/*if(!stack.getTagCompound().hasKey("silk"))
			stack.getTagCompound().setInteger("silk", 0);*/
		if(!stack.getTagCompound().hasKey("fidhy"))
			stack.getTagCompound().setInteger("fishy", 0);
		if(!stack.getTagCompound().hasKey("midas"))
			stack.getTagCompound().setInteger("midas", 0);
		if(!stack.getTagCompound().hasKey("beheading"))
			stack.getTagCompound().setInteger("beheading", 0);
		if(!stack.getTagCompound().hasKey("quicksilver"))
			stack.getTagCompound().setInteger("quicksilver", 0);
		if(!stack.getTagCompound().hasKey("repel"))
			stack.getTagCompound().setInteger("repel", 0);
		if(!stack.getTagCompound().hasKey("lifesteal"))
			stack.getTagCompound().setInteger("lifesteal", 0);
		if(!stack.getTagCompound().hasKey("feeding"))
			stack.getTagCompound().setInteger("feeding", 0);
		if(!stack.getTagCompound().hasKey("knockback"))
			stack.getTagCompound().setInteger("knockback", 0);
		if(!stack.getTagCompound().hasKey("slow"))
			stack.getTagCompound().setInteger("slow", 0);
		/*if(!stack.getTagCompound().hasKey("slowChance"))
			stack.getTagCompound().setInteger("slowChance", 0);*/
		/*if(!stack.getTagCompound().hasKey("milky"))
			stack.getTagCompound().setInteger("milky", 0);*/
		if(!stack.getTagCompound().hasKey("maxdmg"))
			stack.getTagCompound().setInteger("maxdmg", 350);
		if(!stack.getTagCompound().hasKey("poison"))
			stack.getTagCompound().setInteger("poison", 0);
		if(!stack.getTagCompound().hasKey("evil"))
			stack.getTagCompound().setInteger("evil", 0);
		if(!stack.getTagCompound().hasKey("frozen"))
			stack.getTagCompound().setInteger("frozen", 0);
		
	}
	
	@Override
	public boolean canHarvestBlock(Block block, ItemStack stack) {
		if(stack.getTagCompound() == null)
			stack.setTagCompound(new NBTTagCompound()); 
		if(!stack.getTagCompound().hasKey("miningLvl"))
			stack.getTagCompound().setInteger("miningLvl", 0);
		int mlvl=stack.getTagCompound().getInteger("miningLevel"); //mining level
		
		//for the vanilla blocks
		if(mlvl>=0 && _gravel.contains(block))
			return true;
		if(mlvl>=1 && _stone.contains(block))
			return true;
		if(mlvl>=3 && _coal.contains(block))
			return true;
		if(mlvl>=5 && _iron.contains(block))
			return true;
		if(mlvl>=6 && _gold.contains(block))
			return true;
		if(mlvl>=7 && _redstone.contains(block))
			return true;
		if(mlvl>=8 && _diamond.contains(block))
			return true;
		if(mlvl>=9 && _obsidian.contains(block))
			return true;
		//for rabbit's blocks
		if(block instanceof IRabbitMiningLevel)
		{
			if(((IRabbitMiningLevel) block).getMiningLevel().getId() <= mlvl)
				return true;
		}
		return false;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn,
			List tooltip, boolean advanced) {
		if(stack.getTagCompound() == null)
			stack.setTagCompound(new NBTTagCompound()); 
		if(!stack.getTagCompound().hasKey("miningLvl"))
			stack.getTagCompound().setInteger("miningLvl", 0);
		int mlvl=stack.getTagCompound().getInteger("miningLevel");
		if(!stack.getTagCompound().hasKey("lvl"))
			stack.getTagCompound().setInteger("lvl", 1);
		int lvl=stack.getTagCompound().getInteger("lvl");
		
		tooltip.add("LEVEL: "+lvl);
		
		if(!stack.getTagCompound().hasKey("xp"))
			stack.getTagCompound().setLong("xp", 0);
		tooltip.add("XP: "+stack.getTagCompound().getLong("xp")+"/"+this.getXPToLvl(lvl+1));
		
		tooltip.add("Mining Level:" +MiningLevels.getFromId(mlvl)); //change it to a name!
		
		ToolAbilities[] ta=ToolAbilities.values();
		for(int i=0;i<ta.length;i++)
		{
			int alevel=stack.getTagCompound().getInteger(ta[i].getName());
			if(alevel>0)
			{
				tooltip.add(ta[i].getName().toUpperCase()+":"+alevel);
			}
		}
		
		if(!advanced)
		{
			int maxdmg=stack.getTagCompound().getInteger("maxdmg");
			tooltip.add("Durability : "+(maxdmg-stack.getItemDamage())+"/"+maxdmg);
		}
	}
	
	@Override
	public float getDigSpeed(ItemStack stack, IBlockState state) {
		if(stack.getTagCompound()!= null && stack.getTagCompound().hasKey("haste"))
			return stack.getTagCompound().getInteger("haste")+4.0f;
		return super.getDigSpeed(stack, state);
	}
	
	
	//gives you the amount of XP needed to move from lvl-1 to lvl
	public static long getXPToLvl(int lvl)
	{
		if(lvl<=1)
			return 0;
		return 120*(int)Math.pow(2.0,(double) lvl-2);
	}
	
	public void onLevelUp(ItemStack stack, EntityPlayer player) //every time this stack level up; add new ability
	{
		ToolAbilities[] ta=ToolAbilities.values();
		boolean found=false;
		
		int size=ta.length;
		Random rand=new Random(player.ticksExisted);
		
		int n=0;
		ToolAbilities a=ta[0];
		int level=0;
		
		if(this.isStackMaxLevel(stack)) //can't level up any ability
			return;
		
		while(!found) //as long as you can find an ability to level up
		{
			n=rand.nextInt(size);
			a=ta[n];
			level=stack.getTagCompound().getInteger(a.getName()); //get the level of the stack
			if(level<a.getMaxLevel())
			{
				found=true;
				if(a.getName().contentEquals("durability"))
				{
					int maxdmg=stack.getTagCompound().getInteger("maxdmg")+150;
					stack.getTagCompound().setInteger("maxdmg", maxdmg);
				}
			}
		}
		
		//level up ability ta[n]
		stack.getTagCompound().setInteger(a.getName(), level+1);
		player.addChatComponentMessage(new ChatComponentText("Your Flesh Pickaxe is advancing!"));
		player.addChatComponentMessage(new ChatComponentText("You got +1 level in"+a.getName()));
		
		//level up the mining level if possible
		int mininglvl=stack.getTagCompound().getInteger("miningLvl");
		MiningLevels[] ml=MiningLevels.values();
		if(mininglvl<ml[ml.length-1].getId()) //is the stack's mining level is not max
		{
			stack.getTagCompound().setInteger("miningLvl", mininglvl+1);
		}
		
	}
	
	public boolean isStackMaxLevel(ItemStack stack)
	{
		ToolAbilities[] ta=ToolAbilities.values();
		for(ToolAbilities a : ta)
		{
			int level=stack.getTagCompound().getInteger(a.getName()); //get the level of the stack
			if(level<a.getMaxLevel())
				return false;
		}
		return true;
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player,
			Entity entity) {
		
		if(!(entity instanceof EntityLivingBase)) //only living entities are affected
			return true;
		
		if(stack.getTagCompound() == null)
			stack.setTagCompound(new NBTTagCompound()); 
		if(!stack.getTagCompound().hasKey("miningLvl"))
			stack.getTagCompound().setInteger("miningLvl", 0);
		if(!stack.getTagCompound().hasKey("lvl"))
			stack.getTagCompound().setInteger("lvl", 1);
		if(!stack.getTagCompound().hasKey("xp"))
			stack.getTagCompound().setLong("xp", 0);
		
		//handling knockback
		int knock=stack.getTagCompound().getInteger("knockback");
		if(knock>0)
		{
			Vec3 v=player.getLookVec();
			v=v.normalize();
			entity.setVelocity(v.xCoord*knock, v.yCoord*knock+2, v.zCoord*knock);
		}
		
		//handling speed bonus
		int speed=stack.getTagCompound().getInteger("speed");
		if(speed>0)
		{
			player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 200, speed, false, false));
		}
		
		//handling flame
		int flame=stack.getTagCompound().getInteger("flame");
		if(flame>0)
		{
			entity.setFire(1+flame);
		}
		
		//handling slow
		int slow=stack.getTagCompound().getInteger("slow");
		if(slow>0 && entity instanceof EntityLivingBase)
		{
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, slow, false, true));
		}
		
		//handling poison
		int poison=stack.getTagCompound().getInteger("poison");
		if(poison>0 && entity instanceof EntityLivingBase)
		{
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.poison.id, 100, poison, false, true));
		}
		
		//handling evil (wither effect)
		int evil=stack.getTagCompound().getInteger("evil");
		if(evil>0 && entity instanceof EntityLivingBase)
		{
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.wither.id, 100, evil, false, true));
		}
		
		//handling sharpness
		/*if(!stack.getTagCompound().hasKey("sharpness"))
			stack.getTagCompound().setInteger("sharpness", 0);*/
		int sharpness= stack.getTagCompound().getInteger("sharpness");
		if(sharpness>0)
		{
			entity.attackEntityFrom(DamageSource.causePlayerDamage(player), sharpness);
		}
		
		//handling smite
		int smite=stack.getTagCompound().getInteger("smite");
		if(smite>0 && (entity instanceof EntityZombie || entity instanceof EntitySkeleton || entity instanceof EntityWitch))
		{
			entity.attackEntityFrom(DamageSource.causePlayerDamage(player), smite);
		}
		
		//handling repel
		int repel = stack.getTagCompound().getInteger("repel");
		if(repel>0 && (entity instanceof EntitySpider || entity instanceof EntitySilverfish || entity instanceof EntityBat))
		{
			entity.attackEntityFrom(DamageSource.causePlayerDamage(player), repel);
		}
		
		//handeling quickSilver
		int qs=stack.getTagCompound().getInteger("quickSilver");
		if(qs>0 && entity instanceof EntityWolf)
		{
			entity.attackEntityFrom(DamageSource.causePlayerDamage(player), qs);
		}
		
		//handling lifesteal
		int lifesteal=stack.getTagCompound().getInteger("lifesteal");
		if(lifesteal>0)
		{
			player.heal((float) (lifesteal/2.0));
			World world=player.getEntityWorld();
			world.spawnParticle(EnumParticleTypes.HEART,player.getPosition().getX()+1, player.getPosition().getY(), player.getPosition().getZ(), 0.76, 0.76, 0.55, 2);
			world.spawnParticle(EnumParticleTypes.HEART,player.getPosition().getX(), player.getPosition().getY()+1, player.getPosition().getZ()+1, 0.76, 0.76, 0.55, 2);
			world.spawnParticle(EnumParticleTypes.HEART,player.getPosition().getX()-1, player.getPosition().getY(), player.getPosition().getZ(), 0.76, 0.76, 0.55, 2);
			//world.spawnParticle(EnumParticleTypes.HEART,player.getPosition().getX(), player.getPosition().getY()-1, player.getPosition().getZ()-1, 0.76, 0.76, 0.55, 2);
			//world.spawnParticle(EnumParticleTypes.HEART,player.getPosition().getX()+1, player.getPosition().getY()-1, player.getPosition().getZ()-2, 0.76, 0.76, 0.55, 2);
		}
		
		//handling feeding
		int feeding=stack.getTagCompound().getInteger("feeding");
		if(feeding>0)
		{
			player.getFoodStats().addStats(feeding, 0.7f);
		}
		
		//handle luck and luckChance;
		int luck=stack.getTagCompound().getInteger("luck");
		int luckc=stack.getTagCompound().getInteger("luckChance"); //luck chance
		if(luck>0)
		{
			Random rand=new Random(player.ticksExisted); //just some semi random seed to begin with
			int n=rand.nextInt(100);
			if(n<=luckc)
			{
					ItemStack prize=_luckHit.getRandomStack(rand);
					player.dropItem(prize, true, false);
					//System.out.println("i've been here! :)");
					
			}
		}
		
		//handle midas
		int midas=stack.getTagCompound().getInteger("midas");
		if(midas>0)
		{
			Random rand=new Random(player.ticksExisted); //just some semi random seed to begin with
			int n=rand.nextInt(100);
			if(n<=midas)
			{
				player.dropItem(Items.gold_nugget, 1);
			}
		}
		
		//handle fishy
		int fishy=stack.getTagCompound().getInteger("fishy");
		if(fishy>0)
		{
			Random rand=new Random(player.ticksExisted); //just some semi random seed to begin with
			int n=rand.nextInt(100);
			if(n<=fishy)
			{
				player.dropItem(Items.fish, 1);
			}
		}
		
		//handle beheading
		int beheading=stack.getTagCompound().getInteger("beheading");
		if(beheading>0)
		{
			Random rand=new Random(player.ticksExisted); //just some semi random seed to begin with
			int n=rand.nextInt(100);
			if(n<=beheading)
			{
				ItemStack head;
				if(entity instanceof EntitySkeleton)
				{
					if(((EntitySkeleton)entity).getSkeletonType() != 1) //not wither skel
					{
						head=new ItemStack(Items.skull, 1, 0);
						player.dropItem(head, true, false);
					}
					else //wither skel
					{
						head=new ItemStack(Items.skull, 1, 1); 
						player.dropItem(head, true, false);
					}
				}
				else if(entity instanceof EntityZombie)
				{
					head=new ItemStack(Items.skull, 1, 2);
					player.dropItem(head, true, false);
				}
				else if(entity instanceof EntityCreeper)
				{
					head=new ItemStack(Items.skull, 1, 4);
					player.dropItem(head, true, false);
				}
				
				
			}
		}
		
		//handling frozen
		int frozen=stack.getTagCompound().getInteger("frozen");
		if(frozen>0)
		{
			Random rand=new Random(player.ticksExisted); //just some semi random seed to begin with
			int n=rand.nextInt(100);
			if(n<=2)
			{
				World world=player.getEntityWorld();
				if(!world.isRemote)
				{
					EntitySnowman g= new EntitySnowman(world);
					int x=(int)player.getPosition().getX();
					int y=(int)player.getPosition().getY();
					int z=(int)player.getPosition().getZ();
					Vec3 v=player.getLookVec();
					v=v.normalize();
					g.setPosition(x+v.xCoord, y, z+v.zCoord);
					world.spawnParticle(EnumParticleTypes.MOB_APPEARANCE,player.getPosition().getX()+1, player.getPosition().getY(), player.getPosition().getZ(), 0.76, 0.76, 0.55, 2);
					world.spawnParticle(EnumParticleTypes.MOB_APPEARANCE,player.getPosition().getX(), player.getPosition().getY()+1, player.getPosition().getZ()+1, 0.76, 0.76, 0.55, 2);
					world.spawnParticle(EnumParticleTypes.MOB_APPEARANCE,player.getPosition().getX()-1, player.getPosition().getY(), player.getPosition().getZ(), 0.76, 0.76, 0.55, 2);
					world.spawnEntityInWorld(g);
				}
			}
		}
		
		//handle xp
		long currXP=stack.getTagCompound().getLong("xp")+1; //curr XP in the current lvl+1 xp
		int currlevel=stack.getTagCompound().getInteger("lvl");
		long toNextLevel=this.getXPToLvl(currlevel+1);
		if(toNextLevel<=currXP) //pick has enough xp to go 1 level up
		{
			currlevel++;
			currXP=currXP-toNextLevel;
			this.onLevelUp(stack, player);
		}
		stack.getTagCompound().setInteger("lvl", currlevel);
		stack.getTagCompound().setLong("xp", currXP);
		//super.onLeftClickEntity(stack, player, entity);
		
		//handle unbreaking
		int unbreaking=stack.getTagCompound().getInteger("unbreaking");
		Random rand=new Random(player.getAge());
		int n=1+rand.nextInt(19);
		if(n>unbreaking)
			stack.damageItem(1, player);
		return false;
	}
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn,
			int itemSlot, boolean isSelected) {
		
		//handling the auto repair!
		
		if(stack.getTagCompound() != null && stack.getTagCompound().hasKey("repair")
				&& stack.getTagCompound().getInteger("repair")>0)
		{
			int repairlvl=stack.getTagCompound().getInteger("repair");
			Random rand=new Random(worldIn.getTotalWorldTime());
			int n=rand.nextInt(9200);
			if(n<=3)
			{
				stack.setItemDamage(stack.getItemDamage()-repairlvl);
			}
		}
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
	}
	
	@Override
	public int getMaxDamage(ItemStack stack) {
		if(stack.getTagCompound() == null)
			return 350;
		if(!stack.getTagCompound().hasKey("maxdmg"))
			stack.getTagCompound().setInteger("maxdmg", 350);
		return stack.getTagCompound().getInteger("maxdmg");
	}
}
