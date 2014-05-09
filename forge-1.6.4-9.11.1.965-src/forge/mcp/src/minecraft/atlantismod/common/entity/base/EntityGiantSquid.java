package atlantismod.common.entity.base;

import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.world.World;

public class EntityGiantSquid extends EntitySquid {

	public EntityGiantSquid(World par1World) {
		super(par1World);
		this.experienceValue = 15;
	}

}