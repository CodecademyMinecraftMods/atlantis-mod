package atlantismod.common;

import java.util.Random;

import atlantismod.common.structures.WorldGenReef1;
import atlantismod.common.structures.WorldGenReef2;
import atlantismod.common.structures.WorldGenReef3;
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
		}
	}

	private void generateAtlantis(World world, Random random, int i, int j) {
		if(random.nextInt(75) == 1) (new WorldGenShipwreck()).generate(world, random, i, random.nextInt(60), j);
		switch(random.nextInt(4)) {
		case 1:
			(new WorldGenReef1()).generate(world, random, i, random.nextInt(60), j);
			break;
		case 2:
			(new WorldGenReef2()).generate(world, random, i, random.nextInt(60), j);
			break;
		case 3:
			(new WorldGenReef3()).generate(world, random, i, random.nextInt(60), j);
			break;
		default:
			break;
		}
	}

	private void generateEnd(World world, Random random, int i, int j) {}

	private void generateSurface(World world, Random random, int i, int j) {}

	private void generateNether(World world, Random random, int i, int j) {}

}