package atlantismod.common.thedeep;

import java.util.ArrayList;
import atlantismod.common.AtlantisMod;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderTheDeep extends WorldProvider {

	@Override
	public String getDimensionName() {
		return "Atlantis";
	}
	
	public void registerWorldChunkManager() {
		this.worldChunkMgr = new WorldChunkManagerTheDeep(worldObj.getSeed(), terrainType);
		this.dimensionId = AtlantisMod.dimensionDeepID;
	}
	
	public IChunkProvider createChunkGenerator() {
		return new ChunkProviderTheDeep(this.worldObj, this.worldObj.getSeed(), false);
	}

}