package atlantismod.common.dimension;

import atlantismod.common.AtlantisMod;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenOcean;

public class BiomeGenCoralReef extends BiomeGenOcean {
	
	public BiomeGenCoralReef(int par1) {
		super(par1);
		this.fillerBlock = (byte)AtlantisMod.blockCoralRed.blockID;
	}

}