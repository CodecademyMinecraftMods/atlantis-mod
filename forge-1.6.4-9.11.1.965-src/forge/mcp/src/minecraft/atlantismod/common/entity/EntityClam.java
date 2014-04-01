package atlantismod.common.entity;

import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.world.World;

public class EntityClam extends EntityWaterMob {

	public EntityClam(World par1World) {
		super(par1World);
        this.tasks.addTask(1, new EntityAIWander(this, 0.0D));
	}
	public boolean attackEntityAsMob() {
	return false;
	}
	protected void applyEntityAttributes() {
		
	}
}