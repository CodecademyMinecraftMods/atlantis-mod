package atlantismod.common.entity.base;

import atlantismod.common.entity.ai.EntityAIAtlantisSwim;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.world.World;

public class EntityGiantSquid extends EntitySquid {

	public EntityGiantSquid(World par1World) {
		super(par1World);
		this.tasks.addTask(0, new EntityAIAtlantisSwim(this, 1.0D));
		this.experienceValue = 15;
	}
	
	protected boolean isAIEnabled() {
		return true;
	}

}