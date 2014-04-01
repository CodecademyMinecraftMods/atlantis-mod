package atlantismod.common.entity;

import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityGiantSquid extends EntityMob {

	public EntityGiantSquid(World par1World) {
		super(par1World);
		this.experienceValue = 8;
        this.tasks.addTask(1, new EntityAIWander(this, 1.0D));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        
	}
	public boolean isAIEnabled() {
		return true;
	}
	
	public boolean attackEntityAsMob() {
		return true;
	}

}