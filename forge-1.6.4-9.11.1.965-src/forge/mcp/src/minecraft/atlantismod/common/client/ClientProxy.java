package atlantismod.common.client;

import atlantismod.common.CommonProxy;
import atlantismod.common.entity.EntityAtlantisFish;
import atlantismod.common.entity.EntityGiantSquid;
import atlantismod.common.entity.EntityShark;
import atlantismod.common.entity.EntitySquidman;
import atlantismod.common.entity.ModelFish;
import atlantismod.common.entity.ModelGiantSquid;
import atlantismod.common.entity.ModelShark;
import atlantismod.common.entity.ModelSquidman;
import atlantismod.common.entity.RenderFish;
import atlantismod.common.entity.RenderGiantSquid;
import atlantismod.common.entity.RenderShark;
import atlantismod.common.entity.RenderSquidman;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntitySquidman.class, new RenderSquidman(new ModelSquidman(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityGiantSquid.class, new RenderGiantSquid(new ModelGiantSquid(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityAtlantisFish.class, new RenderFish(new ModelFish(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityShark.class, new RenderShark(new ModelShark(), 0.3F));
	}
	
}