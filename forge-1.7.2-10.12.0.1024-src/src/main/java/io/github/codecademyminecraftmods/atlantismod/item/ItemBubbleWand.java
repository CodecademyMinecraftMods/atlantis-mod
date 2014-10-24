package io.github.codecademyminecraftmods.atlantismod.item;

import io.github.codecademyminecraftmods.atlantismod.structures.WorldGenBubble2;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBubbleWand extends Item {

	private Random rand = new Random();
	
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		if(!par2EntityPlayer.isInsideOfMaterial(Material.water)) return false;
		return (new WorldGenBubble2()).generate(par3World, this.rand, (int)par2EntityPlayer.posX, (int)par2EntityPlayer.posY, (int)par2EntityPlayer.posZ);
	}
	
}