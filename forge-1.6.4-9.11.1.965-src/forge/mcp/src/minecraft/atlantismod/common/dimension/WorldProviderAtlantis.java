package atlantismod.common.dimension;

import atlantismod.common.AtlantisMod;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderAtlantis extends WorldProvider {

	@Override
	public String getDimensionName() {
		return "Atlantis";
	}
	
	public void registerWorldChunkManager() {
		this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.ocean, -1.0F, 1.0F);
		this.dimensionId = AtlantisMod.dimensionID;
	}
	
	public IChunkProvider createChunkGenerator() {
		return new ChunkProviderAtlantis(worldObj, worldObj.getSeed(), true);
	}

}
