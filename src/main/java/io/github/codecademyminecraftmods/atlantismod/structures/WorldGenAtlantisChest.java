package io.github.codecademyminecraftmods.atlantismod.structures;

import io.github.codecademyminecraftmods.atlantismod.AtlantisMod;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenAtlantisChest extends WorldGenerator {

    public static final WeightedRandomChestContent[] content = new WeightedRandomChestContent[] {new WeightedRandomChestContent(Items.diamond, 0, 1, 3, 3), new WeightedRandomChestContent(AtlantisMod.pearl, 0, 1, 5, 10), new WeightedRandomChestContent(Items.bone, 0, 4, 6, 20), new WeightedRandomChestContent(Items.rotten_flesh, 0, 3, 7, 16), new WeightedRandomChestContent(AtlantisMod.atlantisWand, 0, 1, 1, 3)};

    private final int itemsToGenerateInBonusChest;

    public WorldGenAtlantisChest(int par1)
    {
        this.itemsToGenerateInBonusChest = par1;
    }

    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5) {
        par1World.setBlock(par3, par4, par5, Blocks.chest, 2, 2);
        TileEntityChest tileentitychest = (TileEntityChest)par1World.getTileEntity(par3, par4, par5);
        if (tileentitychest != null) WeightedRandomChestContent.generateChestContents(par2Random, content, tileentitychest, this.itemsToGenerateInBonusChest);
        return true;
    }

	public boolean generate(World world, Random random, int i, int j, int k, int metadata) {
		world.setBlock(i, j, k, Blocks.chest, 2, metadata);
        TileEntityChest tileentitychest = (TileEntityChest)world.getTileEntity(i, j, k);
        if (tileentitychest != null) WeightedRandomChestContent.generateChestContents(random, content, tileentitychest, this.itemsToGenerateInBonusChest);
        return true;
	}
}
