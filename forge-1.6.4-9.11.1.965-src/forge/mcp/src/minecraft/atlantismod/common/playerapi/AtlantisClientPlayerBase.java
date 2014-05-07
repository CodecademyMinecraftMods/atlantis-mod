package atlantismod.common.playerapi;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.stats.StatList;
import net.minecraft.util.MathHelper;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.ForgeEventFactory;
import api.player.client.ClientPlayerAPI;
import api.player.client.ClientPlayerBase;
import atlantismod.common.AtlantisMod;

public class AtlantisClientPlayerBase extends ClientPlayerBase {

	public AtlantisClientPlayerBase(ClientPlayerAPI playerapi) {
		super(playerapi);
	}
	
	@Override
	public float getCurrentPlayerStrVsBlock(Block par1Block, boolean par2) {
		return getCurrentPlayerStrVsBlockForge(par1Block, par2, 0);
	}

	@Override
	public float getCurrentPlayerStrVsBlockForge(Block par1Block, boolean par2, int meta) {
        ItemStack stack = player.inventory.getCurrentItem();
        float f = (stack == null ? 1.0F : stack.getItem().getStrVsBlock(stack, par1Block, meta));
        if (f > 1.0F) {
            int i = EnchantmentHelper.getEfficiencyModifier(this.player);
            ItemStack itemstack = this.player.inventory.getCurrentItem();
            if (i > 0 && itemstack != null) {
                float f1 = (float)(i * i + 1);
                boolean canHarvest = ForgeHooks.canToolHarvestBlock(par1Block, meta, itemstack);
                if (!canHarvest && f <= 1.0F) {
                    f += f1 * 0.08F;
                } else {
                    f += f1;
                }
            }
        }

        if (this.player.isPotionActive(Potion.digSpeed)) f *= 1.0F + (float)(this.player.getActivePotionEffect(Potion.digSpeed).getAmplifier() + 1) * 0.2F;
        if (this.player.isPotionActive(Potion.digSlowdown)) f *= 1.0F - (float)(this.player.getActivePotionEffect(Potion.digSlowdown).getAmplifier() + 1) * 0.2F;
        if (this.player.isInsideOfMaterial(Material.water) && !EnchantmentHelper.getAquaAffinityModifier(this.player)) {
        	if(stack != null && (stack.itemID == AtlantisMod.axePearl.itemID || stack.itemID == AtlantisMod.pickaxePearl.itemID || stack.itemID == AtlantisMod.shovelPearl.itemID || stack.itemID == AtlantisMod.hoePearl.itemID)) {
        		f *= 2.0F;
        	} else {
        		f /= 5.0F;
        	}
        }
        if (!this.player.onGround) f /= 5.0F;
        f = ForgeEventFactory.getBreakSpeed(this.player, par1Block, meta, f);
        return (f < 0 ? 0 : f);
	}
	
}