package atlantismod.common.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BlockRottenPlanks extends Block {
	
    public BlockRottenPlanks(int par1) {
        super(par1, Material.wood);
    }
    
    public int idDropped(int par1, Random par2Random, int par3) {
        return Item.stick.itemID;
    }

    /**
     * Returns the usual quantity dropped by the block plus a bonus of 1 to 'i' (inclusive).
     */
    public int quantityDroppedWithBonus(int par1, Random par2Random) {
        return this.quantityDropped(par2Random) + par2Random.nextInt(par1 + 1);
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random) {
        return 4 + par1Random.nextInt(2);
    }
}
