package io.github.codecademyminecraftmods.atlantismod.dimension;

import io.github.codecademyminecraftmods.atlantismod.AtlantisMod;
import io.github.codecademyminecraftmods.atlantismod.structures.WorldGenAtlantisCity;
import io.github.codecademyminecraftmods.atlantismod.structures.WorldGenBubble2;
import io.github.codecademyminecraftmods.atlantismod.structures.WorldGenBubble3;
import io.github.codecademyminecraftmods.atlantismod.structures.WorldGenGlowstone;
import io.github.codecademyminecraftmods.atlantismod.structures.WorldGenOverworldShrine;
import io.github.codecademyminecraftmods.atlantismod.structures.WorldGenShipwreck;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenAtlantis implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId){
		case -1:
		    generateNether(world, random, chunkX * 16, chunkZ * 16);
		    break;
		case 0:
		    generateSurface(world, random, chunkX * 16, chunkZ * 16);
		    break;
		case 1:
		    generateEnd(world, random, chunkX * 16, chunkZ * 16);
		    break;
		case AtlantisMod.dimensionID:
			generateAtlantis(world, random, chunkX * 16, chunkZ * 16);
		case AtlantisMod.dimensionDeepID:
			generateTheDeep(world, random, chunkX * 16, chunkZ * 16);
		}
	}

	private void generateAtlantis(World world, Random random, int i, int j) {
		for(int k=0;k<2;k++) (new WorldGenMinable(AtlantisMod.oreAtlanteum,7)).generate(world,random,i + random.nextInt(16),random.nextInt(16),j + random.nextInt(16));
		for(int k=0;k<9;k++) (new WorldGenMinable(AtlantisMod.pebble,20,AtlantisMod.blockDeepSand)).generate(world,random,i + random.nextInt(16),random.nextInt(64),j + random.nextInt(16));		
		if(random.nextInt(500) == 1) (new WorldGenShipwreck()).generate(world, random, i + random.nextInt(15), 60, j + random.nextInt(15));
		for(int x=0;x<=4;x++) (new WorldGenGlowstone()).generate(world, random, i + random.nextInt(15), 55, j + random.nextInt(15));
		for(int x=0;x<=6;x++) (new WorldGenBubble2()).generate(world, random, i + random.nextInt(15), random.nextInt(60), j + random.nextInt(15));
		(new WorldGenBubble3()).generate(world, random, i + random.nextInt(15), random.nextInt(60), j + random.nextInt(15));
		if(random.nextInt(666) == 1) (new WorldGenAtlantisCity()).generate(world, random, i + random.nextInt(15), 60, j + random.nextInt(15));
	}
	
	private void generateTheDeep(World world, Random random, int i, int j) {
		for(int k=0;k<9;k++) (new WorldGenMinable(AtlantisMod.pebble,20,AtlantisMod.blockDeepSand)).generate(world,random,i + random.nextInt(16),random.nextInt(64),j + random.nextInt(16));
	}

	private void generateEnd(World world, Random random, int i, int j) {}

	private void generateSurface(World world, Random random, int i, int j) {
		if(random.nextInt(222) == 1) (new WorldGenOverworldShrine()).generate(world, random, i, 80, j);
	}

	private void generateNether(World world, Random random, int i, int j) {}

}