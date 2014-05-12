package atlantismod.common.client;

import atlantismod.common.CommonProxy;
import atlantismod.common.entity.base.EntityAtlantisFish;
import atlantismod.common.entity.base.EntityGiantSquid;
import atlantismod.common.entity.base.EntityKraken;
import atlantismod.common.entity.base.EntityMermaid;
import atlantismod.common.entity.base.EntityShark;
import atlantismod.common.entity.base.EntitySharkman;
import atlantismod.common.entity.base.EntitySquidman;
import atlantismod.common.entity.model.ModelFish;
import atlantismod.common.entity.model.ModelGiantSquid;
import atlantismod.common.entity.model.ModelKraken;
import atlantismod.common.entity.model.ModelMermaid;
import atlantismod.common.entity.model.ModelShark;
import atlantismod.common.entity.model.ModelSharkman;
import atlantismod.common.entity.model.ModelSquidman;
import atlantismod.common.entity.render.RenderFish;
import atlantismod.common.entity.render.RenderGiantSquid;
import atlantismod.common.entity.render.RenderKraken;
import atlantismod.common.entity.render.RenderMermaid;
import atlantismod.common.entity.render.RenderShark;
import atlantismod.common.entity.render.RenderSharkman;
import atlantismod.common.entity.render.RenderSquidman;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntitySquidman.class, new RenderSquidman(new ModelSquidman(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntitySharkman.class, new RenderSharkman(new ModelSharkman(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityGiantSquid.class, new RenderGiantSquid(new ModelGiantSquid(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityAtlantisFish.class, new RenderFish(new ModelFish(), 0.3F, "purple"));
		RenderingRegistry.registerEntityRenderingHandler(EntityShark.class, new RenderShark(new ModelShark(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityKraken.class, new RenderKraken(new ModelKraken(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityMermaid.class, new RenderMermaid(new ModelMermaid(), 0.3F));
	}
	
}