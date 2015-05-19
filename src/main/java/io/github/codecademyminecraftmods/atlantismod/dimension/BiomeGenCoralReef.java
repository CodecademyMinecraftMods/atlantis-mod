package io.github.codecademyminecraftmods.atlantismod.dimension;

import io.github.codecademyminecraftmods.atlantismod.AtlantisMod;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenOcean;

public class BiomeGenCoralReef extends BiomeGenOcean {
	
	public BiomeGenCoralReef(int par1) {
		super(par1);
		this.spawnableCreatureList.clear();
		this.topBlock = AtlantisMod.blockCoralRed;
		this.fillerBlock = Blocks.sand;
	}

}