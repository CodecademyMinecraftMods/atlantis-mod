/*
*** MADE BY MITHION'S .SCHEMATIC TO JAVA CONVERTING TOOL v1.6 ***
*/

package net.minecraft.src;
import java.util.Random;

public class grotto extends WorldGenerator
{
	protected int[] GetValidSpawnBlocks() {
		return new int[] {
		};
	}

	public boolean LocationIsValidSpawn(World world, int i, int j, int k){
		int distanceToAir = 0;
		int checkID = world.getBlockId(i, j, k);

		while (checkID != 0){
			distanceToAir++;
			checkID = world.getBlockId(i, j + distanceToAir, k);
		}

		if (distanceToAir > 3){
			return false;
		}
		j += distanceToAir - 1;

		int blockID = world.getBlockId(i, j, k);
		int blockIDAbove = world.getBlockId(i, j+1, k);
		int blockIDBelow = world.getBlockId(i, j-1, k);
		for (int x : GetValidSpawnBlocks()){
			if (blockIDAbove != 0){
				return false;
			}
			if (blockID == x){
				return true;
			}else if (blockID == Block.snow.blockID && blockIDBelow == x){
				return true;
			}
		}
		return false;
	}

	public grotto() { }

	public boolean generate(World world, Random rand, int i, int j, int k) {
		//check that each corner is one of the valid spawn blocks
		if(!LocationIsValidSpawn(world, i, j, k) || !LocationIsValidSpawn(world, i + 7, j, k) || !LocationIsValidSpawn(world, i + 7, j, k + 7) || !LocationIsValidSpawn(world, i, j, k + 7))
		{
			return false;
		}

		world.setBlock(i + 0, j + 0, k + 3, Block.cobblestone.blockID);
		world.setBlock(i + 0, j + 0, k + 4, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 0, j + 1, k + 2, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 0, j + 1, k + 3, Block.cobblestone.blockID);
		world.setBlock(i + 0, j + 1, k + 4, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 0, j + 1, k + 5, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 0, j + 2, k + 2, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 0, j + 2, k + 3, Block.cobblestone.blockID);
		world.setBlock(i + 0, j + 2, k + 4, Block.cobblestone.blockID);
		world.setBlock(i + 0, j + 2, k + 5, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 0, j + 3, k + 3, Block.cobblestone.blockID);
		world.setBlock(i + 0, j + 3, k + 4, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 0, k + 1, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 0, k + 2, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 0, k + 3, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 0, k + 4, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 1, j + 0, k + 5, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 1, j + 0, k + 6, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 1, j + 1, k + 1, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 1, j + 1, k + 2, Block.mobSpawner.blockID);
		world.setBlock(i + 1, j + 1, k + 6, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 2, k + 1, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 1, j + 2, k + 6, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 3, k + 1, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 3, k + 2, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 1, j + 3, k + 5, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 1, j + 3, k + 6, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 1, j + 4, k + 2, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 1, j + 4, k + 3, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 4, k + 4, Block.cobblestone.blockID);
		world.setBlock(i + 1, j + 4, k + 5, Block.cobblestone.blockID);
		world.setBlock(i + 2, j + 0, k + 1, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 2, j + 0, k + 2, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 2, j + 0, k + 3, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 2, j + 0, k + 4, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 2, j + 0, k + 5, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 2, j + 0, k + 6, Block.cobblestone.blockID);
		world.setBlock(i + 2, j + 1, k + 0, Block.cobblestone.blockID);
		world.setBlock(i + 2, j + 1, k + 7, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 2, j + 2, k + 0, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 2, j + 2, k + 7, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 2, j + 3, k + 1, Block.cobblestone.blockID);
		world.setBlock(i + 2, j + 3, k + 6, Block.cobblestone.blockID);
		world.setBlock(i + 2, j + 4, k + 1, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 2, j + 4, k + 2, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 2, j + 4, k + 5, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 2, j + 4, k + 6, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 2, j + 5, k + 3, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 2, j + 5, k + 4, Block.cobblestone.blockID);
		world.setBlock(i + 3, j + 0, k + 0, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 3, j + 0, k + 1, Block.cobblestone.blockID);
		world.setBlock(i + 3, j + 0, k + 2, Block.cobblestone.blockID);
		world.setBlock(i + 3, j + 0, k + 3, Block.cobblestone.blockID);
		world.setBlock(i + 3, j + 0, k + 4, Block.cobblestone.blockID);
		world.setBlock(i + 3, j + 0, k + 5, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 3, j + 0, k + 6, Block.cobblestone.blockID);
		world.setBlock(i + 3, j + 0, k + 7, Block.cobblestone.blockID);
		world.setBlock(i + 3, j + 1, k + 0, Block.cobblestone.blockID);
		world.setBlock(i + 3, j + 1, k + 7, Block.oreRedstone.blockID);
		world.setBlock(i + 3, j + 2, k + 0, Block.cobblestone.blockID);
		world.setBlock(i + 3, j + 2, k + 7, Block.oreRedstone.blockID);
		world.setBlock(i + 3, j + 3, k + 0, Block.cobblestone.blockID);
		world.setBlock(i + 3, j + 3, k + 7, Block.cobblestone.blockID);
		world.setBlock(i + 3, j + 4, k + 1, Block.cobblestone.blockID);
		world.setBlock(i + 3, j + 4, k + 6, Block.cobblestone.blockID);
		world.setBlock(i + 3, j + 5, k + 2, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 3, j + 5, k + 3, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 3, j + 5, k + 4, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 3, j + 5, k + 5, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 4, j + 0, k + 0, Block.cobblestone.blockID);
		world.setBlock(i + 4, j + 0, k + 1, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 4, j + 0, k + 2, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 4, j + 0, k + 3, Block.cobblestone.blockID);
		world.setBlock(i + 4, j + 0, k + 4, Block.cobblestone.blockID);
		world.setBlock(i + 4, j + 0, k + 5, Block.cobblestone.blockID);
		world.setBlock(i + 4, j + 0, k + 6, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 4, j + 0, k + 7, Block.cobblestone.blockID);
		world.setBlock(i + 4, j + 1, k + 0, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 4, j + 1, k + 7, Block.oreRedstone.blockID);
		world.setBlock(i + 4, j + 2, k + 0, Block.cobblestone.blockID);
		world.setBlock(i + 4, j + 2, k + 7, Block.oreRedstone.blockID);
		world.setBlock(i + 4, j + 3, k + 0, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 4, j + 3, k + 7, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 4, j + 4, k + 1, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 4, j + 4, k + 6, Block.cobblestone.blockID);
		world.setBlock(i + 4, j + 5, k + 2, Block.cobblestone.blockID);
		world.setBlock(i + 4, j + 5, k + 3, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 4, j + 5, k + 4, Block.cobblestone.blockID);
		world.setBlock(i + 4, j + 5, k + 5, Block.cobblestone.blockID);
		world.setBlock(i + 5, j + 0, k + 1, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 5, j + 0, k + 2, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 5, j + 0, k + 3, Block.cobblestone.blockID);
		world.setBlock(i + 5, j + 0, k + 4, Block.cobblestone.blockID);
		world.setBlock(i + 5, j + 0, k + 5, Block.cobblestone.blockID);
		world.setBlock(i + 5, j + 0, k + 6, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 5, j + 1, k + 0, Block.cobblestone.blockID);
		world.setBlock(i + 5, j + 1, k + 7, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 5, j + 2, k + 0, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 5, j + 2, k + 7, Block.cobblestone.blockID);
		world.setBlock(i + 5, j + 3, k + 1, Block.cobblestone.blockID);
		world.setBlock(i + 5, j + 3, k + 6, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 5, j + 4, k + 1, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 5, j + 4, k + 2, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 5, j + 4, k + 5, Block.cobblestone.blockID);
		world.setBlock(i + 5, j + 4, k + 6, Block.cobblestone.blockID);
		world.setBlock(i + 5, j + 5, k + 3, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 5, j + 5, k + 4, Block.cobblestone.blockID);
		world.setBlock(i + 6, j + 0, k + 1, Block.cobblestone.blockID);
		world.setBlock(i + 6, j + 0, k + 2, Block.cobblestone.blockID);
		world.setBlock(i + 6, j + 0, k + 3, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 6, j + 0, k + 4, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 6, j + 0, k + 5, Block.cobblestone.blockID);
		world.setBlock(i + 6, j + 0, k + 6, Block.cobblestone.blockID);
		world.setBlock(i + 6, j + 1, k + 1, Block.cobblestoneMossy.blockID);
		world.setBlockAndMetadata(i + 6, j + 1, k + 2, Block.chest.blockID, 4);
		world.setBlock(i + 6, j + 1, k + 6, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 6, j + 2, k + 1, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 6, j + 2, k + 6, Block.cobblestone.blockID);
		world.setBlock(i + 6, j + 3, k + 1, Block.cobblestone.blockID);
		world.setBlock(i + 6, j + 3, k + 2, Block.cobblestone.blockID);
		world.setBlock(i + 6, j + 3, k + 5, Block.cobblestone.blockID);
		world.setBlock(i + 6, j + 3, k + 6, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 6, j + 4, k + 2, Block.cobblestone.blockID);
		world.setBlock(i + 6, j + 4, k + 3, Block.cobblestone.blockID);
		world.setBlock(i + 6, j + 4, k + 4, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 6, j + 4, k + 5, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 7, j + 0, k + 3, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 7, j + 0, k + 4, Block.cobblestone.blockID);
		world.setBlock(i + 7, j + 1, k + 2, Block.cobblestone.blockID);
		world.setBlock(i + 7, j + 1, k + 3, Block.cobblestoneMossy.blockID);
		world.setBlock(i + 7, j + 1, k + 4, Block.cobblestone.blockID);
		world.setBlock(i + 7, j + 1, k + 5, Block.cobblestone.blockID);
		world.setBlock(i + 7, j + 2, k + 2, Block.cobblestone.blockID);
		world.setBlock(i + 7, j + 2, k + 3, Block.cobblestone.blockID);
		world.setBlock(i + 7, j + 2, k + 4, Block.cobblestone.blockID);
		world.setBlock(i + 7, j + 2, k + 5, Block.cobblestone.blockID);
		world.setBlock(i + 7, j + 3, k + 3, Block.cobblestone.blockID);
		world.setBlock(i + 7, j + 3, k + 4, Block.cobblestoneMossy.blockID);
		world.setBlockAndMetadataWithNotify(i + 1, j + 1, k + 3, Block.vine.blockID, 2);
		world.setBlockAndMetadataWithNotify(i + 1, j + 2, k + 3, Block.vine.blockID, 2);
		world.setBlockAndMetadataWithNotify(i + 1, j + 2, k + 4, Block.vine.blockID, 1);
		world.setBlockAndMetadataWithNotify(i + 1, j + 3, k + 3, Block.vine.blockID, 2);
		world.setBlockAndMetadataWithNotify(i + 1, j + 3, k + 4, Block.vine.blockID, 1);
		world.setBlockWithNotify(i + 2, j + 1, k + 1, Block.torchWood.blockID);
		world.setBlockWithNotify(i + 2, j + 1, k + 6, Block.torchWood.blockID);
		world.setBlockAndMetadataWithNotify(i + 2, j + 3, k + 5, Block.vine.blockID, 2);
		world.setBlockAndMetadataWithNotify(i + 3, j + 2, k + 1, Block.vine.blockID, 4);
		world.setBlockAndMetadataWithNotify(i + 3, j + 3, k + 1, Block.vine.blockID, 4);
		world.setBlockAndMetadataWithNotify(i + 3, j + 4, k + 2, Block.vine.blockID, 4);
		world.setBlockWithNotify(i + 5, j + 1, k + 1, Block.torchWood.blockID);
		world.setBlockWithNotify(i + 5, j + 1, k + 6, Block.torchWood.blockID);
		world.setBlockAndMetadataWithNotify(i + 5, j + 3, k + 3, Block.vine.blockID, 4);
		world.setBlockAndMetadataWithNotify(i + 5, j + 4, k + 3, Block.vine.blockID, 4);
		world.setBlockAndMetadataWithNotify(i + 5, j + 4, k + 4, Block.vine.blockID, 8);
		world.setBlockAndMetadataWithNotify(i + 6, j + 1, k + 3, Block.vine.blockID, 8);
		world.setBlockAndMetadataWithNotify(i + 6, j + 1, k + 4, Block.vine.blockID, 8);
		world.setBlockAndMetadataWithNotify(i + 6, j + 1, k + 5, Block.vine.blockID, 8);
		world.setBlockAndMetadataWithNotify(i + 6, j + 2, k + 3, Block.vine.blockID, 8);
		world.setBlockAndMetadataWithNotify(i + 6, j + 2, k + 4, Block.vine.blockID, 8);
		world.setBlockAndMetadataWithNotify(i + 6, j + 3, k + 3, Block.vine.blockID, 8);
		world.setBlockAndMetadataWithNotify(i + 6, j + 3, k + 4, Block.vine.blockID, 8);

		return true;
	}
}