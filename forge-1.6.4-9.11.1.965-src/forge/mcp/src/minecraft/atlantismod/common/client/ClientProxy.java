package atlantismod.common.client;

import atlantismod.common.CommonProxy;
import atlantismod.common.entity.EntitySquidman;
import atlantismod.common.entity.ModelSquidman;
import atlantismod.common.entity.RenderSquidman;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntitySquidman.class, new RenderSquidman(new ModelSquidman(), 0.3F));
	}
	
}