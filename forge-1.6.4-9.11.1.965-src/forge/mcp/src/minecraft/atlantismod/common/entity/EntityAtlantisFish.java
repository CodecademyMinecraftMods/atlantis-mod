package atlantismod.common.entity;

import atlantismod.common.AtlantisMod;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityAtlantisFish extends EntityWaterMob {

	public EntityAtlantisFish(World par1World) {
		super(par1World);
		this.setHealth(8.0F);
		this.setSize(0.0F, 0.0F);
		this.setAIMoveSpeed(0.35F);
		this.tasks.addTask(0, new EntityAIWander(this, this.getAIMoveSpeed()));
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
	
	protected int getDropItemId() {
		return AtlantisMod.fishHead.itemID;
	}
	
}
