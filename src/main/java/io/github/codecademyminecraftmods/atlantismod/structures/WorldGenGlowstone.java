package io.github.codecademyminecraftmods.atlantismod.structures;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenGlowstone extends WorldGenerator {

	public boolean LocationIsValidSpawn(World world, int i, int j, int k){
		return (world.getBlock(i, j, k) == Blocks.water);
	}

	public boolean generate(World world, Random rand, int i, int j, int k) {
		while(LocationIsValidSpawn(world, i, j, k) && j > 0) j--;
		j++;
		if(LocationIsValidSpawn(world, i, j, k)) {
			world.setBlock(i, j, k, Blocks.glowstone);
			return true;
		}
		return false;
	}
}