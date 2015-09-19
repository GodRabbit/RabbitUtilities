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
		GameRegistry.addShapelessRecipe(new ItemStack(RabbitItems.wooden_splinter, 4), Items.stick, Items.stick);
		
		GameRegistry.addShapedRecipe(new ItemStack(RabbitItems.flesh_eater_sword, 1),
				" S ",
				"  S",
				"T  ", 'S', RabbitItems.wooden_splinter, 'T', Items.stick);
		
		GameRegistry.addShapedRecipe(new ItemStack(RabbitItems.flesh_ingot), 
				"FFF",
				"FSF",
				"FFF", 'F', RabbitItems.flesh_item, 'S', Item.getItemFromBlock(Blocks.stone));
		
		GameRegistry.addShapedRecipe(new ItemStack(RabbitItems.flesh_pickaxe, 1), 
				"FFF",
				" S ",
				" S ", 'F', RabbitItems.flesh_ingot, 'S', Items.stick);
		
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
				"FFF",
				"FOF",
				"FFF", 'F', RabbitItems.decomposing_flesh, 'O', Item.getItemFromBlock(Blocks.iron_ore));
		
		GameRegistry.addShapedRecipe(new ItemStack(Items.gold_ingot, 2), 
				"FFF",
				"FOF",
				"FFF", 'F', RabbitItems.decomposing_flesh, 'O', Item.getItemFromBlock(Blocks.gold_ore));
		
		GameRegistry.addShapedRecipe(new ItemStack(Items.quartz, 5), 
				"FFF",
				"FOF",
				"FFF", 'F', RabbitItems.decomposing_flesh, 'O', Item.getItemFromBlock(Blocks.quartz_ore));
		
		GameRegistry.addShapedRecipe(new ItemStack(Items.diamond, 4), 
				"FFF",
				"FOF",
				"FFF", 'F', RabbitItems.decomposing_flesh, 'O', Item.getItemFromBlock(Blocks.diamond_ore));
		
		GameRegistry.addShapedRecipe(new ItemStack(Items.emerald, 3), 
				"FFF",
				"FOF",
				"FFF", 'F', RabbitItems.decomposing_flesh, 'O', Item.getItemFromBlock(Blocks.emerald_ore));
		
		GameRegistry.addShapedRecipe(new ItemStack(Items.coal, 7), 
				"FFF",
				"FOF",
				"FFF", 'F', RabbitItems.decomposing_flesh, 'O', Item.getItemFromBlock(Blocks.coal_ore));
		
		//more rexipes:
		GameRegistry.addShapedRecipe(new ItemStack(RabbitItems.brain_item, 1), 
				"FFF",
				"FBF",
				"FFF", 'F', RabbitItems.flesh_item, 'B', Item.getItemFromBlock(Blocks.diamond_block));
		
		GameRegistry.addShapedRecipe(new ItemStack(RabbitItems.human_seeds, 4), 
				"EBE",
				"MSM",
				"MIM", 'E', RabbitItems.eye_item, 'B', RabbitItems.brain_item, 'M', RabbitItems.muscle_item,
				'S', Items.skull, 'I', Items.bone);
		
		
		//smelting recipes:
		GameRegistry.addSmelting(RabbitItems.flesh_ingot, new ItemStack(RabbitItems.decomposing_flesh), 0.7F);
		
		
		
		//Enchanted books recipes
		ItemStack power=new ItemStack(Items.enchanted_book, 1);
		power.addEnchantment(Enchantment.power, 1);
		GameRegistry.addShapelessRecipe(power, Items.book, RabbitItems.muscle_item);
		
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
