package com.godrabbit.rabbitutilities;

import com.godrabbit.rabbitutilities.block.RabbitBlocks;
import com.godrabbit.rabbitutilities.client.model.ModelLivingFlesh;
import com.godrabbit.rabbitutilities.entities.EntityLivingFlesh;
import com.godrabbit.rabbitutilities.entities.EntityMirror;
import com.godrabbit.rabbitutilities.item.RabbitItems;
import com.godrabbit.rabbitutilities.proxy.CommonProxy;
import com.godrabbit.rabbitutilities.renderer.RendererLivingFlesh;

import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.NetworkSystem;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod(modid = RabbitConst.MODID, name= RabbitConst.MODNAME, version =  RabbitConst.VERSION)
public class RabbitUtilities {
	
	public static final RabbitTab RabbitTab=new RabbitTab("tabRabbit");
	
	@Instance(RabbitConst.MODID)
	public static RabbitUtilities instance;
	
	//copied from CoolAlias tutorial on backpacks;
	/** This is used to keep track of GUIs that we make*/
	private static int modGuiIndex = 0;

	/** Set our custom inventory Gui index to the next available Gui index */
	public static final int GUI_ITEM_INV = modGuiIndex++;
	
	public RabbitUtilities()
	{
		instance=this;
	}
	
	@SidedProxy(clientSide = RabbitConst.CLIENT_PROXY_CLASS, serverSide = RabbitConst.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		//registering
		RabbitBlocks.init();
		RabbitBlocks.register();
		RabbitItems.init();
		RabbitItems.register();
		
		
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event)
	{
		//proxy goes here:
		proxy.registerRenders();
		
		// recipes
		GameRegistry.addShapelessRecipe(new ItemStack(RabbitItems.wooden_splinter, 2), Items.stick);
		
		GameRegistry.addShapedRecipe(new ItemStack(RabbitItems.flesh_eater_sword, 1),
				" S ",
				"  S",
				" T ", 'S', Items.arrow, 'T', RabbitItems.wooden_splinter);
		
		GameRegistry.addShapedRecipe(new ItemStack(RabbitItems.flesh_ingot), 
				" F ",
				"FSF",
				" F ", 'F', RabbitItems.flesh_item, 'S', Item.getItemFromBlock(Blocks.stone));
		
		GameRegistry.addShapedRecipe(new ItemStack(RabbitItems.flesh_pickaxe, 1), 
				"FFF",
				" S ",
				" S ", 'F', RabbitItems.flesh_ingot, 'S', RabbitItems.wooden_splinter);
		
		GameRegistry.addShapelessRecipe(new ItemStack(Item.getItemFromBlock(RabbitBlocks.flesh_block), 1), RabbitItems.flesh_ingot,
				RabbitItems.flesh_ingot, RabbitItems.flesh_ingot, RabbitItems.flesh_ingot, 
				RabbitItems.flesh_ingot, RabbitItems.flesh_ingot, RabbitItems.flesh_ingot,
				RabbitItems.flesh_ingot, RabbitItems.flesh_ingot);
		
		GameRegistry.addShapedRecipe(new ItemStack(Item.getItemFromBlock(RabbitBlocks.flesh_obsidian), 1), 
				"OOO",
				"OFO",
				"OOO", 'O', Blocks.obsidian, 'F', RabbitBlocks.flesh_block);
		
		GameRegistry.addShapelessRecipe(new ItemStack(RabbitItems.flesh_ingot, 9), RabbitBlocks.flesh_block);
		
		GameRegistry.addShapelessRecipe(new ItemStack(Items.lava_bucket),
				Items.bucket, RabbitItems.lava_heart);
		
		GameRegistry.addShapedRecipe(new ItemStack(RabbitItems.muscle_item), 
				"  F",
				"  F",
				"FFF", 'F', RabbitItems.flesh_item);
		
		GameRegistry.addShapedRecipe(new ItemStack(RabbitItems.speculumonomicon), 
				"AQA",
				"QBQ",
				"AQA", 'A', RabbitItems.anapaite_dust, 'B', Items.book, 'Q', Items.quartz);
		
		GameRegistry.addShapedRecipe(new ItemStack(RabbitItems.eye_item, 1),
				" F ",
				"F F",
				" F ", 'F', RabbitItems.flesh_item);
		
		//ore doubling recipes:
		GameRegistry.addShapedRecipe(new ItemStack(Items.iron_ingot, 2), 
				" F ",
				"FOF",
				" F ", 'F', RabbitItems.decomposing_flesh, 'O', Item.getItemFromBlock(Blocks.iron_ore));
		
		GameRegistry.addShapedRecipe(new ItemStack(Items.gold_ingot, 2), 
				" F ",
				"FOF",
				" F ", 'F', RabbitItems.decomposing_flesh, 'O', Item.getItemFromBlock(Blocks.gold_ore));
		
		GameRegistry.addShapedRecipe(new ItemStack(Items.quartz, 5), 
				" F ",
				"FOF",
				" F ", 'F', RabbitItems.decomposing_flesh, 'O', Item.getItemFromBlock(Blocks.quartz_ore));
		
		GameRegistry.addShapedRecipe(new ItemStack(Items.diamond, 4), 
				" F ",
				"FOF",
				" F ", 'F', RabbitItems.decomposing_flesh, 'O', Item.getItemFromBlock(Blocks.diamond_ore));
		
		GameRegistry.addShapedRecipe(new ItemStack(Items.emerald, 3), 
				" F ",
				"FOF",
				" F ", 'F', RabbitItems.decomposing_flesh, 'O', Item.getItemFromBlock(Blocks.emerald_ore));
		
		GameRegistry.addShapedRecipe(new ItemStack(Items.coal, 7), 
				" F ",
				"FOF",
				" F ", 'F', RabbitItems.decomposing_flesh, 'O', Item.getItemFromBlock(Blocks.coal_ore));
		
		//more recipes:
		GameRegistry.addShapedRecipe(new ItemStack(RabbitItems.brain_item, 1), 
				"FFF",
				"FBF",
				"FFF", 'F', RabbitItems.flesh_item, 'B', Items.diamond);
		
		GameRegistry.addShapedRecipe(new ItemStack(RabbitItems.human_seeds, 4), 
				"EBE",
				"MSM",
				"MIM", 'E', RabbitItems.eye_item, 'B', RabbitItems.brain_item, 'M', RabbitItems.muscle_item,
				'S', Items.skull, 'I', Items.bone);
		
		GameRegistry.addShapedRecipe(new ItemStack(RabbitItems.teleporter), 
				"MDM",
				"AEA",
				"MDM", 'M', RabbitItems.mirror_shard, 'D', Items.diamond, 'A', RabbitItems.anapaite_dust,
				'E', RabbitItems.eye_item);
		
		GameRegistry.addShapedRecipe(new ItemStack(RabbitItems.id_sword, 32), 
				" M ",
				" M ",
				"PSP",'M', RabbitItems.mirror_shard, 'P', Items.ender_pearl, 'S', RabbitItems.wooden_splinter );
		
		GameRegistry.addShapedRecipe(new ItemStack(RabbitItems.flesh_bucket), 
				"   ",
				"F F",
				" F ", 'F', RabbitItems.flesh_ingot);
		
		GameRegistry.addShapedRecipe(new ItemStack(RabbitItems.flesh_bucket), 
				"F F",
				" F ",
				"   ", 'F', RabbitItems.flesh_ingot);
		
		GameRegistry.addShapedRecipe(new ItemStack(RabbitItems.feet_item), 
				"   ",
				"   ",
				"FFF", 'F', RabbitItems.flesh_item);
		
		GameRegistry.addShapedRecipe(new ItemStack(RabbitItems.lungs_item), 
				"F F",
				"F F",
				"F F", 'F', RabbitItems.flesh_item);
		
		
		GameRegistry.addShapelessRecipe(new ItemStack(Items.slime_ball), 
				Items.egg, RabbitItems.decomposing_flesh);
		
		GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 4, 15), 
				Items.bone, RabbitItems.decomposing_flesh);
		
		GameRegistry.addShapelessRecipe(new ItemStack(Items.blaze_powder, 4), 
				Items.blaze_rod, RabbitItems.decomposing_flesh);
		
		GameRegistry.addShapelessRecipe(new ItemStack(RabbitItems.flour_item), 
				Items.wheat, RabbitItems.decomposing_flesh);
		
		GameRegistry.addShapelessRecipe(new ItemStack(Item.getItemFromBlock(Blocks.sand), 4), 
				Item.getItemFromBlock(Blocks.cobblestone), RabbitItems.decomposing_flesh);
		
		GameRegistry.addShapelessRecipe(new ItemStack(RabbitItems.nether_flour), Items.nether_wart,
				Items.blaze_powder, RabbitItems.decomposing_flesh);
		
		//smelting recipes:
		GameRegistry.addSmelting(RabbitItems.flesh_ingot, new ItemStack(RabbitItems.decomposing_flesh), 1.7F);
		
		GameRegistry.addSmelting(RabbitItems.flour_item, new ItemStack(Items.bread), 1.7F);
		
		GameRegistry.addSmelting(RabbitItems.nether_flour, new ItemStack(RabbitItems.nether_bread), 5.4F);
		
		//Enchanted books recipes
		ItemStack power=new ItemStack(Items.enchanted_book, 1);
		power.addEnchantment(Enchantment.power, 1);
		GameRegistry.addShapelessRecipe(power, Items.book, RabbitItems.muscle_item);
		
		ItemStack resp=new ItemStack(Items.enchanted_book, 1);
		resp.addEnchantment(Enchantment.respiration, 1);
		GameRegistry.addShapelessRecipe(resp, Items.book, RabbitItems.lungs_item);
		
		ItemStack infinity=new ItemStack(Items.enchanted_book, 1);
		infinity.addEnchantment(Enchantment.infinity, 1);
		GameRegistry.addShapelessRecipe(infinity, Items.book, RabbitItems.brain_item);
		
		ItemStack feather=new ItemStack(Items.enchanted_book, 1);
		feather.addEnchantment(Enchantment.featherFalling, 1);
		GameRegistry.addShapedRecipe(feather, 
				"   ",
				"FBL",
				"   ", 'F', Items.feather, 'B', Items.book, 'L', RabbitItems.feet_item);
		
		ItemStack strider=new ItemStack(Items.enchanted_book, 1);
		strider.addEnchantment(Enchantment.depthStrider, 1);
		GameRegistry.addShapedRecipe(strider, 
				"   ",
				"WBL",
				"   ", 'W', Items.water_bucket, 'B', Items.book, 'L', RabbitItems.feet_item);
		
		//special recipes:
		
		//entities
		int n=EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(EntityLivingFlesh.class, "Living Flesh", n);
		EntityRegistry.registerModEntity(EntityLivingFlesh.class, "Living Flesh", n, RabbitUtilities.instance, 32, 50, false);
		
		int m=EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(EntityMirror.class,"Mirror", m);
		EntityRegistry.registerModEntity(EntityMirror.class, "Mirror", m, RabbitUtilities.instance, 32, 50, false);
		
		// register CommonProxy as our GuiHandler
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new CommonProxy());
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		//synergies with other mods.
	}

}
