package io.github.codecademyminecraftmods.atlantismod.item;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSeaweed extends Item {
	
    private Block spawn;

    public ItemSeaweed(Block block) {
        this.spawn = block;
    }

    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
        Block i1 = par3World.getBlock(par4, par5, par6);
        if (i1 == Blocks.snow && (par3World.getBlockMetadata(par4, par5, par6) & 7) < 1) {
            par7 = 1;
        } else if (i1 != Blocks.vine && i1 != Blocks.tallgrass && i1 != Blocks.deadbush) {
        	switch(par7) {
        	case 0:
        		--par5;
        		break;
        	case 1:
        		++par5;
        		break;
        	case 2:
        		--par6;
        		break;
        	case 3:
        		++par6;
        		break;
        	case 4:
        		--par4;
        		break;
        	case 5:
        		++par4;
        		break;
        	}
        }

        if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack)) {
            return false;
        } else if (par1ItemStack.stackSize == 0) {
            return false;
        } else {
            if (par3World.canPlaceEntityOnSide(this.spawn, par4, par5, par6, false, par7, (Entity)null, par1ItemStack)) {
                Block block = this.spawn;
                int j1 = block.onBlockPlaced(par3World, par4, par5, par6, par7, par8, par9, par10, 0);
                if (par3World.setBlock(par4, par5, par6, this.spawn, j1, 3)) {
                    if (par3World.getBlock(par4, par5, par6) == this.spawn) {
                        this.spawn.onBlockPlacedBy(par3World, par4, par5, par6, par2EntityPlayer, par1ItemStack);
                        this.spawn.onPostBlockPlaced(par3World, par4, par5, par6, j1);
                    }
                    par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), block.stepSound.getBreakSound(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);
                    --par1ItemStack.stackSize;
                }
            }

            return true;
        }
    }
}