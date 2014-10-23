package io.github.codecademyminecraftmods.atlantismod.item;

import io.github.codecademyminecraftmods.atlantismod.AtlantisMod;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

public class ItemBubbleWand extends Item {

	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World) {
		return (new WorldGenBubble2()).generate(par3World, new Random(), par2EntityPlayer.posX, par2EntityPlayer.posY, par2EntityPlayer.posZ);
	}

}