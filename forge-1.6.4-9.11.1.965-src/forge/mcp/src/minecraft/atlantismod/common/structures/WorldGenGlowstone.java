package atlantismod.common.structures;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenGlowstone extends WorldGenerator {

	public boolean LocationIsValidSpawn(World world, int i, int j, int k){
		return (world.getBlockId(i, j, k) == Block.waterStill.blockID);
	}

	public boolean generate(World world, Random rand, int i, int j, int k) {
		while(LocationIsValidSpawn(world, i, j, k) && j > 0) j--;
		j++;
		if(LocationIsValidSpawn(world, i, j, k)) {
			world.setBlock(i, j, k, Block.glowStone.blockID);
			return true;
		}
		return false;
	}
}