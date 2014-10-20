package io.github.codecademyminecraftmods.atlantismod.dimension;

import io.github.codecademyminecraftmods.atlantismod.AtlantisMod;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderAtlantis extends WorldProvider {

	@Override
	public String getDimensionName() {
		return "Atlantis";
	}
	
	public void registerWorldChunkManager() {
		this.worldChunkMgr = new WorldChunkManagerAtlantis(worldObj.getSeed(), terrainType);
		this.dimensionId = AtlantisMod.dimensionID;
	}
	
	public IChunkProvider createChunkGenerator() {
		return new ChunkProviderAtlantis(this.worldObj, this.worldObj.getSeed(), false);
	}

}