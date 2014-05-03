package atlantismod.common.entity.base;

import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityGiantSquid extends EntitySquid {

	public EntityGiantSquid(World par1World) {
		super(par1World);
		this.experienceValue = 15;
        
	}
	protected void applyEntityAttributes() {
		
	}

}