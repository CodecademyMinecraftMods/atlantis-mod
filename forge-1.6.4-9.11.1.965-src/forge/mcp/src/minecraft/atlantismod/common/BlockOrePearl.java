package atlantismod.common;

import java.util.Random;

import net.minecraft.block.BlockOreStorage;

public class BlockOrePearl extends BlockOreStorage {

	public BlockOrePearl(int par1) {
		super(par1);
	}
	
	public int idDropped(int par1, Random par2Random, int par3) {
		return AtlantisMod.pearl.itemID;
	}

}
