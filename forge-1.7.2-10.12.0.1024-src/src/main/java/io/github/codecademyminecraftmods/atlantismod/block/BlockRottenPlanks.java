package io.github.codecademyminecraftmods.atlantismod.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class BlockRottenPlanks extends Block {
	
    public BlockRottenPlanks() {
        super(Material.wood);
    }
    
    @Override
    public Item getItemDropped(int par1, Random par2Random, int par3) {
        return Items.stick;
    }

    @Override
    public int quantityDroppedWithBonus(int par1, Random par2Random) {
        return this.quantityDropped(par2Random) + par2Random.nextInt(par1 + 1);
    }

    @Override
    public int quantityDropped(Random par1Random) {
        return 4 + par1Random.nextInt(2);
    }
}
