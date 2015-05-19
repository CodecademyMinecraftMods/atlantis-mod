package io.github.codecademyminecraftmods.atlantismod.thedeep;

import io.github.codecademyminecraftmods.atlantismod.AtlantisMod;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderTheDeep extends WorldProvider {

	@Override
	public String getDimensionName() {
		return "The Deep";
	}
	
	public void registerWorldChunkManager() {
		this.worldChunkMgr = new WorldChunkManagerHell(AtlantisMod.darkOcean, 0.0F);
		this.dimensionId = AtlantisMod.dimensionDeepID;
	}
	
	public IChunkProvider createChunkGenerator() {
		return new ChunkProviderTheDeep(this.worldObj, this.worldObj.getSeed(), false);
	}

}