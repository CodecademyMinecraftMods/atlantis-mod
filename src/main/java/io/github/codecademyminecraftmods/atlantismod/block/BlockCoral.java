package io.github.codecademyminecraftmods.atlantismod.block;

import io.github.codecademyminecraftmods.atlantismod.AtlantisMod;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class BlockCoral extends BlockSeaweed {
	
	private Item dropItem;
	
	public BlockCoral(Item par1Item) {
		super();
		this.dropItem = par1Item;
	}
	
    @Override
    public Item getItemDropped(int par1, Random par2Random, int par3) {
        return this.dropItem;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getItem(World par1World, int par2, int par3, int par4) {
        return this.dropItem;
    }
	
}