package atlantismod.common.thedeep;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import atlantismod.common.AtlantisMod;

public class WorldProviderTheDeep extends WorldProvider {

	@Override
	public String getDimensionName() {
		return "The Deep";
	}
	
	public void registerWorldChunkManager() {
		this.worldChunkMgr = new WorldChunkManagerHell(AtlantisMod.darkOcean, 0.0F, 0.0F);
		this.dimensionId = AtlantisMod.dimensionDeepID;
	}
	
	public IChunkProvider createChunkGenerator() {
		return new ChunkProviderTheDeep(this.worldObj, this.worldObj.getSeed(), false);
	}

}