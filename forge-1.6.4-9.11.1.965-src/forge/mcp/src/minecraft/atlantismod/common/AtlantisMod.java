package atlantismod.common;

import api.player.client.ClientPlayerAPI;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.EnumHelper;
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

/**
 * 
 * Atlantis Mod
 * 
 * @author Graeme22
 * @author Lepreckaun
 * 
 * */

/**
 * "The Deep"
 * Squidman
 * Giant Squid
 * Angler Fish
 * Whale
 * Kraken
 * Eels
 * Shark
 * Sharkman
 * Many colors of fish
 * Mermaid
 * Coral (has many subtypes of different colors)
 * Pearl Ore
 * Block of Pearl
 * Trident (can be thrown by right-clicking)
 * Shipwreck
 * Atlantis City
 * Coral Reef
 * Bubble 2 x 2 x 2
 * Bubble 3 x 3 x 3
 * Grotto
 * Atlantean Ruins
 * Sunken Submarine
 * Glowstone
 * Deep Ocean
 * King of Atlantis
 * Neptune
 * 
 * */

@Mod(modid="AtlantisMod",name="Atlantis",version="1.1.1")
@NetworkMod(clientSideRequired=true)
public class AtlantisMod {

	@Instance(value="AtlantisMod")
	public static AtlantisMod instance;
	@SidedProxy(clientSide="atlantismod.common.client.ClientProxy",serverSide="atlantismod.common.CommonProxy")
    public static CommonProxy proxy;
	
	public static final int dimensionID = 22;
	
	private static EnumArmorMaterial DivingSuit = EnumHelper.addArmorMaterial("DIVINGARMOR",15,new int[]{1,1,0,0},0);
	private static EnumToolMaterial PearlTool = EnumHelper.addToolMaterial("PEARLTOOL",3,1111,7.0F,2.5F,20);
	
	public static CreativeTabs tabAtlantis;

	public static Block portalAtlantisBlock;

	public static Block deepSandBlock, blockRottenPlanks;

	public static Item pearl, atlantisWand, trident;
	
	public static Block orePearl, blockPearl;
	
	public static ItemArmor divingHelmet, scubaSuit, oxygenTank, flippers;
	
	public static Block blockCoralOrange, blockCoralGreen, blockCoralRed, blockCoralPurple, blockCoralYellow;
	
	public AtlantisMod() {
		ClientPlayerAPI.register("AtlantisMod",AtlantisClientPlayerBase.class);
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		tabAtlantis = new CreativeTabs("tabAtlantis") {
			public ItemStack getIconItemStack() {
				return new ItemStack(AtlantisMod.pearl.itemID, 1, 0);
			}
		};
		
		portalAtlantisBlock = (BlockAtlantisPortal)(new BlockAtlantisPortal(2222)).setUnlocalizedName("portalAtlantisBlock").setTextureName("portal");
		
		deepSandBlock = (new BlockSand(2223)).setHardness(0.5F).setStepSound(Block.soundSandFootstep).setUnlocalizedName("deepSand").setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:deep_sand");
		blockRottenPlanks = (new BlockRottenPlanks(2224)).setHardness(1.5F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("rottenPlanks").setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:rotten_planks");

		pearl = (new Item(2225)).setUnlocalizedName("pearl").setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:pearl");
		atlantisWand = (ItemAtlantisWand)(new ItemAtlantisWand(2226)).setUnlocalizedName("atlantisWand").setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:portal_wand").setMaxStackSize(1);
		//trident = (new ItemTrident());
		
		//orePearl
		//blockPearl
		
		divingHelmet = (ItemDivingArmor)(new ItemDivingArmor(2227,AtlantisMod.DivingSuit,0,0)).setCreativeTab(AtlantisMod.tabAtlantis).setMaxStackSize(1).setUnlocalizedName("divingHelmet").setTextureName("atlantismod:diving_helmet");
		scubaSuit = (ItemDivingArmor)(new ItemDivingArmor(2228,AtlantisMod.DivingSuit,0,1)).setCreativeTab(AtlantisMod.tabAtlantis).setMaxStackSize(1).setUnlocalizedName("scubaSuit").setTextureName("atlantismod:scuba_suit");
		oxygenTank = (ItemDivingArmor)(new ItemDivingArmor(2229,AtlantisMod.DivingSuit,0,2)).setMaxDamage(10000).setCreativeTab(AtlantisMod.tabAtlantis).setMaxStackSize(1).setUnlocalizedName("oxygenTank").setTextureName("atlantismod:oxygen_tank");
		flippers = (ItemDivingArmor)(new ItemDivingArmor(2230,AtlantisMod.DivingSuit,0,3)).setCreativeTab(AtlantisMod.tabAtlantis).setMaxStackSize(1).setUnlocalizedName("flippers").setTextureName("atlantismod:flippers");
		
		blockCoralOrange = (new BlockCoral(2231)).setHardness(0.1F).setResistance(0.1F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("blockCoralOrange").setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:orange_coral");
		blockCoralGreen = (new BlockCoral(2232)).setHardness(0.1F).setResistance(0.1F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("blockCoralGreen").setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:green_coral");
		blockCoralRed = (new BlockCoral(2233)).setHardness(0.1F).setResistance(0.1F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("blockCoralRed").setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:red_coral");
		blockCoralPurple = (new BlockCoral(2234)).setHardness(0.1F).setResistance(0.1F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("blockCoralPurple").setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:purple_coral");
		blockCoralYellow = (new BlockCoral(2235)).setHardness(0.1F).setResistance(0.1F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("blockCoralYellow").setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:yellow_coral");
		
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

		GameRegistry.registerBlock(blockRottenPlanks,"blockRottenPlanks");
		LanguageRegistry.addName(blockRottenPlanks, "Rotten Planks");
		MinecraftForge.setBlockHarvestLevel(blockRottenPlanks, "axe", 1);
		
		GameRegistry.registerBlock(deepSandBlock,"deepSandBlock");
		LanguageRegistry.addName(deepSandBlock,"Deep Sand");
		MinecraftForge.setBlockHarvestLevel(deepSandBlock, "shovel", 1);
		
		LanguageRegistry.addName(atlantisWand,"Atlantis Teleporter");
		GameRegistry.registerItem(atlantisWand,"atlantisWand");
		
		GameRegistry.registerBlock(blockCoralOrange,"blockCoralOrange");
		LanguageRegistry.addName(blockCoralOrange,"Orange Coral");
		GameRegistry.registerBlock(blockCoralGreen,"blockCoralGreen");
		LanguageRegistry.addName(blockCoralGreen,"Green Coral");
		GameRegistry.registerBlock(blockCoralRed,"blockCoralRed");
		LanguageRegistry.addName(blockCoralRed,"Red Coral");
		GameRegistry.registerBlock(blockCoralPurple,"blockCoralPurple");
		LanguageRegistry.addName(blockCoralPurple,"Purple Coral");
		GameRegistry.registerBlock(blockCoralYellow,"blockCoralYellow");
		LanguageRegistry.addName(blockCoralYellow,"Yellow Coral");
		
		GameRegistry.addRecipe(new ItemStack(AtlantisMod.atlantisWand)," xx"," sx","s  ",'x',Item.diamond,'s',Item.stick);

		LanguageRegistry.instance().addStringLocalization("itemGroup.tabAtlantis","en_US","Atlantis Mod");
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {}
	
}
