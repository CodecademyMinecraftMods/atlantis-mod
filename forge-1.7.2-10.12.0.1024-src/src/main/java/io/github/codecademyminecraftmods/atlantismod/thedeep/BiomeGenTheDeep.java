package io.github.codecademyminecraftmods.atlantismod.thedeep;

import io.github.codecademyminecraftmods.atlantismod.AtlantisMod;
import net.minecraft.world.biome.BiomeGenOcean;

public class BiomeGenTheDeep extends BiomeGenOcean {
	
	public BiomeGenTheDeep(int par1) {
		super(par1);
		this.fillerBlock = AtlantisMod.deepSandBlock;
		this.setColor(0);
	}

}
