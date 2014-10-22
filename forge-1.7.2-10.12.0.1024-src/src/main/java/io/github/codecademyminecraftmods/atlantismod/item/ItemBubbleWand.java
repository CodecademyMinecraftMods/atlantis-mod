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

	public boolean generate(World world, int i, int j, int k) {

			world.setBlockWithoutNotify(i + -1, j + -1, k + -1, Blocks.air, 0, 0);
			world.setBlockWithoutNotify(i + -1, j + -1, k + 0, Blocks.air, 0, 0);
			world.setBlockWithoutNotify(i + -1, j + -1, k + 1, Blocks.air, 0, 0);
			world.setBlockWithoutNotify(i + -1, j + 0, k + -1, Blocks.air, 0, 0);
			world.setBlockWithoutNotify(i + -1, j + 0, k + 0, Blocks.air, 0, 0);
			world.setBlockWithoutNotify(i + -1, j + 0, k + 1, Blocks.air, 0, 0);
			world.setBlockWithoutNotify(i + -1, j + 2, k + -1, Blocks.air, 0, 0);
			world.setBlockWithoutNotify(i + -1, j + 2, k + 0, Blocks.air, 0, 0);
			world.setBlockWithoutNotify(i + -1, j + 2, k + 1, Blocks.air, 0, 0);
			world.setBlockWithoutNotify(i + 0, j + -1, k + -1, Blocks.air, 0, 0);
			world.setBlockWithoutNotify(i + 0, j + -1, k + 0, Blocks.air, 0, 0);
			world.setBlockWithoutNotify(i + 0, j + -1, k + 1, Blocks.air, 0, 0);
			world.setBlockWithoutNotify(i + 0, j + 0, k + -1, Blocks.air, 0, 0);
			world.setBlockWithoutNotify(i + 0, j + 0, k + 0, Blocks.air, 0, 0);
			world.setBlockWithoutNotify(i + 0, j + 0, k + 1, Blocks.air, 0, 0);
			world.setBlockWithoutNotify(i + 0, j + 1, k + -1, Blocks.air, 0, 0);
			world.setBlockWithoutNotify(i + 0, j + 1, k + 0, Blocks.air, 0, 0);
			world.setBlockWithoutNotify(i + 0, j + 1, k + 1, Blocks.air, 0, 0);
			world.setBlockWithoutNotify(i + 1, j + -1, k + -1, Blocks.air, 0, 0);
			world.setBlockWithoutNotify(i + 1, j + -1, k + 0, Blocks.air, 0, 0);
			world.setBlockWithoutNotify(i + 1, j + -1, k + 1, Blocks.air, 0, 0);
			world.setBlockWithoutNotify(i + 1, j + 0, k + -1, Blocks.air, 0, 0);
			world.setBlockWithoutNotify(i + 1, j + 0, k + 0, Blocks.air, 0, 0);
			world.setBlockWithoutNotify(i + 1, j + 0, k + 1, Blocks.air, 0, 0);
			world.setBlockWithoutNotify(i + 1, j + 1, k + -1, Blocks.air, 0, 0);
			world.setBlockWithoutNotify(i + 1, j + 1, k + 0, Blocks.air, 0, 0);
			world.setBlockWithoutNotify(i + 1, j + 1, k + 1, Blocks.air, 0, 0);

			return true;

	}

	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World) {
		
		generate(par1world, par2, par3, par4);

		return false;
	}

}