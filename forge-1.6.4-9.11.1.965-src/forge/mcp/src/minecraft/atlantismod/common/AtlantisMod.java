package atlantismod.common;

import api.player.client.ClientPlayerAPI;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="AtlantisMod",name="Atlantis",version="1.1.1")
@NetworkMod(clientSideRequired=true)
public class AtlantisMod {

	@Instance(value="AtlantisMod")
	public static AtlantisMod instance;
	@SidedProxy(clientSide="atlantismod.common.client.ClientProxy",serverSide="atlantismod.common.CommonProxy")
    public static CommonProxy proxy;
	
	public AtlantisMod() {
		ClientPlayerAPI.register("AtlantisMod", AtlantisClientPlayerBase.class);
	}
	
	public static CreativeTabs tabAtlantis;
	
	public static final int dimensionID = 22;

	public static Block portalAtlantisBlock;

	public static Block deepSandBlock, rottenPlanksBlock;

	public static Item pearl, atlantisWand;
	
	public static Block blockCoral;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		portalAtlantisBlock = (BlockAtlantisPortal)(new BlockAtlantisPortal(2222)).setUnlocalizedName("portalAtlantisBlock").setTextureName("portal");
		atlantisWand = (ItemAtlantisWand)(new ItemAtlantisWand(2223)).setUnlocalizedName("atlantisWand").setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:portal_wand").setMaxStackSize(1);

		deepSandBlock = (new BlockSand(2224)).setHardness(0.5F).setStepSound(Block.soundSandFootstep).setUnlocalizedName("deepSand").setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:deep_sand");
		rottenPlanksBlock = (new BlockRottenPlanks(2225)).setHardness(1.5F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("rottenPlanks").setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:rotten_planks");
		
		pearl = (new Item(2226)).setUnlocalizedName("pearl").setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:pearl");
		
		tabAtlantis = new CreativeTabs("tabAtlantis") {
			public ItemStack getIconItemStack() {
				return new ItemStack(AtlantisMod.pearl.itemID, 1, 0);
			}
		};
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderers();
		GameRegistry.registerWorldGenerator(new WorldGenAtlantis());
		DimensionManager.registerProviderType(AtlantisMod.dimensionID, WorldProviderAtlantis.class, false);
		DimensionManager.registerDimension(AtlantisMod.dimensionID, AtlantisMod.dimensionID);

		LanguageRegistry.addName(portalAtlantisBlock,"Atlantis Portal Block");
		GameRegistry.registerBlock(portalAtlantisBlock,"portalAtlantisBlock");

		GameRegistry.registerItem(pearl, "pearl");
		LanguageRegistry.addName(pearl, "Pearl");

		GameRegistry.registerBlock(rottenPlanksBlock,"rottenPlanksBlock");
		LanguageRegistry.addName(rottenPlanksBlock, "Rotten Planks");
		MinecraftForge.setBlockHarvestLevel(rottenPlanksBlock, "axe", 1);
		
		GameRegistry.registerBlock(deepSandBlock,"deepSandBlock");
		LanguageRegistry.addName(deepSandBlock,"Deep Sand");
		MinecraftForge.setBlockHarvestLevel(deepSandBlock, "shovel", 1);
		
		LanguageRegistry.addName(atlantisWand,"Atlantis Teleporter");
		GameRegistry.registerItem(atlantisWand,"atlantisWand");
		
		GameRegistry.addRecipe(new ItemStack(AtlantisMod.atlantisWand)," xx"," sx","s  ",'x',Item.diamond,'s',Item.stick);

		LanguageRegistry.instance().addStringLocalization("itemGroup.tabAtlantis", "en_US", "Atlantis Mod");
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {}
	
}
