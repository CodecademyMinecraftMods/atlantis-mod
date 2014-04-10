package atlantismod.common.dimension;

import atlantismod.common.AtlantisMod;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenOcean;

public class BiomeGenAtlantisOcean extends BiomeGenOcean {
	
	public BiomeGenAtlantisOcean(int par1) {
		super(par1);
		this.fillerBlock = (byte)AtlantisMod.deepSandBlock.blockID;
	}

}
