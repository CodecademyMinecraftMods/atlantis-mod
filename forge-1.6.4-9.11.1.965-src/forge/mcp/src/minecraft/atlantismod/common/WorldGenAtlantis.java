package atlantismod.common;

import java.util.Random;
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
		case 2:
			generateAtlantis(world, random, chunkX * 16, chunkZ * 16);
		}
	}

	private void generateAtlantis(World world, Random random, int i, int j) {
		if(random.nextInt(4) == 4) (new WorldGenShipwreck()).generate(world, random, i, random.nextInt(60), j);
	}

	private void generateEnd(World world, Random random, int i, int j) {}

	private void generateSurface(World world, Random random, int i, int j) {}

	private void generateNether(World world, Random random, int i, int j) {}

}