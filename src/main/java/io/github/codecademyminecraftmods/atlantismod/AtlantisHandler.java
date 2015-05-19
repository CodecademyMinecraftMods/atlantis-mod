package io.github.codecademyminecraftmods.atlantismod;

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
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class AtlantisHandler {

	public static void loadRecipes() {
		GameRegistry.addRecipe(new ItemStack(AtlantisMod.scepter)," xx"," sx","s  ",'x',Items.diamond,'s',Items.blaze_rod);
        GameRegistry.addRecipe(new ItemStack(Items.dye, 2, 15),"x",'x',AtlantisMod.fishHead);
        GameRegistry.addRecipe(new ItemStack(AtlantisMod.atlantisWand)," x","s ",'x',AtlantisMod.atlantisEye,'s',AtlantisMod.scepter);
        GameRegistry.addRecipe(new ItemStack(AtlantisMod.bubbleWand)," x","s ",'x',Items.glass_bottle,'s',AtlantisMod.scepter);
        GameRegistry.addRecipe(new ItemStack(AtlantisMod.blockPearl),"xxx","xxx","xxx",'x',AtlantisMod.pearl);
        GameRegistry.addRecipe(new ItemStack(AtlantisMod.pearl),"x",'x',AtlantisMod.blockPearl);
        GameRegistry.addRecipe(new ItemStack(AtlantisMod.necklace),"ggg","g g"," e ", 'g',Items.gold_ingot, 'e', AtlantisMod.atlantisEye);
        
        GameRegistry.addRecipe(new ItemStack(AtlantisMod.atlanteum),"xxx","xxx","xxx",'x',AtlantisMod.nuggetAtlanteum);
        GameRegistry.addRecipe(new ItemStack(AtlantisMod.nuggetAtlanteum,9),"x",'x',AtlantisMod.atlanteum);
        GameRegistry.addRecipe(new ItemStack(AtlantisMod.blockAtlanteum),"xxx","xxx","xxx",'x',AtlantisMod.atlanteum);
        GameRegistry.addRecipe(new ItemStack(AtlantisMod.atlanteum,9),"x",'x',AtlantisMod.blockAtlanteum);
        GameRegistry.addSmelting(new ItemStack(AtlantisMod.oreAtlanteum),new ItemStack(AtlantisMod.atlanteum),0.3F);

        GameRegistry.addRecipe(new ItemStack(AtlantisMod.axePearl),"xx ","xs "," s ",'x',AtlantisMod.pearl,'s',Items.stick);
        GameRegistry.addRecipe(new ItemStack(AtlantisMod.pickaxePearl),"xxx"," s "," s ",'x',AtlantisMod.pearl,'s',Items.stick);
        GameRegistry.addRecipe(new ItemStack(AtlantisMod.hoePearl),"xx "," s "," s ",'x',AtlantisMod.pearl,'s',Items.stick);
        GameRegistry.addRecipe(new ItemStack(AtlantisMod.swordPearl)," x "," x "," s ",'x',AtlantisMod.pearl,'s',Items.stick);
        GameRegistry.addRecipe(new ItemStack(AtlantisMod.shovelPearl)," x "," s "," s ",'x',AtlantisMod.pearl,'s',Items.stick);
        
        GameRegistry.addRecipe(new ItemStack(AtlantisMod.axeAtlanteum),"xx ","xs "," s ",'x',AtlantisMod.atlanteum,'s',Items.stick);
        GameRegistry.addRecipe(new ItemStack(AtlantisMod.pickaxeAtlanteum),"xxx"," s "," s ",'x',AtlantisMod.atlanteum,'s',Items.stick);
        GameRegistry.addRecipe(new ItemStack(AtlantisMod.hoeAtlanteum),"xx "," s "," s ",'x',AtlantisMod.atlanteum,'s',Items.stick);
        GameRegistry.addRecipe(new ItemStack(AtlantisMod.swordAtlanteum)," x "," x "," s ",'x',AtlantisMod.atlanteum,'s',Items.stick);
        GameRegistry.addRecipe(new ItemStack(AtlantisMod.shovelAtlanteum)," x "," s "," s ",'x',AtlantisMod.atlanteum,'s',Items.stick);

        GameRegistry.addRecipe(new ItemStack(AtlantisMod.divingHelmet),"iii","ibi",'i',Items.iron_ingot,'b',Blocks.iron_bars);
        GameRegistry.addRecipe(new ItemStack(AtlantisMod.scubaSuit),"x x","xsx","xxx",'x',Items.leather,'s',Items.iron_ingot);
		GameRegistry.addRecipe(new ItemStack(AtlantisMod.oxygenTank),"xxx","xbx","xxx",'x',Items.iron_ingot,'b',Items.glass_bottle);
		GameRegistry.addRecipe(new ItemStack(AtlantisMod.flippers),"x x","x x",'x',Blocks.waterlily);
		
		GameRegistry.addRecipe(new ItemStack(AtlantisMod.helmetAtlanteum),"xxx","x x",'x',AtlantisMod.atlanteum);
		GameRegistry.addRecipe(new ItemStack(AtlantisMod.chestAtlanteum),"x x","xxx","xxx",'x',AtlantisMod.atlanteum);
		GameRegistry.addRecipe(new ItemStack(AtlantisMod.legsAtlanteum),"xxx","x x","x x",'x',AtlantisMod.atlanteum);
		GameRegistry.addRecipe(new ItemStack(AtlantisMod.bootsAtlanteum),"x x","x x",'x',AtlantisMod.atlanteum);
	}
	
}