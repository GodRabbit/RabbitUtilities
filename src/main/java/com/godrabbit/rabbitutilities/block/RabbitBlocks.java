package com.godrabbit.rabbitutilities.block;

import com.godrabbit.rabbitutilities.RabbitConst;
import com.godrabbit.rabbitutilities.RabbitUtilities;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RabbitBlocks {
	
	public static Block aikimite_ore;
	public static Block anapaite_ore;
	public static Block flesh_obsidian;
	public static Block flesh_block;
	public static Block apatite_ore;
	public static Block human_sponge;
	
	public static void init()
	{
		aikimite_ore=new AikimiteOreBlock()
		.setUnlocalizedName("aikimite_ore")
		.setCreativeTab(RabbitUtilities.RabbitTab);
		
		anapaite_ore=new AnapaiteOreBlock()
		.setUnlocalizedName("anapaite_ore")
		.setCreativeTab(RabbitUtilities.RabbitTab);
		
		flesh_obsidian = new FleshObsidianBlock()
		.setUnlocalizedName("flesh_obsidian")
		.setCreativeTab(RabbitUtilities.RabbitTab);
		
		flesh_block=new FleshBlock()
		.setUnlocalizedName("flesh_block")
		.setCreativeTab(RabbitUtilities.RabbitTab);
		
		apatite_ore = new ApatiteOreBlock()
		.setUnlocalizedName("apatite_ore")
		.setCreativeTab(RabbitUtilities.RabbitTab);
		
		human_sponge = new HumanSpongeBlock()
		.setUnlocalizedName("human_sponge")
		.setCreativeTab(RabbitUtilities.RabbitTab);
		
	}
	
	public static void register()
	{
		GameRegistry.registerBlock(aikimite_ore,  aikimite_ore.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(anapaite_ore, anapaite_ore.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(flesh_obsidian, flesh_obsidian.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(flesh_block, flesh_block.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(apatite_ore, apatite_ore.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(human_sponge, human_sponge.getUnlocalizedName().substring(5));
	}
	
	public static void registerRenders()
	{
		registerRender(aikimite_ore);
		registerRender(anapaite_ore);
		registerRender(flesh_obsidian);
		registerRender(flesh_block);
		registerRender(apatite_ore);
		registerRender(human_sponge);
	}
	
	public static void registerRender(Block b)
	{
		Item item = Item.getItemFromBlock(b);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0 , new ModelResourceLocation(RabbitConst.MODID+":"+item.getUnlocalizedName().substring(5), "inventory"));
	}

}
