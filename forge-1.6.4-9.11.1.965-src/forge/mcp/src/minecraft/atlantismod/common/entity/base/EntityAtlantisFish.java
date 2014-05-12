package atlantismod.common.entity.base;

import atlantismod.common.AtlantisMod;
import atlantismod.common.entity.ai.EntityAIAtlantisSwim;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityAtlantisFish extends EntityWaterMob {

	public EntityAtlantisFish(World par1World) {
		super(par1World);
		this.experienceValue = 2;
		this.tasks.addTask(0, new EntityAIAtlantisSwim(this, 1.0D));
        this.tasks.addTask(1, new EntityAILookIdle(this));
	}
	
	protected boolean isAIEnabled() {
		return true;
	}
	
	protected String getLivingSound() {
		return "";
	}
	
	protected String getHurtSound() {
		return "";
	}
	
	protected String getDeathSound() {
		return "";
	}
	
    protected void playStepSound(int par1, int par2, int par3, int par4) {}
	
	public int getDropItemId() {
		return AtlantisMod.fishHead.itemID;
	}
	
}
