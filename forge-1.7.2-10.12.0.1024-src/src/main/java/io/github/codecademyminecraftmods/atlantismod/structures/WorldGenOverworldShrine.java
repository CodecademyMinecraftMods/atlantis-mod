package io.github.codecademyminecraftmods.atlantismod.structures;

import io.github.codecademyminecraftmods.atlantismod.AtlantisMod;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenOverworldShrine extends WorldGenerator {
	
	public boolean LocationIsInvalid(World world, int i, int j, int k){
		return (world.getBlock(i, j, k) == Blocks.air || world.getBlock(i, j, k) == Blocks.water);
	}

	@Override
	public boolean generate(World world, Random rand, int i, int j, int k) {
		while(LocationIsInvalid(world, i, j, k) && j > 0) j--;
		j++;
		if(!LocationIsInvalid(world, i, j, k) && !LocationIsInvalid(world, i, j + 2, k)) {
			world.setBlock(i, j, k, Blocks.quartz_block, 2, 3);
			world.setBlock(i+1, j, k, Blocks.quartz_block, 2, 3);
			world.setBlock(i-1, j, k, Blocks.quartz_block, 2, 3);
			world.setBlock(i, j, k+1, Blocks.quartz_block, 2, 3);
			world.setBlock(i, j, k-1, Blocks.quartz_block, 2, 3);
	        world.setBlock(i, j+1, k, Blocks.chest, 2, 2);
	        WeightedRandomChestContent[] content = new WeightedRandomChestContent[] {new WeightedRandomChestContent(AtlantisMod.atlantisEye, 1, 1, 1, 1)};
	        TileEntityChest tileentitychest = (TileEntityChest)world.getTileEntity(i, j, k);
	        if (tileentitychest != null) WeightedRandomChestContent.generateChestContents(rand, content, tileentitychest, 1);
	        return true;
		}
		return false;
	}
	
}