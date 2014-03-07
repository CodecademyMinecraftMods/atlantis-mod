package atlantismod.common;

import api.player.client.ClientPlayerAPI;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.BlockOreStorage;
import net.minecraft.block.BlockSand;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
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
 * Pearl Ore
 * Block of Pearl
 * Trident (can be thrown by right-clicking)
 * Atlantis City
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
	private static EnumToolMaterial Trident = EnumHelper.addToolMaterial("TRIDENTTOOL",1,1000,1.0F,5.0F,8);
	
	public static CreativeTabs tabAtlantis;

	public static Block portalAtlantisBlock;

	public static Block deepSandBlock, blockRottenPlanks;

	public static Item pearl, atlantisWand, trident;
	
	public static Item swordPearl, pickaxePearl, shovelPearl, hoePearl, axePearl;
	
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
		atlantisWand = (ItemAtlantisWand)(new ItemAtlantisWand(2226)).setUnlocalizedName("atlantisWand").setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:portal_wand");
		trident = (new ItemTrident(2238,AtlantisMod.Trident)).setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:trident").setUnlocalizedName("trident").setMaxStackSize(1);
		
		orePearl = (new BlockOre(2236)).setHardness(3.0F).setResistance(5.0F).setUnlocalizedName("orePearl").setTextureName("atlantismod:pearl_ore").setCreativeTab(AtlantisMod.tabAtlantis);
		blockPearl = (new BlockOrePearl(2237)).setHardness(3.0F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("blockPearl").setTextureName("atlantismod:pearl_block").setCreativeTab(AtlantisMod.tabAtlantis);
		
		divingHelmet = (ItemDivingArmor)(new ItemDivingArmor(2227,AtlantisMod.DivingSuit,0,0)).setCreativeTab(AtlantisMod.tabAtlantis).setMaxStackSize(1).setUnlocalizedName("divingHelmet").setTextureName("atlantismod:diving_helmet");
		scubaSuit = (ItemDivingArmor)(new ItemDivingArmor(2228,AtlantisMod.DivingSuit,0,1)).setCreativeTab(AtlantisMod.tabAtlantis).setMaxStackSize(1).setUnlocalizedName("scubaSuit").setTextureName("atlantismod:scuba_suit");
		oxygenTank = (ItemDivingArmor)(new ItemDivingArmor(2229,AtlantisMod.DivingSuit,0,2)).setMaxDamage(10000).setCreativeTab(AtlantisMod.tabAtlantis).setMaxStackSize(1).setUnlocalizedName("oxygenTank").setTextureName("atlantismod:oxygen_tank");
		flippers = (ItemDivingArmor)(new ItemDivingArmor(2230,AtlantisMod.DivingSuit,0,3)).setCreativeTab(AtlantisMod.tabAtlantis).setMaxStackSize(1).setUnlocalizedName("flippers").setTextureName("atlantismod:flippers");
		
		blockCoralOrange = (new BlockCoral(2231)).setHardness(0.1F).setResistance(0.1F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("blockCoralOrange").setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:orange_coral");
		blockCoralGreen = (new BlockCoral(2232)).setHardness(0.1F).setResistance(0.1F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("blockCoralGreen").setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:green_coral");
		blockCoralRed = (new BlockCoral(2233)).setHardness(0.1F).setResistance(0.1F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("blockCoralRed").setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:red_coral");
		blockCoralPurple = (new BlockCoral(2234)).setHardness(0.1F).setResistance(0.1F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("blockCoralPurple").setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:purple_coral");
		blockCoralYellow = (new BlockCoral(2235)).setHardness(0.1F).setResistance(0.1F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("blockCoralYellow").setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:yellow_coral");
		
		axePearl = (new ItemAxe(2239,AtlantisMod.PearlTool)).setUnlocalizedName("axePearl").setTextureName("atlantismod:pearl_axe").setCreativeTab(AtlantisMod.tabAtlantis);
		pickaxePearl = (new ItemPickaxe(2240,AtlantisMod.PearlTool)).setUnlocalizedName("pickaxePearl").setTextureName("atlantismod:pearl_pickaxe").setCreativeTab(AtlantisMod.tabAtlantis);
		hoePearl = (new ItemHoe(2241,AtlantisMod.PearlTool)).setUnlocalizedName("hoePearl").setTextureName("atlantismod:pearl_hoe").setCreativeTab(AtlantisMod.tabAtlantis);
		shovelPearl = (new ItemSpade(2242,AtlantisMod.PearlTool)).setUnlocalizedName("shovelPearl").setTextureName("atlantismod:pearl_shovel").setCreativeTab(AtlantisMod.tabAtlantis);
		swordPearl = (new ItemSword(2243,AtlantisMod.PearlTool)).setUnlocalizedName("swordPearl").setTextureName("atlantismod:pearl_sword").setCreativeTab(AtlantisMod.tabAtlantis);
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderers();
		GameRegistry.registerWorldGenerator(new WorldGenAtlantis());
		DimensionManager.registerProviderType(AtlantisMod.dimensionID, WorldProviderAtlantis.class, false);
		DimensionManager.registerDimension(AtlantisMod.dimensionID, AtlantisMod.dimensionID);

		LanguageRegistry.addName(portalAtlantisBlock,"Atlantis Portal Block");
		GameRegistry.registerBlock(portalAtlantisBlock,"portalAtlantisBlock");

		LanguageRegistry.addName(pearl, "Pearl");
		GameRegistry.registerItem(pearl, "pearl");
		
		LanguageRegistry.addName(trident, "Trident");
		GameRegistry.registerItem(trident, "trident");

		GameRegistry.registerBlock(blockRottenPlanks,"blockRottenPlanks");
		LanguageRegistry.addName(blockRottenPlanks, "Rotten Planks");
		MinecraftForge.setBlockHarvestLevel(blockRottenPlanks, "axe", 1);
		
		GameRegistry.registerBlock(deepSandBlock,"deepSandBlock");
		LanguageRegistry.addName(deepSandBlock,"Deep Sand");
		MinecraftForge.setBlockHarvestLevel(deepSandBlock, "shovel", 1);
		
		LanguageRegistry.addName(atlantisWand,"Atlantis Teleporter");
		GameRegistry.registerItem(atlantisWand,"atlantisWand");
		
		LanguageRegistry.addName(orePearl, "Pearl Ore");
		GameRegistry.registerBlock(orePearl, "orePearl");
		MinecraftForge.setBlockHarvestLevel(orePearl, "pickaxe", 2);
		
		LanguageRegistry.addName(blockPearl, "Block of Pearl");
		GameRegistry.registerBlock(blockPearl, "blockPearl");
		MinecraftForge.setBlockHarvestLevel(blockPearl, "pickaxe", 2);
		
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
		
		LanguageRegistry.addName(axePearl, "Pearl Axe");
		GameRegistry.registerItem(axePearl, "axePearl");
		LanguageRegistry.addName(pickaxePearl, "Pearl Pickaxe");
		GameRegistry.registerItem(pickaxePearl, "pickaxePearl");
		LanguageRegistry.addName(hoePearl, "Pearl Hoe");
		GameRegistry.registerItem(hoePearl, "hoePearl");
		LanguageRegistry.addName(shovelPearl, "Pearl Shovel");
		GameRegistry.registerItem(shovelPearl, "shovelPearl");
		LanguageRegistry.addName(swordPearl, "Pearl Sword");
		GameRegistry.registerItem(swordPearl, "swordPearl");
		
		GameRegistry.addRecipe(new ItemStack(AtlantisMod.atlantisWand)," xx"," sx","s  ",'x',Item.diamond,'s',Item.stick);

		LanguageRegistry.instance().addStringLocalization("itemGroup.tabAtlantis","en_US","Atlantis Mod");
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {}
	
}
