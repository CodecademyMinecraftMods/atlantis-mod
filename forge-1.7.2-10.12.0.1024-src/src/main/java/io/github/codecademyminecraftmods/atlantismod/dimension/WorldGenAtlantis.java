package atlantismod.common.dimension;

import java.util.Random;

import atlantismod.common.AtlantisMod;
import atlantismod.common.structures.WorldGenAtlantisCity;
import atlantismod.common.structures.WorldGenBubble2;
import atlantismod.common.structures.WorldGenBubble3;
import atlantismod.common.structures.WorldGenGlowstone;
import atlantismod.common.structures.WorldGenOverworldShrine;
import atlantismod.common.structures.WorldGenShipwreck;
import net.minecraft.block.Block;
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
		for(int k=0;k<2;k++) (new WorldGenMinable(AtlantisMod.oreAtlanteum.blockID,7)).generate(world,random,i + random.nextInt(16),random.nextInt(16),j + random.nextInt(16));
		for(int k=0;k<9;k++) (new WorldGenMinable(AtlantisMod.pebble.blockID,20,AtlantisMod.deepSandBlock.blockID)).generate(world,random,i + random.nextInt(16),random.nextInt(64),j + random.nextInt(16));		
		if(random.nextInt(500) == 1) (new WorldGenShipwreck()).generate(world, random, i + random.nextInt(15), 60, j + random.nextInt(15));
		for(int x=0;x<=4;x++) (new WorldGenGlowstone()).generate(world, random, i + random.nextInt(15), 55, j + random.nextInt(15));
		for(int x=0;x<=6;x++) (new WorldGenBubble2()).generate(world, random, i + random.nextInt(15), random.nextInt(60), j + random.nextInt(15));
		(new WorldGenBubble3()).generate(world, random, i + random.nextInt(15), random.nextInt(60), j + random.nextInt(15));
		if(random.nextInt(1000) == 1) (new WorldGenAtlantisCity()).generate(world, random, i + random.nextInt(15), 60, j + random.nextInt(15));
	}
	
	private void generateTheDeep(World world, Random random, int i, int j) {
		for(int k=0;k<9;k++) (new WorldGenMinable(AtlantisMod.pebble.blockID,20,AtlantisMod.deepSandBlock.blockID)).generate(world,random,i + random.nextInt(16),random.nextInt(64),j + random.nextInt(16));
	}

	private void generateEnd(World world, Random random, int i, int j) {}

	private void generateSurface(World world, Random random, int i, int j) {
		if(random.nextInt(222) == 1) (new WorldGenOverworldShrine()).generate(world, random, i, 80, j);
	}

	private void generateNether(World world, Random random, int i, int j) {}

}