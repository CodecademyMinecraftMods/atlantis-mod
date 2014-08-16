package atlantismod.common.structures;

import java.util.Random;

import atlantismod.common.AtlantisMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenOverworldShrine extends WorldGenerator {
	
	public boolean LocationIsInvalid(World world, int i, int j, int k){
		return (world.getBlockId(i, j, k) == 0 || world.getBlockId(i, j, k) == Block.waterStill.blockID);
	}

	@Override
	public boolean generate(World world, Random rand, int i, int j, int k) {
		while(LocationIsInvalid(world, i, j, k) && j > 0) j--;
		j++;
		if(!LocationIsInvalid(world, i, j, k) && !LocationIsInvalid(world, i, j + 2, k)) {
			world.setBlock(i, j, k, Block.blockNetherQuartz.blockID, 2, 3);
			world.setBlock(i+1, j, k, Block.blockNetherQuartz.blockID, 2, 3);
			world.setBlock(i-1, j, k, Block.blockNetherQuartz.blockID, 2, 3);
			world.setBlock(i, j, k+1, Block.blockNetherQuartz.blockID, 2, 3);
			world.setBlock(i, j, k-1, Block.blockNetherQuartz.blockID, 2, 3);
	        world.setBlock(i, j+1, k, Block.chest.blockID, 2, 2);
	        WeightedRandomChestContent[] content = new WeightedRandomChestContent[] {new WeightedRandomChestContent(AtlantisMod.atlantisEye.itemID, 1, 1, 1, 1)};
	        TileEntityChest tileentitychest = (TileEntityChest)world.getBlockTileEntity(i, j, k);
	        if (tileentitychest != null) WeightedRandomChestContent.generateChestContents(rand, content, tileentitychest, 1);
	        return true;
		}
		return false;
	}
	
}