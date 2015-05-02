package io.github.codecademyminecraftmods.atlantismod;

import io.github.codecademyminecraftmods.atlantismod.block.BlockCoral;
import io.github.codecademyminecraftmods.atlantismod.block.BlockPebble;
import io.github.codecademyminecraftmods.atlantismod.block.BlockRottenPlanks;
import io.github.codecademyminecraftmods.atlantismod.block.BlockSeaweed;
import io.github.codecademyminecraftmods.atlantismod.dimension.BiomeGenAtlantisOcean;
import io.github.codecademyminecraftmods.atlantismod.dimension.BiomeGenCoralReef;
import io.github.codecademyminecraftmods.atlantismod.dimension.WorldGenAtlantis;
import io.github.codecademyminecraftmods.atlantismod.dimension.WorldProviderAtlantis;
import io.github.codecademyminecraftmods.atlantismod.entity.base.EntityAnglerFish;
import io.github.codecademyminecraftmods.atlantismod.entity.base.EntityAtlantisFish;
import io.github.codecademyminecraftmods.atlantismod.entity.base.EntityClam;
import io.github.codecademyminecraftmods.atlantismod.entity.base.EntityEel;
import io.github.codecademyminecraftmods.atlantismod.entity.base.EntityElectricEel;
import io.github.codecademyminecraftmods.atlantismod.entity.base.EntityGiantSquid;
import io.github.codecademyminecraftmods.atlantismod.entity.base.EntityKraken;
import io.github.codecademyminecraftmods.atlantismod.entity.base.EntityMermaid;
import io.github.codecademyminecraftmods.atlantismod.entity.base.EntityShark;
import io.github.codecademyminecraftmods.atlantismod.entity.base.EntitySharkman;
import io.github.codecademyminecraftmods.atlantismod.entity.base.EntitySquidman;
import io.github.codecademyminecraftmods.atlantismod.entity.base.EntityWhale;
import io.github.codecademyminecraftmods.atlantismod.item.ItemAtlanteumArmor;
import io.github.codecademyminecraftmods.atlantismod.item.ItemAtlantisEye;
import io.github.codecademyminecraftmods.atlantismod.item.ItemAtlantisWand;
import io.github.codecademyminecraftmods.atlantismod.item.ItemBubbleWand;
import io.github.codecademyminecraftmods.atlantismod.item.ItemDivingArmor;
import io.github.codecademyminecraftmods.atlantismod.item.ItemNecklaceArmor;
import io.github.codecademyminecraftmods.atlantismod.item.ItemSeaweed;
import io.github.codecademyminecraftmods.atlantismod.item.ItemTrident;
import io.github.codecademyminecraftmods.atlantismod.item.tool.ItemAtlanteumAxe;
import io.github.codecademyminecraftmods.atlantismod.item.tool.ItemAtlanteumPickaxe;
import io.github.codecademyminecraftmods.atlantismod.item.tool.ItemPearlAxe;
import io.github.codecademyminecraftmods.atlantismod.item.tool.ItemPearlPickaxe;
import io.github.codecademyminecraftmods.atlantismod.playerapi.AtlantisClientPlayerBase;
import io.github.codecademyminecraftmods.atlantismod.playerapi.AtlantisServerPlayerBase;
import io.github.codecademyminecraftmods.atlantismod.thedeep.BiomeGenTheDeep;
import io.github.codecademyminecraftmods.atlantismod.thedeep.WorldProviderTheDeep;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCompressed;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.BlockOre;
import net.minecraft.block.BlockPortal;
import net.minecraft.block.material.MapColor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenOcean;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.util.EnumHelper;
import api.player.client.ClientPlayerAPI;
import api.player.server.ServerPlayerAPI;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * 
 * Atlantis Mod
 * 
 * @author Graeme22
 * @author Lepreckaun
 * @author ETBCOR
 * 
 * */

@Mod(modid=AtlantisMod.modid,name="Atlantis",version="1.2.1 Beta")
public class AtlantisMod {

	public static final String modid = "atlantismod";
	
	@Instance(value=AtlantisMod.modid)
	public static AtlantisMod instance;
	@SidedProxy(clientSide="io.github.codecademyminecraftmods.atlantismod.client.ClientProxy",serverSide="io.github.codecademyminecraftmods.atlantismod.CommonProxy")
    public static CommonProxy proxy;
	
	public static final int dimensionID = 22;
	public static final int dimensionDeepID = 23;
	
	public static BiomeGenBase atlantisOcean;
	public static BiomeGenBase coralReef;
	public static BiomeGenBase deepOcean;
	public static BiomeGenBase darkOcean;
	
	public static BiomeGenBase[] biomes;
	
	private static ArmorMaterial DivingSuit = EnumHelper.addArmorMaterial("DIVINGARMOR",15,new int[]{2,2,0,0},0);
	private static ArmorMaterial NecklaceArmor = EnumHelper.addArmorMaterial("NECKLACEARMOR",15,new int[]{0,0,0,0},0);
	private static ArmorMaterial AtlanteumArmor = EnumHelper.addArmorMaterial("ATLANTISARMOR",25,new int[]{3,7,5,2},15);
	private static ToolMaterial PearlTool = EnumHelper.addToolMaterial("PEARLTOOL",3,1111,7.0F,2.5F,20);
	private static ToolMaterial AtlanteumTool = EnumHelper.addToolMaterial("ATLANTISTOOL",2,1881,7.5F,2.5F,15);
	private static ToolMaterial Trident = EnumHelper.addToolMaterial("TRIDENTTOOL",1,1000,1.0F,5.0F,8);
	
	public static CreativeTabs tabAtlantis;
	
	public static Block blockAtlantisPortal;
	public static Block blockDeepSand, blockRottenPlanks, blockSeaweed;
	public static Item pearl, atlantisWand, trident, atlantisEye, scepter, necklace, bubbleWand;
	public static Item fishHead, itemSeaweed;
	public static Item swordPearl, pickaxePearl, shovelPearl, hoePearl, axePearl;
	public static Item swordAtlanteum, pickaxeAtlanteum, shovelAtlanteum, hoeAtlanteum, axeAtlanteum;
	public static Block blockPearl;
	public static Block oreAtlanteum, blockAtlanteum;
	public static Block pebble;
	public static Item atlanteum, nuggetAtlanteum;
	public static ItemArmor divingHelmet, scubaSuit, oxygenTank, flippers;
	public static ItemArmor helmetAtlanteum, chestAtlanteum, legsAtlanteum, bootsAtlanteum;
	public static Block blockCoralOrange, blockCoralRed, blockCoralPurple, blockCoralYellow;
	public static Item itemCoralOrange, itemCoralRed, itemCoralPurple, itemCoralYellow;
	
	public AtlantisMod() {
		ClientPlayerAPI.register("AtlantisMod", AtlantisClientPlayerBase.class);
		ServerPlayerAPI.register("AtlantisMod", AtlantisServerPlayerBase.class);
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		tabAtlantis = new CreativeTabs("tabAtlantis") {public Item getTabIconItem() {return AtlantisMod.pearl;}};
		
		blockAtlantisPortal = (BlockPortal)(new BlockPortal()).setBlockName("blockAtlantisPortal").setBlockTextureName("portal");
		
		blockDeepSand = (new BlockFalling()).setHardness(0.5F).setStepSound(Block.soundTypeSand).setBlockName("blockDeepSand").setCreativeTab(AtlantisMod.tabAtlantis).setBlockTextureName("atlantismod:deep_sand");
		blockRottenPlanks = (new BlockRottenPlanks()).setHardness(1.5F).setStepSound(Block.soundTypeWood).setBlockName("rottenPlanks").setCreativeTab(AtlantisMod.tabAtlantis).setBlockTextureName("atlantismod:rotten_planks");

		pearl = (new Item()).setUnlocalizedName("pearl").setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:pearl");
		atlantisWand = (ItemAtlantisWand)(new ItemAtlantisWand()).setUnlocalizedName("atlantisWand").setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:portal_wand").setMaxStackSize(1);
		trident = (new ItemTrident(AtlantisMod.Trident)).setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:trident").setUnlocalizedName("trident").setMaxStackSize(1);
		atlantisEye = (new ItemAtlantisEye(2,1.2F,false)).setAlwaysEdible().setUnlocalizedName("atlantisEye").setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:atlantis_eye").setMaxStackSize(16);
		scepter = (new Item()).setUnlocalizedName("scepter").setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:scepter").setMaxStackSize(1);
		necklace = (ItemNecklaceArmor)(new ItemNecklaceArmor(AtlantisMod.NecklaceArmor,0,1)).setUnlocalizedName("necklace").setMaxDamage(10000).setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:necklace").setMaxStackSize(1);
		bubbleWand = (ItemBubbleWand)(new ItemBubbleWand()).setUnlocalizedName("bubbleWand").setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:bubble_wand").setMaxStackSize(1);
		
		fishHead = (new Item()).setUnlocalizedName("fishHead").setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:fish_head");
		
		blockPearl = (new BlockCompressed(MapColor.snowColor)).setHardness(3.0F).setResistance(10.0F).setStepSound(Block.soundTypeMetal).setBlockName("blockPearl").setBlockTextureName("atlantismod:pearl_block").setCreativeTab(AtlantisMod.tabAtlantis);
		oreAtlanteum = (new BlockOre()).setHardness(3.0F).setResistance(5.0F).setBlockName("oreAtlanteum").setBlockTextureName("atlantismod:atlanteum_ore").setCreativeTab(AtlantisMod.tabAtlantis);
		blockAtlanteum = (new BlockCompressed(MapColor.cyanColor)).setHardness(3.0F).setResistance(10.0F).setStepSound(Block.soundTypeMetal).setBlockName("blockAtlanteum").setBlockTextureName("atlantismod:atlanteum_block").setCreativeTab(AtlantisMod.tabAtlantis);
		
		atlanteum = (new Item()).setUnlocalizedName("atlanteum").setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:atlanteum");
		nuggetAtlanteum = (new Item()).setUnlocalizedName("nuggetAtlanteum").setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:atlanteum_nugget");
		
		divingHelmet = (ItemDivingArmor)(new ItemDivingArmor(AtlantisMod.DivingSuit,0,0)).setCreativeTab(AtlantisMod.tabAtlantis).setMaxStackSize(1).setUnlocalizedName("divingHelmet").setTextureName("atlantismod:diving_helmet");
		scubaSuit = (ItemDivingArmor)(new ItemDivingArmor(AtlantisMod.DivingSuit,0,1)).setCreativeTab(AtlantisMod.tabAtlantis).setMaxStackSize(1).setUnlocalizedName("scubaSuit").setTextureName("atlantismod:scuba_suit");
		oxygenTank = (ItemDivingArmor)(new ItemDivingArmor(AtlantisMod.DivingSuit,0,2)).setMaxDamage(10000).setCreativeTab(AtlantisMod.tabAtlantis).setMaxStackSize(1).setUnlocalizedName("oxygenTank").setTextureName("atlantismod:oxygen_tank");
		flippers = (ItemDivingArmor)(new ItemDivingArmor(AtlantisMod.DivingSuit,0,3)).setCreativeTab(AtlantisMod.tabAtlantis).setMaxStackSize(1).setUnlocalizedName("flippers").setTextureName("atlantismod:flippers");
		
		blockSeaweed = (new BlockSeaweed()).setHardness(0.0F).setStepSound(Block.soundTypeGrass).setBlockName("blockSeaweed").setBlockTextureName("atlantismod:seaweed");
		itemSeaweed = (new ItemSeaweed(AtlantisMod.blockSeaweed)).setUnlocalizedName("itemSeaweed").setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:seaweed_item");

		blockCoralOrange = (new BlockCoral(itemCoralOrange)).setHardness(0.0F).setStepSound(Block.soundTypeGrass).setBlockName("blockCoralOrange").setBlockTextureName("atlantismod:orange_coral");
		blockCoralRed = (new BlockCoral(itemCoralRed)).setHardness(0.0F).setStepSound(Block.soundTypeGrass).setBlockName("blockCoralRed").setBlockTextureName("atlantismod:red_coral");
		blockCoralPurple = (new BlockCoral(itemCoralPurple)).setHardness(0.0F).setStepSound(Block.soundTypeGrass).setBlockName("blockCoralPurple").setBlockTextureName("atlantismod:purple_coral");
		blockCoralYellow = (new BlockCoral(itemCoralYellow)).setHardness(0.0F).setStepSound(Block.soundTypeGrass).setBlockName("blockCoralYellow").setBlockTextureName("atlantismod:yellow_coral");
		
		itemCoralOrange = (new ItemSeaweed(AtlantisMod.blockCoralOrange)).setUnlocalizedName("itemCoralOrange").setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:orange_coral_item");
		itemCoralRed = (new ItemSeaweed(AtlantisMod.blockCoralRed)).setUnlocalizedName("itemCoralRed").setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:red_coral_item");
		itemCoralPurple = (new ItemSeaweed(AtlantisMod.blockCoralPurple)).setUnlocalizedName("itemCoralPurple").setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:purple_coral_item");
		itemCoralYellow = (new ItemSeaweed(AtlantisMod.blockCoralYellow)).setUnlocalizedName("itemCoralYellow").setCreativeTab(AtlantisMod.tabAtlantis).setTextureName("atlantismod:yellow_coral_item");
		
		pebble = (new BlockPebble()).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeGravel).setBlockName("pebble").setCreativeTab(AtlantisMod.tabAtlantis).setBlockTextureName("atlantismod:pebble");
		
		axePearl = (new ItemPearlAxe(AtlantisMod.PearlTool)).setUnlocalizedName("axePearl").setTextureName("atlantismod:pearl_axe").setCreativeTab(AtlantisMod.tabAtlantis);
		pickaxePearl = (new ItemPearlPickaxe(AtlantisMod.PearlTool)).setUnlocalizedName("pickaxePearl").setTextureName("atlantismod:pearl_pickaxe").setCreativeTab(AtlantisMod.tabAtlantis);
		hoePearl = (new ItemHoe(AtlantisMod.PearlTool)).setUnlocalizedName("hoePearl").setTextureName("atlantismod:pearl_hoe").setCreativeTab(AtlantisMod.tabAtlantis);
		shovelPearl = (new ItemSpade(AtlantisMod.PearlTool)).setUnlocalizedName("shovelPearl").setTextureName("atlantismod:pearl_shovel").setCreativeTab(AtlantisMod.tabAtlantis);
		swordPearl = (new ItemSword(AtlantisMod.PearlTool)).setUnlocalizedName("swordPearl").setTextureName("atlantismod:pearl_sword").setCreativeTab(AtlantisMod.tabAtlantis);
		
		axeAtlanteum = (new ItemAtlanteumAxe(AtlantisMod.AtlanteumTool)).setUnlocalizedName("axeAtlanteum").setTextureName("atlantismod:atlanteum_axe").setCreativeTab(AtlantisMod.tabAtlantis);
		pickaxeAtlanteum = (new ItemAtlanteumPickaxe(AtlantisMod.AtlanteumTool)).setUnlocalizedName("pickaxeAtlanteum").setTextureName("atlantismod:atlanteum_pickaxe").setCreativeTab(AtlantisMod.tabAtlantis);
		hoeAtlanteum = (new ItemHoe(AtlantisMod.AtlanteumTool)).setUnlocalizedName("hoeAtlanteum").setTextureName("atlantismod:atlanteum_hoe").setCreativeTab(AtlantisMod.tabAtlantis);
		shovelAtlanteum = (new ItemSpade(AtlantisMod.AtlanteumTool)).setUnlocalizedName("shovelAtlanteum").setTextureName("atlantismod:atlanteum_shovel").setCreativeTab(AtlantisMod.tabAtlantis);
		swordAtlanteum = (new ItemSword(AtlantisMod.AtlanteumTool)).setUnlocalizedName("swordAtlanteum").setTextureName("atlantismod:atlanteum_sword").setCreativeTab(AtlantisMod.tabAtlantis);
		
		helmetAtlanteum = (ItemAtlanteumArmor)(new ItemAtlanteumArmor(AtlantisMod.AtlanteumArmor,0,0)).setCreativeTab(AtlantisMod.tabAtlantis).setMaxStackSize(1).setUnlocalizedName("helmetAtlanteum").setTextureName("atlantismod:atlanteum_helmet");
		chestAtlanteum = (ItemAtlanteumArmor)(new ItemAtlanteumArmor(AtlantisMod.AtlanteumArmor,0,1)).setCreativeTab(AtlantisMod.tabAtlantis).setMaxStackSize(1).setUnlocalizedName("chestAtlanteum").setTextureName("atlantismod:atlanteum_chestplate");
		legsAtlanteum = (ItemAtlanteumArmor)(new ItemAtlanteumArmor(AtlantisMod.AtlanteumArmor,0,2)).setCreativeTab(AtlantisMod.tabAtlantis).setMaxStackSize(1).setUnlocalizedName("legsAtlanteum").setTextureName("atlantismod:atlanteum_leggings");
		bootsAtlanteum = (ItemAtlanteumArmor)(new ItemAtlanteumArmor(AtlantisMod.AtlanteumArmor,0,3)).setCreativeTab(AtlantisMod.tabAtlantis).setMaxStackSize(1).setUnlocalizedName("bootsAtlanteum").setTextureName("atlantismod:atlanteum_boots");
		
		atlantisOcean = (new BiomeGenAtlantisOcean(44)).setBiomeName("Atlantean Ocean").setHeight(new BiomeGenBase.Height(-1.9F, 0.1F));
		coralReef = (new BiomeGenCoralReef(45)).setBiomeName("Coral Reef").setHeight(new BiomeGenBase.Height(-1.9F, 0.1F));
		deepOcean = (new BiomeGenOcean(46)).setBiomeName("Deepest Ocean").setHeight(new BiomeGenBase.Height(-2.0F, 0.1F));
		darkOcean = (new BiomeGenTheDeep(47)).setBiomeName("Dark Ocean").setHeight(new BiomeGenBase.Height(-1.9F, 0.1F));
		
		biomes = new BiomeGenBase[]{AtlantisMod.atlantisOcean,AtlantisMod.coralReef,AtlantisMod.deepOcean};

		blockRottenPlanks.setHarvestLevel("pickaxe", 2);
		blockDeepSand.setHarvestLevel("shovel", 1);
		blockPearl.setHarvestLevel("pickaxe", 2);
		oreAtlanteum.setHarvestLevel("pickaxe", 2);
		blockAtlanteum.setHarvestLevel("pickaxe", 2);
		
		this.doRegister();
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderers();
		GameRegistry.registerWorldGenerator(new WorldGenAtlantis(),0);
		
		DimensionManager.registerProviderType(AtlantisMod.dimensionID, WorldProviderAtlantis.class, false);
		DimensionManager.registerDimension(AtlantisMod.dimensionID, AtlantisMod.dimensionID);
		DimensionManager.registerProviderType(AtlantisMod.dimensionDeepID, WorldProviderTheDeep.class, false);
		DimensionManager.registerDimension(AtlantisMod.dimensionDeepID, AtlantisMod.dimensionDeepID);
		
		this.registerEntities();
		
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
		
		AtlantisHandler.loadRecipes();
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
	
	public void registerEntities() {
		EntityRegistry.registerModEntity(EntityAtlantisFish.class,"Fish",1,this,40,3,true);
		EntityRegistry.addSpawn(EntityAtlantisFish.class,10,3,5,EnumCreatureType.waterCreature,AtlantisMod.biomes);
		
		EntityRegistry.registerModEntity(EntitySquidman.class,"Squidman",2,this,40,3,true);
		EntityRegistry.addSpawn(EntitySquidman.class,6,2,3,EnumCreatureType.monster,AtlantisMod.biomes);
		
		EntityRegistry.registerModEntity(EntityGiantSquid.class,"Giant Squid",3,this,40,3,true);
		EntityRegistry.addSpawn(EntityGiantSquid.class,3,1,1,EnumCreatureType.monster,AtlantisMod.biomes);
		
		EntityRegistry.registerModEntity(EntityAnglerFish.class,"Angler Fish",4,this,40,3,true);
		EntityRegistry.addSpawn(EntityAnglerFish.class,4,1,3,EnumCreatureType.monster,AtlantisMod.biomes);
		
		EntityRegistry.registerModEntity(EntityWhale.class,"Whale",5,this,40,3,true);
		EntityRegistry.addSpawn(EntityWhale.class,3,1,2,EnumCreatureType.waterCreature,AtlantisMod.biomes);
		
		EntityRegistry.registerModEntity(EntityKraken.class,"Kraken",6,this,80,3,true);
		EntityRegistry.addSpawn(EntityKraken.class,1,1,2,EnumCreatureType.monster,AtlantisMod.darkOcean);
		
		EntityRegistry.registerModEntity(EntityEel.class,"Eel",7,this,40,3,true);
		EntityRegistry.addSpawn(EntityEel.class,7,1,5,EnumCreatureType.waterCreature,AtlantisMod.biomes);

		EntityRegistry.registerModEntity(EntityElectricEel.class,"Electric Eel",8,this,40,3,true);
		EntityRegistry.addSpawn(EntityElectricEel.class,4,1,3,EnumCreatureType.monster,AtlantisMod.biomes);
		
		EntityRegistry.registerModEntity(EntitySharkman.class,"Sharkman",9,this,40,3,true);
		EntityRegistry.addSpawn(EntitySharkman.class,6,2,3,EnumCreatureType.monster,AtlantisMod.biomes);
		
		EntityRegistry.registerModEntity(EntityShark.class,"Shark",10,this,40,3,true);
		EntityRegistry.addSpawn(EntityShark.class,4,1,3,EnumCreatureType.monster,AtlantisMod.biomes);
		
		EntityRegistry.registerModEntity(EntityMermaid.class,"Mermaid",11,this,40,3,true);
		EntityRegistry.addSpawn(EntityMermaid.class,0,2,10,EnumCreatureType.waterCreature,AtlantisMod.biomes);
		
		EntityRegistry.registerModEntity(EntityClam.class,"Clam",12,this,40,3,true);
		EntityRegistry.addSpawn(EntityClam.class,8,1,1,EnumCreatureType.waterCreature,AtlantisMod.biomes);
	}
	
	public void doRegister() {
		GameRegistry.registerBlock(blockAtlantisPortal, "blockAtlantisPortal");
		GameRegistry.registerItem(pearl, "pearl");
		GameRegistry.registerItem(trident, "trident");
		GameRegistry.registerItem(fishHead, "fishHead");
		GameRegistry.registerItem(atlantisEye, "atlantisEye");
		GameRegistry.registerItem(scepter, "scepter");
		GameRegistry.registerItem(necklace, "necklace");
		GameRegistry.registerItem(itemSeaweed, "itemSeaweed");
		GameRegistry.registerItem(itemCoralOrange, "itemCoralOrange");
		GameRegistry.registerItem(itemCoralRed, "itemCoralRed");
		GameRegistry.registerItem(itemCoralPurple, "itemCoralPurple");
		GameRegistry.registerItem(itemCoralYellow, "itemCoralYellow");
		GameRegistry.registerBlock(blockRottenPlanks,"blockRottenPlanks");
		GameRegistry.registerBlock(blockDeepSand,"blockDeepSand");
		GameRegistry.registerBlock(blockSeaweed, "seaweed");
		GameRegistry.registerBlock(blockCoralOrange, "blockCoralOrange");
		GameRegistry.registerBlock(blockCoralRed, "blockCoralRed");
		GameRegistry.registerBlock(blockCoralPurple, "blockCoralPurple");
		GameRegistry.registerBlock(blockCoralYellow, "blockCoralYellow");
		GameRegistry.registerItem(atlantisWand,"atlantisWand");
		GameRegistry.registerItem(bubbleWand, "bubbleWand");
		GameRegistry.registerBlock(blockPearl, "blockPearl");
		GameRegistry.registerBlock(oreAtlanteum, "oreAtlanteum");
		GameRegistry.registerBlock(blockAtlanteum, "blockAtlanteum");
		GameRegistry.registerBlock(pebble, "pebble");
		GameRegistry.registerItem(axePearl, "axePearl");
		GameRegistry.registerItem(pickaxePearl, "pickaxePearl");
		GameRegistry.registerItem(hoePearl, "hoePearl");
		GameRegistry.registerItem(shovelPearl, "shovelPearl");
		GameRegistry.registerItem(swordPearl, "swordPearl");
		GameRegistry.registerItem(axeAtlanteum, "axeAtlanteum");
		GameRegistry.registerItem(pickaxeAtlanteum, "pickaxeAtlanteum");
		GameRegistry.registerItem(hoeAtlanteum, "hoeAtlanteum");
		GameRegistry.registerItem(shovelAtlanteum, "shovelAtlanteum");
		GameRegistry.registerItem(swordAtlanteum, "swordAtlanteum");
		GameRegistry.registerItem(atlanteum, "atlanteum");
		GameRegistry.registerItem(nuggetAtlanteum, "nuggetAtlanteum");
		GameRegistry.registerItem(divingHelmet, "divingHelmet");
		GameRegistry.registerItem(scubaSuit, "scubaSuit");
		GameRegistry.registerItem(oxygenTank, "oxygenTank");
		GameRegistry.registerItem(flippers, "flippers");
		GameRegistry.registerItem(helmetAtlanteum, "helmetAtlanteum");
		GameRegistry.registerItem(chestAtlanteum, "chestAtlanteum");
		GameRegistry.registerItem(legsAtlanteum, "legsAtlanteum");
		GameRegistry.registerItem(bootsAtlanteum, "bootsAtlanteum");
	}
	
}
