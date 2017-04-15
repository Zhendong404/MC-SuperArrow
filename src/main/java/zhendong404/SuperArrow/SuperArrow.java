package zhendong404.SuperArrow;

import item.ItemDiracIngot;
import block.BlockDiracOre;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid="superarrow", name="SuperArrow", version="0.0.1")
public class SuperArrow {
	
	@SidedProxy
	private static ServerProxy proxy;
	
	public static BlockDiracOre blockDiracOre;
	public static ItemDiracIngot itemDiracIngot;
	
	public static final String MODID = "superarrow";
	public static final String DIRACORE = "diracOre";
	public static final String DIRACINGOT = "diracIngot";
	
	@EventHandler
	public void preLoad(FMLPreInitializationEvent event)
	{
		//add block Dirac Ore
		blockDiracOre = new BlockDiracOre();
		blockDiracOre.setUnlocalizedName(MODID + "." + DIRACORE);
		blockDiracOre.setRegistryName(MODID, DIRACORE);
		blockDiracOre.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		GameRegistry.register(blockDiracOre);
		
		//add item block of Dirac Ore
		GameRegistry.register(new ItemBlock(blockDiracOre).setRegistryName(MODID, DIRACORE));
		
		//add item Dirac Ingot
		itemDiracIngot = new ItemDiracIngot();
		itemDiracIngot.setUnlocalizedName(MODID + "." + DIRACINGOT);
		itemDiracIngot.setRegistryName(MODID, DIRACINGOT);
		itemDiracIngot.setCreativeTab(CreativeTabs.MATERIALS);
		GameRegistry.register(itemDiracIngot);
		
	}
	 
	@EventHandler
	public void load(FMLInitializationEvent event)
	{
	}
	 
	@EventHandler
	public void postLoad(FMLPostInitializationEvent event)
	{
	}
	
	public static class ServerProxy
	{
		public void loadModel()
		{
		}
	}
	
	public static class ClientProxy extends ServerProxy
	{
		@Override
		public void loadModel()
		{
			super.loadModel();
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(blockDiracOre), 0, new ModelResourceLocation(MODID + ":" + DIRACORE, "inventory"));
			ModelLoader.setCustomModelResourceLocation(itemDiracIngot, 0, new ModelResourceLocation(MODID + ":" + DIRACINGOT, "inventory"));
		}
	}

}
