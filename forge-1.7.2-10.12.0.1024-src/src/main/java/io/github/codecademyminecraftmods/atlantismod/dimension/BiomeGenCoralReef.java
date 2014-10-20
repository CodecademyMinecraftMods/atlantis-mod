package io.github.codecademyminecraftmods.atlantismod.dimension;

import io.github.codecademyminecraftmods.atlantismod.AtlantisMod;
import net.minecraft.world.biome.BiomeGenOcean;

public class BiomeGenCoralReef extends BiomeGenOcean {
	
	public BiomeGenCoralReef(int par1) {
		super(par1);
		this.fillerBlock = AtlantisMod.blockCoralRed;
	}

}