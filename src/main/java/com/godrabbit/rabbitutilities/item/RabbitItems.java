package com.godrabbit.rabbitutilities.item;

import com.godrabbit.rabbitutilities.RabbitConst;
import com.godrabbit.rabbitutilities.RabbitUtilities;
import com.godrabbit.rabbitutilities.tool.FUBatItem;
import com.godrabbit.rabbitutilities.tool.FleshBoneAxe;
import com.godrabbit.rabbitutilities.tool.FleshBucket;
import com.godrabbit.rabbitutilities.tool.FleshEaterSword;
import com.godrabbit.rabbitutilities.tool.FleshPickaxe;
import com.godrabbit.rabbitutilities.tool.SpeculumonomiconItem;
import com.godrabbit.rabbitutilities.tool.TeleporterItem;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RabbitItems {
	
	public static Item flesh_eater_sword;
	public static Item flesh_item;
	public static Item wooden_splinter;
	public static Item flesh_ingot;
	public static Item flesh_pickaxe;
	public static Item fu_bat;
	public static Item flesh_bucket;
	public static Item lava_heart;
	public static Item muscle_item;
	public static Item eye_item;
	public static Item aikinite_dust;
	public static Item anapaite_dust;
	public static Item flesh_bone_axe;
	public static Item black_void_ingot;
	public static Item human_seeds;
	public static Item teleporter;
	public static Item speculumonomicon;
	public static Item mirror_shard;
	public static Item apatite_dust;
	public static Item decomposing_flesh;
	public static Item brain_item;
	
	public static void init()
	{
		//tools;
		flesh_eater_sword=new FleshEaterSword()
		.setUnlocalizedName("flesh_eater_sword")
		.setCreativeTab(RabbitUtilities.RabbitTab);
		
		flesh_pickaxe=new FleshPickaxe()
		.setUnlocalizedName("flesh_pickaxe")
		.setCreativeTab(RabbitUtilities.RabbitTab);
		
		fu_bat=new FUBatItem()
		.setUnlocalizedName("fu_bat")
		.setCreativeTab(RabbitUtilities.RabbitTab);
		
		flesh_bucket=new FleshBucket()
		.setUnlocalizedName("flesh_bucket")
		.setCreativeTab(RabbitUtilities.RabbitTab);
		
		flesh_bone_axe = new FleshBoneAxe()
		.setUnlocalizedName("flesh_bone_axe")
		.setCreativeTab(RabbitUtilities.RabbitTab);
		
		teleporter = new TeleporterItem()
		.setUnlocalizedName("teleporter")
		.setCreativeTab(RabbitUtilities.RabbitTab);
		
		speculumonomicon = new SpeculumonomiconItem()
		.setUnlocalizedName("speculumonomicon")
		.setCreativeTab(RabbitUtilities.RabbitTab);
		
		
		//items:
		flesh_item=new FleshItem()
		.setUnlocalizedName("flesh_item")
		.setCreativeTab(RabbitUtilities.RabbitTab);
		
		wooden_splinter=new WoodenSplinterItem()
		.setUnlocalizedName("wooden_splinter")
		.setCreativeTab(RabbitUtilities.RabbitTab);
		
		flesh_ingot=new FleshIngotItem()
		.setUnlocalizedName("flesh_ingot")
		.setCreativeTab(RabbitUtilities.RabbitTab);
		
		lava_heart=new LavaHeartItem()
		.setUnlocalizedName("lava_heart")
		.setCreativeTab(RabbitUtilities.RabbitTab);
		
		muscle_item=new MuscleItem()
		.setUnlocalizedName("muscle_item")
		.setCreativeTab(RabbitUtilities.RabbitTab);
		
		eye_item= new EyeItem()
		.setUnlocalizedName("eye_item")
		.setCreativeTab(RabbitUtilities.RabbitTab);
		
		aikinite_dust = new AikiniteDustItem()
		.setUnlocalizedName("aikinite_dust")
		.setCreativeTab(RabbitUtilities.RabbitTab);
		
		anapaite_dust = new AnapaiteDustItem()
		.setUnlocalizedName("anapaite_dust")
		.setCreativeTab(RabbitUtilities.RabbitTab);
		
		black_void_ingot=new BlackVoidIngot()
		.setUnlocalizedName("black_void_ingot")
		.setCreativeTab(RabbitUtilities.RabbitTab);
		
		human_seeds=new HumanSeedsItem()
		.setUnlocalizedName("human_seeds")
		.setCreativeTab(RabbitUtilities.RabbitTab);
		
		mirror_shard = new MirrorShardItem()
		.setUnlocalizedName("mirror_shard")
		.setCreativeTab(RabbitUtilities.RabbitTab);
		
		apatite_dust = new ApatiteDustItem()
		.setUnlocalizedName("apatite_dust")
		.setCreativeTab(RabbitUtilities.RabbitTab);
		
		decomposing_flesh = new DecomposingFleshItem()
		.setUnlocalizedName("decomposing_flesh")
		.setCreativeTab(RabbitUtilities.RabbitTab);
		
		brain_item = new BrainItem()
		.setUnlocalizedName("brain_item")
		.setCreativeTab(RabbitUtilities.RabbitTab);
		
	}
	
	public static void register()
	{
		GameRegistry.registerItem(flesh_eater_sword, flesh_eater_sword.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(flesh_item, flesh_item.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(wooden_splinter, wooden_splinter.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(flesh_ingot, flesh_ingot.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(flesh_pickaxe, flesh_pickaxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(fu_bat, fu_bat.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(flesh_bucket, flesh_bucket.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(lava_heart, lava_heart.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(muscle_item, muscle_item.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(eye_item, eye_item.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(aikinite_dust, aikinite_dust.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(anapaite_dust, anapaite_dust.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(flesh_bone_axe, flesh_bone_axe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(black_void_ingot, black_void_ingot.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(human_seeds, human_seeds.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(teleporter, teleporter.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(speculumonomicon, speculumonomicon.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(mirror_shard, mirror_shard.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(apatite_dust, apatite_dust.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(decomposing_flesh, decomposing_flesh.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(brain_item, brain_item.getUnlocalizedName().substring(5));
	}
	
	public static void registerRenders()
	{
		registerRender(flesh_eater_sword);
		registerRender(flesh_item);
		registerRender(wooden_splinter);
		registerRender(flesh_ingot);
		registerRender(flesh_pickaxe);
		registerRender(fu_bat);
		registerRender(flesh_bucket);
		registerRender(lava_heart);
		registerRender(muscle_item);
		registerRender(eye_item);
		registerRender(aikinite_dust);
		registerRender(anapaite_dust);
		registerRender(flesh_bone_axe);
		registerRender(black_void_ingot);
		registerRender(human_seeds);
		registerRender(teleporter);
		registerRender(speculumonomicon);
		registerRender(mirror_shard);
		registerRender(apatite_dust);
		registerRender(decomposing_flesh);
		registerRender(brain_item);
	}
	
	public static void registerRender(Item item)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0 , new ModelResourceLocation(RabbitConst.MODID+":"+item.getUnlocalizedName().substring(5), "inventory"));
	}

}
