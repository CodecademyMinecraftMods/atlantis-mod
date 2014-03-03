package atlantismod.common;

import api.player.client.ClientPlayerAPI;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
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
	
	public static final int dimensionID = 22;

	public static Block portalAtlantisBlock;

	// lets keep it uniform; its more proper to init in the init function anyways
	public static Block deepSandBlock;
	
	public static Block blockCoral;
	
	public static Item atlantisWand;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		portalAtlantisBlock = (BlockAtlantisPortal)(new BlockAtlantisPortal(2222)).setUnlocalizedName("portalAtlantisBlock").setTextureName("portal");
		atlantisWand = (ItemAtlantisWand)(new ItemAtlantisWand(2223)).setUnlocalizedName("atlantisWand").setTextureName("atlantismod:portal_wand").setMaxStackSize(1);

		deepSandBlock = (new BlockSand(2224)).setHardness(0.5F).setStepSound(Block.soundSandFootstep).setUnlocalizedName("deepSand").setTextureName("atlantismod:deep_sand");
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderers();
		GameRegistry.registerWorldGenerator(new WorldGenAtlantis());
		DimensionManager.registerProviderType(AtlantisMod.dimensionID, WorldProviderAtlantis.class, false);
		DimensionManager.registerDimension(AtlantisMod.dimensionID, AtlantisMod.dimensionID);

		LanguageRegistry.addName(portalAtlantisBlock,"Atlantis Portal Block");
		GameRegistry.registerBlock(portalAtlantisBlock,"portalAtlantisBlock");
		
		//Deep Sand Registry
		GameRegistry.registerBlock(deepSandBlock,"deepSandBlock");
		LanguageRegistry.addName(deepSandBlock,"Deep Sand");
		MinecraftForge.setBlockHarvestLevel(deepSandBlock, "shovel", 1);
		//Deep Sand Registry end
		
		LanguageRegistry.addName(atlantisWand,"Atlantis Teleporter");
		GameRegistry.registerItem(atlantisWand,"atlantisWand");
		
		GameRegistry.addRecipe(new ItemStack(AtlantisMod.atlantisWand)," xx"," sx","s  ",'x',Item.diamond,'s',Item.stick);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {}
	
}
