package atlantismod.common;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.BlockOreStorage;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
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
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenOcean;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import api.player.client.ClientPlayerAPI;
import api.player.server.ServerPlayerAPI;
import atlantismod.common.block.BlockAtlantisPortal;
import atlantismod.common.block.BlockCoral;
import atlantismod.common.block.BlockRottenPlanks;
import atlantismod.common.block.BlockSeaweed;
import atlantismod.common.dimension.BiomeGenAtlantisOcean;
import atlantismod.common.dimension.BiomeGenCoralReef;
import atlantismod.common.dimension.WorldGenAtlantis;
import atlantismod.common.dimension.WorldProviderAtlantis;
import atlantismod.common.entity.base.EntityAnglerFish;
import atlantismod.common.entity.base.EntityAtlantisFish;
import atlantismod.common.entity.base.EntityClam;
import atlantismod.common.entity.base.EntityEel;
import atlantismod.common.entity.base.EntityElectricEel;
import atlantismod.common.entity.base.EntityGiantSquid;
import atlantismod.common.entity.base.EntityKraken;
import atlantismod.common.entity.base.EntityMermaid;
import atlantismod.common.entity.base.EntityShark;
import atlantismod.common.entity.base.EntitySharkman;
import atlantismod.common.entity.base.EntitySquidman;
import atlantismod.common.entity.base.EntityWhale;
import atlantismod.common.item.ItemAtlanteumArmor;
import atlantismod.common.item.ItemAtlantisEye;
import atlantismod.common.item.ItemAtlantisWand;
import atlantismod.common.item.ItemDivingArmor;
import atlantismod.common.item.ItemNecklaceArmor;
import atlantismod.common.item.ItemSeaweed;
import atlantismod.common.item.ItemTrident;
import atlantismod.common.playerapi.AtlantisClientPlayerBase;
import atlantismod.common.playerapi.AtlantisServerPlayerBase;
import atlantismod.common.thedeep.BiomeGenTheDeep;
import atlantismod.common.thedeep.WorldProviderTheDeep;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * 
 * Atlantis Mod
 * 
 * @author Graeme22
 * @author Lepreckaun
 * @author ETBCOR
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
	public static final int dimensionDeepID = 23;
	
	public static BiomeGenBase atlantisOcean;
	public static BiomeGenBase coralReef;
	public static BiomeGenBase deepOcean;
	public static BiomeGenBase darkOcean;
	
	public static BiomeGenBase[] biomes;
	
	private static EnumArmorMaterial DivingSuit = EnumHelper.addArmorMaterial("DIVINGARMOR",15,new int[]{2,2,0,0},0);
	private static EnumArmorMaterial NecklaceArmor = EnumHelper.addArmorMaterial("NECKLACEARMOR",15,new int[]{0,0,0,0},0);
	private static EnumArmorMaterial AtlanteumArmor = EnumHelper.addArmorMaterial("ATLANTISARMOR",25,new int[]{3,7,5,2},15);
	private static EnumToolMaterial PearlTool = EnumHelper.addToolMaterial("PEARLTOOL",3,1111,7.0F,2.5F,20);
	private static EnumToolMaterial AtlanteumTool = EnumHelper.addToolMaterial("ATLANTISTOOL",2,1881,7.5F,2.5F,15);
	private static EnumToolMaterial Trident = EnumHelper.addToolMaterial("TRIDENTTOOL",1,1000,1.0F,5.0F,8);
	
	public static CreativeTabs tabAtlantis;

	public static Block portalAtlantisBlock;

	public static Block deepSandBlock, blockRottenPlanks, blockSeaweed;

	public static Item pearl, atlantisWand, trident, atlantisEye, scepter, necklace;
	
	public static Item fishHead, seaweedItem;
	
	public static Item swordPearl, pickaxePearl, shovelPearl, hoePearl, axePearl;
	
	public static Item swordAtlanteum, pickaxeAtlanteum, shovelAtlanteum, hoeAtlanteum, axeAtlanteum;
	
	public static Block blockPearl;
	
	public static Block oreAtlanteum, blockAtlanteum;
	
	public static Block pebble;
	
	public static Item atlanteum, nuggetAtlanteum;
	
	public static ItemArmor divingHelmet, scubaSuit, oxygenTank, flippers;
	
	public static ItemArmor helmetAtlanteum, chestAtlanteum, legsAtlanteum, bootsAtlanteum;
	
	public static Block blockCoralOrange, blockCoralGreen, blockCoralRed, blockCoralPurple, blockCoralYellow;
	
	public AtlantisMod() {
		ClientPlayerAPI.register("AtlantisMod", AtlantisClientPlayerBase.class);
		ServerPlayerAPI.register("AtlantisMod", AtlantisServerPlayerBase.class);
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		tabAtlantis = new CreativeTabs("tabAtlantis") {public ItemStack getIconItemStack() {return new ItemStack(AtlantisMod.pearl.itemID, 1, 0);}};
		
		portalAtlantisBlock = (BlockAtlantisPortal)(new BlockAtlantisPortal(2222)).setUnlocalizedName("portalAtlantisBlock").setTextureName("portal");
		
		deepSandBlock = (new BlockSand(203)).setHardness(0.5F).setStepSound(Block.soundSandFootstep).setUnlocalizedName("deepSand").setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:deep_sand");
		blockRottenPlanks = (new BlockRottenPlanks(2223)).setHardness(1.5F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("rottenPlanks").setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:rotten_planks");
		blockSeaweed = (new BlockSeaweed(2300)).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("blockSeaweed").setTextureName("atlantismod:seaweed");
		
		pearl = (new Item(2224)).setUnlocalizedName("pearl").setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:pearl");
		atlantisWand = (ItemAtlantisWand)(new ItemAtlantisWand(2225)).setUnlocalizedName("atlantisWand").setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:portal_wand").setMaxStackSize(1);
		trident = (new ItemTrident(2226,AtlantisMod.Trident)).setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:trident").setUnlocalizedName("trident").setMaxStackSize(1);
		atlantisEye = (new ItemAtlantisEye(2227,2,1.2F,false)).setAlwaysEdible().setUnlocalizedName("atlantisEye").setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:atlantis_eye").setMaxStackSize(16);
		scepter = (new Item(2228)).setUnlocalizedName("scepter").setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:scepter").setMaxStackSize(1);
		necklace = (ItemNecklaceArmor)(new ItemNecklaceArmor(2229,AtlantisMod.NecklaceArmor,0,1)).setUnlocalizedName("necklace").setMaxDamage(10000).setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:necklace").setMaxStackSize(1);
		seaweedItem = (new ItemSeaweed(2259,AtlantisMod.blockSeaweed)).setUnlocalizedName("seaweedItem").setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:seaweed_item");
		
		fishHead = (new Item(2230)).setUnlocalizedName("fishHead").setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:fish_head");
		
		blockPearl = (new BlockOreStorage(2231)).setHardness(3.0F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("blockPearl").setTextureName("atlantismod:pearl_block").setCreativeTab(AtlantisMod.tabAtlantis);
		oreAtlanteum = (new BlockOre(2232)).setHardness(3.0F).setResistance(5.0F).setUnlocalizedName("oreAtlanteum").setTextureName("atlantismod:atlanteum_ore").setCreativeTab(AtlantisMod.tabAtlantis);
		blockAtlanteum = (new BlockOreStorage(2233)).setHardness(3.0F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("blockAtlanteum").setTextureName("atlantismod:atlanteum_block").setCreativeTab(AtlantisMod.tabAtlantis);
		
		atlanteum = (new Item(2234)).setUnlocalizedName("atlanteum").setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:atlanteum");
		nuggetAtlanteum = (new Item(2235)).setUnlocalizedName("nuggetAtlanteum").setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:atlanteum_nugget");
		
		divingHelmet = (ItemDivingArmor)(new ItemDivingArmor(2236,AtlantisMod.DivingSuit,0,0)).setCreativeTab(AtlantisMod.tabAtlantis).setMaxStackSize(1).setUnlocalizedName("divingHelmet").setTextureName("atlantismod:diving_helmet");
		scubaSuit = (ItemDivingArmor)(new ItemDivingArmor(2237,AtlantisMod.DivingSuit,0,1)).setCreativeTab(AtlantisMod.tabAtlantis).setMaxStackSize(1).setUnlocalizedName("scubaSuit").setTextureName("atlantismod:scuba_suit");
		oxygenTank = (ItemDivingArmor)(new ItemDivingArmor(2238,AtlantisMod.DivingSuit,0,2)).setMaxDamage(10000).setCreativeTab(AtlantisMod.tabAtlantis).setMaxStackSize(1).setUnlocalizedName("oxygenTank").setTextureName("atlantismod:oxygen_tank");
		flippers = (ItemDivingArmor)(new ItemDivingArmor(2239,AtlantisMod.DivingSuit,0,3)).setCreativeTab(AtlantisMod.tabAtlantis).setMaxStackSize(1).setUnlocalizedName("flippers").setTextureName("atlantismod:flippers");
		
		blockCoralOrange = (new BlockCoral(2240)).setHardness(0.1F).setResistance(0.1F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("blockCoralOrange").setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:orange_coral");
		blockCoralGreen = (new BlockCoral(2241)).setHardness(0.1F).setResistance(0.1F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("blockCoralGreen").setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:green_coral");
		blockCoralRed = (new BlockCoral(205)).setHardness(0.1F).setResistance(0.1F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("blockCoralRed").setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:red_coral");
		blockCoralPurple = (new BlockCoral(2242)).setHardness(0.1F).setResistance(0.1F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("blockCoralPurple").setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:purple_coral");
		blockCoralYellow = (new BlockCoral(2243)).setHardness(0.1F).setResistance(0.1F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("blockCoralYellow").setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:yellow_coral");
		
		pebble = (new Block(2244,Material.sand)).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundGravelFootstep).setUnlocalizedName("pebble").setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:pebble");
		
		axePearl = (new ItemAxe(2245,AtlantisMod.PearlTool)).setUnlocalizedName("axePearl").setTextureName("atlantismod:pearl_axe").setCreativeTab(AtlantisMod.tabAtlantis);
		pickaxePearl = (new ItemPickaxe(2246,AtlantisMod.PearlTool)).setUnlocalizedName("pickaxePearl").setTextureName("atlantismod:pearl_pickaxe").setCreativeTab(AtlantisMod.tabAtlantis);
		hoePearl = (new ItemHoe(2247,AtlantisMod.PearlTool)).setUnlocalizedName("hoePearl").setTextureName("atlantismod:pearl_hoe").setCreativeTab(AtlantisMod.tabAtlantis);
		shovelPearl = (new ItemSpade(2248,AtlantisMod.PearlTool)).setUnlocalizedName("shovelPearl").setTextureName("atlantismod:pearl_shovel").setCreativeTab(AtlantisMod.tabAtlantis);
		swordPearl = (new ItemSword(2249,AtlantisMod.PearlTool)).setUnlocalizedName("swordPearl").setTextureName("atlantismod:pearl_sword").setCreativeTab(AtlantisMod.tabAtlantis);
		
		axeAtlanteum = (new ItemAxe(2250,AtlantisMod.AtlanteumTool)).setUnlocalizedName("axeAtlanteum").setTextureName("atlantismod:atlanteum_axe").setCreativeTab(AtlantisMod.tabAtlantis);
		pickaxeAtlanteum = (new ItemPickaxe(2251,AtlantisMod.AtlanteumTool)).setUnlocalizedName("pickaxeAtlanteum").setTextureName("atlantismod:atlanteum_pickaxe").setCreativeTab(AtlantisMod.tabAtlantis);
		hoeAtlanteum = (new ItemHoe(2252,AtlantisMod.AtlanteumTool)).setUnlocalizedName("hoeAtlanteum").setTextureName("atlantismod:atlanteum_hoe").setCreativeTab(AtlantisMod.tabAtlantis);
		shovelAtlanteum = (new ItemSpade(2253,AtlantisMod.AtlanteumTool)).setUnlocalizedName("shovelAtlanteum").setTextureName("atlantismod:atlanteum_shovel").setCreativeTab(AtlantisMod.tabAtlantis);
		swordAtlanteum = (new ItemSword(2254,AtlantisMod.AtlanteumTool)).setUnlocalizedName("swordAtlanteum").setTextureName("atlantismod:atlanteum_sword").setCreativeTab(AtlantisMod.tabAtlantis);
		
		helmetAtlanteum = (ItemAtlanteumArmor)(new ItemAtlanteumArmor(2255,AtlantisMod.AtlanteumArmor,0,0)).setCreativeTab(AtlantisMod.tabAtlantis).setMaxStackSize(1).setUnlocalizedName("helmetAtlanteum").setTextureName("atlantismod:atlanteum_helmet");
		chestAtlanteum = (ItemAtlanteumArmor)(new ItemAtlanteumArmor(2256,AtlantisMod.AtlanteumArmor,0,1)).setCreativeTab(AtlantisMod.tabAtlantis).setMaxStackSize(1).setUnlocalizedName("chestAtlanteum").setTextureName("atlantismod:atlanteum_chestplate");
		legsAtlanteum = (ItemAtlanteumArmor)(new ItemAtlanteumArmor(2257,AtlantisMod.AtlanteumArmor,0,2)).setCreativeTab(AtlantisMod.tabAtlantis).setMaxStackSize(1).setUnlocalizedName("legsAtlanteum").setTextureName("atlantismod:atlanteum_leggings");
		bootsAtlanteum = (ItemAtlanteumArmor)(new ItemAtlanteumArmor(2258,AtlantisMod.AtlanteumArmor,0,3)).setCreativeTab(AtlantisMod.tabAtlantis).setMaxStackSize(1).setUnlocalizedName("bootsAtlanteum").setTextureName("atlantismod:atlanteum_boots");
		
		atlantisOcean = (new BiomeGenAtlantisOcean(22)).setBiomeName("Atlantean Ocean").setMinMaxHeight(-1.9F, 0.1F);
		coralReef = (new BiomeGenCoralReef(23)).setBiomeName("Coral Reef").setMinMaxHeight(-1.9F, 0.1F);
		deepOcean = (new BiomeGenOcean(24)).setBiomeName("Deepest Ocean").setMinMaxHeight(-2.0F, 0.1F);
		darkOcean = (new BiomeGenTheDeep(25)).setBiomeName("Dark Ocean").setMinMaxHeight(-1.9F, 0.1F);
		
		biomes = new BiomeGenBase[]{AtlantisMod.atlantisOcean,AtlantisMod.coralReef,AtlantisMod.deepOcean};
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderers();
		GameRegistry.registerWorldGenerator(new WorldGenAtlantis());
		
		DimensionManager.registerProviderType(AtlantisMod.dimensionID, WorldProviderAtlantis.class, false);
		DimensionManager.registerDimension(AtlantisMod.dimensionID, AtlantisMod.dimensionID);
		DimensionManager.registerProviderType(AtlantisMod.dimensionDeepID, WorldProviderTheDeep.class, false);
		DimensionManager.registerDimension(AtlantisMod.dimensionDeepID, AtlantisMod.dimensionDeepID);
		
		EntityRegistry.registerModEntity(EntityAtlantisFish.class,"Fish",1,this,40,3,true);
		EntityRegistry.addSpawn(EntityAtlantisFish.class,10,3,5,EnumCreatureType.waterCreature,AtlantisMod.biomes);
		LanguageRegistry.instance().addStringLocalization("entity.AtlantisMod.Fish.name","Fish");
		
		EntityRegistry.registerModEntity(EntitySquidman.class,"Squidman",2,this,40,3,true);
		EntityRegistry.addSpawn(EntitySquidman.class,6,2,3,EnumCreatureType.monster,AtlantisMod.biomes);
		LanguageRegistry.instance().addStringLocalization("entity.AtlantisMod.Squidman.name","Squidman");
		
		EntityRegistry.registerModEntity(EntityGiantSquid.class,"Giant Squid",3,this,40,3,true);
		EntityRegistry.addSpawn(EntityGiantSquid.class,3,1,1,EnumCreatureType.monster,AtlantisMod.biomes);
		LanguageRegistry.instance().addStringLocalization("entity.AtlantisMod.Giant Squid.name","Giant Squid");
		
		EntityRegistry.registerModEntity(EntityAnglerFish.class,"Angler Fish",4,this,40,3,true);
		EntityRegistry.addSpawn(EntityAnglerFish.class,4,1,3,EnumCreatureType.monster,AtlantisMod.biomes);
		LanguageRegistry.instance().addStringLocalization("entity.AtlantisMod.Angler Fish.name","Angler Fish");
		
		EntityRegistry.registerModEntity(EntityWhale.class,"Whale",5,this,40,3,true);
		EntityRegistry.addSpawn(EntityWhale.class,3,1,2,EnumCreatureType.waterCreature,AtlantisMod.biomes);
		LanguageRegistry.instance().addStringLocalization("entity.AtlantisMod.Whale.name","Whale");
		
		EntityRegistry.registerModEntity(EntityKraken.class,"Kraken",6,this,80,3,true);
		EntityRegistry.addSpawn(EntityKraken.class,1,1,2,EnumCreatureType.monster,AtlantisMod.darkOcean);
		LanguageRegistry.instance().addStringLocalization("entity.AtlantisMod.Kraken.name","Kraken");
		
		EntityRegistry.registerModEntity(EntityEel.class,"Eel",7,this,40,3,true);
		EntityRegistry.addSpawn(EntityEel.class,7,1,5,EnumCreatureType.waterCreature,AtlantisMod.biomes);
		LanguageRegistry.instance().addStringLocalization("entity.AtlantisMod.Eel.name","Eel");

		EntityRegistry.registerModEntity(EntityElectricEel.class,"Electric Eel",8,this,40,3,true);
		EntityRegistry.addSpawn(EntityElectricEel.class,4,1,3,EnumCreatureType.monster,AtlantisMod.biomes);
		LanguageRegistry.instance().addStringLocalization("entity.AtlantisMod.Electric Eel.name","Electric Eel");
		
		EntityRegistry.registerModEntity(EntitySharkman.class,"Sharkman",9,this,40,3,true);
		EntityRegistry.addSpawn(EntitySharkman.class,6,2,3,EnumCreatureType.monster,AtlantisMod.biomes);
		LanguageRegistry.instance().addStringLocalization("entity.AtlantisMod.Sharkman.name","Sharkman");
		
		EntityRegistry.registerModEntity(EntityShark.class,"Shark",10,this,40,3,true);
		EntityRegistry.addSpawn(EntityShark.class,4,1,3,EnumCreatureType.monster,AtlantisMod.biomes);
		LanguageRegistry.instance().addStringLocalization("entity.AtlantisMod.Shark.name","Shark");
		
		EntityRegistry.registerModEntity(EntityMermaid.class,"Mermaid",11,this,40,3,true);
		EntityRegistry.addSpawn(EntityMermaid.class,0,2,10,EnumCreatureType.waterCreature,AtlantisMod.biomes);
		LanguageRegistry.instance().addStringLocalization("entity.AtlantisMod.Mermaid.name","Mermaid");
		
		EntityRegistry.registerModEntity(EntityClam.class,"Clam",12,this,40,3,true);
		EntityRegistry.addSpawn(EntityClam.class,8,1,1,EnumCreatureType.waterCreature,AtlantisMod.biomes);
		LanguageRegistry.instance().addStringLocalization("entity.AtlantisMod.Clam.name","Clam");
		
		registerEntityEgg(EntitySquidman.class,0xffff66,0x000099);
		registerEntityEgg(EntityAtlantisFish.class,0xffffff,0x000000);
		registerEntityEgg(EntityGiantSquid.class,0x000099,0x000000);
		registerEntityEgg(EntityAnglerFish.class,0xcc0000,0xffff00);
		registerEntityEgg(EntityWhale.class,0x000099,0xffffff);
		registerEntityEgg(EntityKraken.class,0x006600,0x000000);
		registerEntityEgg(EntityEel.class,0xffff00,0x0000cc);
		registerEntityEgg(EntityElectricEel.class,0xffff00,0xffffff);
		registerEntityEgg(EntitySharkman.class,0xffff66,0x4c4c43);
		registerEntityEgg(EntityShark.class,0x4c4c43,0xffffff);
		registerEntityEgg(EntityMermaid.class,0xffff66,0x006600);
		registerEntityEgg(EntityClam.class,0x4c4c43,0x000000);

		LanguageRegistry.addName(portalAtlantisBlock, "Atlantis Portal Block");
		GameRegistry.registerBlock(portalAtlantisBlock, "portalAtlantisBlock");

		LanguageRegistry.addName(pearl, "Pearl");
		GameRegistry.registerItem(pearl, "pearl");
		
		LanguageRegistry.addName(trident, "Trident");
		GameRegistry.registerItem(trident, "trident");
		
		LanguageRegistry.addName(fishHead, "Fish Head");
		GameRegistry.registerItem(fishHead, "fishHead");
		
		LanguageRegistry.addName(atlantisEye, "Eye of Atlantis");
		GameRegistry.registerItem(atlantisEye, "atlantisEye");
		
		LanguageRegistry.addName(scepter, "Scepter");
		GameRegistry.registerItem(scepter, "scepter");
		
		LanguageRegistry.addName(necklace, "Atlantis Necklace");
		GameRegistry.registerItem(necklace, "necklace");
		
		LanguageRegistry.addName(seaweedItem, "Seaweed");
		GameRegistry.registerItem(seaweedItem, "seaweedItem");

		LanguageRegistry.addName(blockRottenPlanks, "Rotten Planks");
		MinecraftForge.setBlockHarvestLevel(blockRottenPlanks, "axe", 1);
		GameRegistry.registerBlock(blockRottenPlanks,"blockRottenPlanks");

		LanguageRegistry.addName(deepSandBlock,"Deep Sand");
		MinecraftForge.setBlockHarvestLevel(deepSandBlock, "shovel", 1);
		GameRegistry.registerBlock(deepSandBlock,"deepSandBlock");
		
		LanguageRegistry.addName(blockSeaweed, "Seaweed");
		GameRegistry.registerBlock(blockSeaweed, "seaweed");
		
		LanguageRegistry.addName(atlantisWand,"Atlantis Teleporter");
		GameRegistry.registerItem(atlantisWand,"atlantisWand");
		
		LanguageRegistry.addName(blockPearl, "Block of Pearl");
		MinecraftForge.setBlockHarvestLevel(blockPearl, "pickaxe", 2);
		GameRegistry.registerBlock(blockPearl, "blockPearl");
		LanguageRegistry.addName(oreAtlanteum, "Atlanteum Ore");
		MinecraftForge.setBlockHarvestLevel(oreAtlanteum, "pickaxe", 2);
		GameRegistry.registerBlock(oreAtlanteum, "oreAtlanteum");
		LanguageRegistry.addName(blockAtlanteum, "Block of Atlanteum");
		MinecraftForge.setBlockHarvestLevel(blockAtlanteum, "pickaxe", 2);
		GameRegistry.registerBlock(blockAtlanteum, "blockAtlanteum");

		LanguageRegistry.addName(blockCoralOrange,"Orange Coral");
		GameRegistry.registerBlock(blockCoralOrange,"blockCoralOrange");
		LanguageRegistry.addName(blockCoralGreen,"Green Coral");
		GameRegistry.registerBlock(blockCoralGreen,"blockCoralGreen");
		LanguageRegistry.addName(blockCoralRed,"Red Coral");
		GameRegistry.registerBlock(blockCoralRed,"blockCoralRed");
		LanguageRegistry.addName(blockCoralPurple,"Purple Coral");
		GameRegistry.registerBlock(blockCoralPurple,"blockCoralPurple");
		LanguageRegistry.addName(blockCoralYellow,"Yellow Coral");
		GameRegistry.registerBlock(blockCoralYellow,"blockCoralYellow");
		
		LanguageRegistry.addName(pebble, "Pebble");
		GameRegistry.registerBlock(pebble, "pebble");
		
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
		
		LanguageRegistry.addName(axeAtlanteum, "Atlanteum Axe");
		GameRegistry.registerItem(axeAtlanteum, "axeAtlanteum");
		LanguageRegistry.addName(pickaxeAtlanteum, "Atlanteum Pickaxe");
		GameRegistry.registerItem(pickaxeAtlanteum, "pickaxeAtlanteum");
		LanguageRegistry.addName(hoeAtlanteum, "Atlanteum Hoe");
		GameRegistry.registerItem(hoeAtlanteum, "hoeAtlanteum");
		LanguageRegistry.addName(shovelAtlanteum, "Atlanteum Shovel");
		GameRegistry.registerItem(shovelAtlanteum, "shovelAtlanteum");
		LanguageRegistry.addName(swordAtlanteum, "Atlanteum Sword");
		GameRegistry.registerItem(swordAtlanteum, "swordAtlanteum");
		
		LanguageRegistry.addName(atlanteum, "Atlanteum");
		GameRegistry.registerItem(atlanteum, "atlanteum");
		LanguageRegistry.addName(nuggetAtlanteum, "Atlanteum Nugget");
		GameRegistry.registerItem(nuggetAtlanteum, "nuggetAtlanteum");
		
		LanguageRegistry.addName(divingHelmet, "Diving Helmet");
		GameRegistry.registerItem(divingHelmet, "divingHelmet");
		LanguageRegistry.addName(scubaSuit, "Diving Suit");
		GameRegistry.registerItem(scubaSuit, "scubaSuit");
		LanguageRegistry.addName(oxygenTank, "Oxygen Tank");
		GameRegistry.registerItem(oxygenTank, "oxygenTank");
		LanguageRegistry.addName(flippers, "Flippers");
		GameRegistry.registerItem(flippers, "flippers");
		
		LanguageRegistry.addName(helmetAtlanteum, "Atlanteum Helmet");
		GameRegistry.registerItem(helmetAtlanteum, "helmetAtlanteum");
		LanguageRegistry.addName(chestAtlanteum, "Atlanteum Chestplate");
		GameRegistry.registerItem(chestAtlanteum, "chestAtlanteum");
		LanguageRegistry.addName(legsAtlanteum, "Atlanteum Leggings");
		GameRegistry.registerItem(legsAtlanteum, "legsAtlanteum");
		LanguageRegistry.addName(bootsAtlanteum, "Atlanteum Boots");
		GameRegistry.registerItem(bootsAtlanteum, "bootsAtlanteum");
	
		GameRegistry.addRecipe(new ItemStack(AtlantisMod.scepter)," xx"," sx","s  ",'x',Item.diamond,'s',Item.blazeRod);
        GameRegistry.addRecipe(new ItemStack(Item.dyePowder, 2, 15),"x",'x',AtlantisMod.fishHead);
        GameRegistry.addRecipe(new ItemStack(AtlantisMod.atlantisWand),"  x"," s ","x  ",'x',AtlantisMod.atlantisEye,'s',AtlantisMod.scepter);
        GameRegistry.addRecipe(new ItemStack(AtlantisMod.blockPearl),"xxx","xxx","xxx",'x',AtlantisMod.pearl);
        GameRegistry.addRecipe(new ItemStack(AtlantisMod.pearl),"x",'x',AtlantisMod.blockPearl);
        GameRegistry.addRecipe(new ItemStack(AtlantisMod.necklace),"ggg","g g"," e ", 'g',Item.ingotGold, 'e', AtlantisMod.atlantisEye);
        
        GameRegistry.addRecipe(new ItemStack(AtlantisMod.atlanteum),"xxx","xxx","xxx",'x',AtlantisMod.nuggetAtlanteum);
        GameRegistry.addRecipe(new ItemStack(AtlantisMod.nuggetAtlanteum,9),"x",'x',AtlantisMod.atlanteum);
        GameRegistry.addRecipe(new ItemStack(AtlantisMod.blockAtlanteum),"xxx","xxx","xxx",'x',AtlantisMod.atlanteum);
        GameRegistry.addRecipe(new ItemStack(AtlantisMod.atlanteum,9),"x",'x',AtlantisMod.blockAtlanteum);

        GameRegistry.addRecipe(new ItemStack(AtlantisMod.axePearl),"xx ","xs "," s ",'x',AtlantisMod.pearl,'s',Item.stick);
        GameRegistry.addRecipe(new ItemStack(AtlantisMod.pickaxePearl),"xxx"," s "," s ",'x',AtlantisMod.pearl,'s',Item.stick);
        GameRegistry.addRecipe(new ItemStack(AtlantisMod.hoePearl),"xx "," s "," s ",'x',AtlantisMod.pearl,'s',Item.stick);
        GameRegistry.addRecipe(new ItemStack(AtlantisMod.swordPearl)," x "," x "," s ",'x',AtlantisMod.pearl,'s',Item.stick);
        GameRegistry.addRecipe(new ItemStack(AtlantisMod.shovelPearl)," x "," s "," s ",'x',AtlantisMod.pearl,'s',Item.stick);
        
        GameRegistry.addRecipe(new ItemStack(AtlantisMod.axeAtlanteum),"xx ","xs "," s ",'x',AtlantisMod.atlanteum,'s',Item.stick);
        GameRegistry.addRecipe(new ItemStack(AtlantisMod.pickaxeAtlanteum),"xxx"," s "," s ",'x',AtlantisMod.atlanteum,'s',Item.stick);
        GameRegistry.addRecipe(new ItemStack(AtlantisMod.hoeAtlanteum),"xx "," s "," s ",'x',AtlantisMod.atlanteum,'s',Item.stick);
        GameRegistry.addRecipe(new ItemStack(AtlantisMod.swordAtlanteum)," x "," x "," s ",'x',AtlantisMod.atlanteum,'s',Item.stick);
        GameRegistry.addRecipe(new ItemStack(AtlantisMod.shovelAtlanteum)," x "," s "," s ",'x',AtlantisMod.atlanteum,'s',Item.stick);

        GameRegistry.addRecipe(new ItemStack(AtlantisMod.divingHelmet),"iii","ibi",'i',Item.ingotIron,'b',Block.fenceIron);
        GameRegistry.addRecipe(new ItemStack(AtlantisMod.scubaSuit),"x x","xsx","xxx",'x',Item.leather,'s',Item.ingotIron);
		GameRegistry.addRecipe(new ItemStack(AtlantisMod.oxygenTank),"xxx","xbx","xxx",'x',Item.ingotIron,'b',Item.glassBottle);
		GameRegistry.addRecipe(new ItemStack(AtlantisMod.flippers),"x x","x x",'x',Block.waterlily);
		
		GameRegistry.addRecipe(new ItemStack(AtlantisMod.helmetAtlanteum),"xxx","x x",'x',AtlantisMod.atlanteum);
		GameRegistry.addRecipe(new ItemStack(AtlantisMod.chestAtlanteum),"x x","xxx","xxx",'x',AtlantisMod.atlanteum);
		GameRegistry.addRecipe(new ItemStack(AtlantisMod.legsAtlanteum),"xxx","x x","x x",'x',AtlantisMod.atlanteum);
		GameRegistry.addRecipe(new ItemStack(AtlantisMod.bootsAtlanteum),"x x","x x",'x',AtlantisMod.atlanteum);

		LanguageRegistry.instance().addStringLocalization("itemGroup.tabAtlantis","en_US","Atlantis Mod");
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {}
	
	public static int getUniqueEntityId() {
		int startEntityId = 100;
		do {
			startEntityId++;
		} while (EntityList.getStringFromID(startEntityId) != null);
		return startEntityId;
	}
	
	public static void registerEntityEgg(Class<? extends Entity> entity, int primaryColor, int secondaryColor) {
		int id = getUniqueEntityId();
		EntityList.IDtoClassMapping.put(id, entity);
		EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
	}
	
}
