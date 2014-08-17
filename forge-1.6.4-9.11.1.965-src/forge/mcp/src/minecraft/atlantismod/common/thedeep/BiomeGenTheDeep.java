package atlantismod.common.thedeep;

import atlantismod.common.AtlantisMod;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenOcean;

public class BiomeGenTheDeep extends BiomeGenOcean {
	
	public BiomeGenTheDeep(int par1) {
		super(par1);
		this.fillerBlock = (byte)AtlantisMod.deepSandBlock.blockID;
		this.setColor(0);
	}

}
