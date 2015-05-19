package io.github.codecademyminecraftmods.atlantismod.client;

import io.github.codecademyminecraftmods.atlantismod.CommonProxy;
import io.github.codecademyminecraftmods.atlantismod.entity.base.EntityAtlantisFish;
import io.github.codecademyminecraftmods.atlantismod.entity.base.EntityGiantSquid;
import io.github.codecademyminecraftmods.atlantismod.entity.base.EntityKraken;
import io.github.codecademyminecraftmods.atlantismod.entity.base.EntityMermaid;
import io.github.codecademyminecraftmods.atlantismod.entity.base.EntityShark;
import io.github.codecademyminecraftmods.atlantismod.entity.base.EntitySharkman;
import io.github.codecademyminecraftmods.atlantismod.entity.base.EntitySquidman;
import io.github.codecademyminecraftmods.atlantismod.entity.model.ModelFish;
import io.github.codecademyminecraftmods.atlantismod.entity.model.ModelGiantSquid;
import io.github.codecademyminecraftmods.atlantismod.entity.model.ModelKraken;
import io.github.codecademyminecraftmods.atlantismod.entity.model.ModelMermaid;
import io.github.codecademyminecraftmods.atlantismod.entity.model.ModelShark;
import io.github.codecademyminecraftmods.atlantismod.entity.model.ModelSharkman;
import io.github.codecademyminecraftmods.atlantismod.entity.model.ModelSquidman;
import io.github.codecademyminecraftmods.atlantismod.entity.render.RenderFish;
import io.github.codecademyminecraftmods.atlantismod.entity.render.RenderGiantSquid;
import io.github.codecademyminecraftmods.atlantismod.entity.render.RenderKraken;
import io.github.codecademyminecraftmods.atlantismod.entity.render.RenderMermaid;
import io.github.codecademyminecraftmods.atlantismod.entity.render.RenderShark;
import io.github.codecademyminecraftmods.atlantismod.entity.render.RenderSharkman;
import io.github.codecademyminecraftmods.atlantismod.entity.render.RenderSquidman;
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