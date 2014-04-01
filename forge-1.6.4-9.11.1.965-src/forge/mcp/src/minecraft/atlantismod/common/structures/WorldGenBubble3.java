package atlantismod.common.structures;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenBubble3 extends WorldGenerator {

	public boolean LocationIsValidSpawn(World world, int i, int j, int k){
		return (world.getBlockId(i, j, k) == Block.waterStill.blockID);
	}
	
	public boolean generate(World world, Random rand, int i, int j, int k) {
		if(LocationIsValidSpawn(world, i, j, k) && LocationIsValidSpawn(world, i + 2, j, k) && LocationIsValidSpawn(world, i + 2, j, k + 2) && LocationIsValidSpawn(world, i, j, k + 2) && LocationIsValidSpawn(world, i, j+3, k) && LocationIsValidSpawn(world, i + 2, j+3, k) && LocationIsValidSpawn(world, i + 2, j+3, k + 2) && LocationIsValidSpawn(world, i, j+3, k + 2)) {
			
			world.setBlock(i + 0, j + 0, k + 0, 0, 0, 0);
			world.setBlock(i + 0, j + 0, k + 1, 0, 0, 0);
			world.setBlock(i + 0, j + 0, k + 2, 0, 0, 0);
			world.setBlock(i + 0, j + 1, k + 0, 0, 0, 0);
			world.setBlock(i + 0, j + 1, k + 1, 0, 0, 0);
			world.setBlock(i + 0, j + 1, k + 2, 0, 0, 0);
			world.setBlock(i + 0, j + 2, k + 0, 0, 0, 0);
			world.setBlock(i + 0, j + 2, k + 1, 0, 0, 0);
			world.setBlock(i + 0, j + 2, k + 2, 0, 0, 0);
			world.setBlock(i + 1, j + 0, k + 0, 0, 0, 0);
			world.setBlock(i + 1, j + 0, k + 1, 0, 0, 0);
			world.setBlock(i + 1, j + 0, k + 2, 0, 0, 0);
			world.setBlock(i + 1, j + 1, k + 0, 0, 0, 0);
			world.setBlock(i + 1, j + 1, k + 1, 0, 0, 0);
			world.setBlock(i + 1, j + 1, k + 2, 0, 0, 0);
			world.setBlock(i + 1, j + 2, k + 0, 0, 0, 0);
			world.setBlock(i + 1, j + 2, k + 1, 0, 0, 0);
			world.setBlock(i + 1, j + 2, k + 2, 0, 0, 0);
			world.setBlock(i + 2, j + 0, k + 0, 0, 0, 0);
			world.setBlock(i + 2, j + 0, k + 1, 0, 0, 0);
			world.setBlock(i + 2, j + 0, k + 2, 0, 0, 0);
			world.setBlock(i + 2, j + 1, k + 0, 0, 0, 0);
			world.setBlock(i + 2, j + 1, k + 1, 0, 0, 0);
			world.setBlock(i + 2, j + 1, k + 2, 0, 0, 0);
			world.setBlock(i + 2, j + 2, k + 0, 0, 0, 0);
			world.setBlock(i + 2, j + 2, k + 1, 0, 0, 0);
			world.setBlock(i + 2, j + 2, k + 2, 0, 0, 0);
	
			return true;
		}
		return false;
	}
}