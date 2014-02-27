package atlantismod.common;

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
		this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.ocean, 0.4F, 0.6F);
		this.dimensionId = AtlantisMod.dimensionID;
	}
	
	public IChunkProvider createChunkGenerator() {
		return new ChunkProviderAtlantis(worldObj, worldObj.getSeed(), true);
	}

}
