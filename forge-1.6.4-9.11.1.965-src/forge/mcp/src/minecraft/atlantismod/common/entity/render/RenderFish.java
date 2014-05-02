package atlantismod.common.entity.render;

import java.util.Random;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import atlantismod.common.entity.base.EntityAtlantisFish;
import atlantismod.common.entity.model.ModelFish;

public class RenderFish extends RenderLiving {

	protected ModelFish model;
	private String color;
	private Random rand = new Random();
	
	public RenderFish(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		this.model = (ModelFish)this.mainModel;
		switch(rand.nextInt(8)) {
		case 1:
			this.color = "red";
			break;
		case 2:
			this.color = "green";
			break;
		case 3:
			this.color = "yellow";
			break;
		case 4:
			this.color = "brown";
			break;
		case 5:
			this.color = "blue";
			break;
		case 6:
			this.color = "orange";
			break;
		case 7:
			this.color = "purple";
			break;
		default:
			this.color = "silver";
		}
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		String str = "atlantismod:textures/entity/" + this.color + "_fish.png";
		return new ResourceLocation(str);
	}
	
	public void renderFish(EntityAtlantisFish entity, double par2, double par4, double par6, float par8, float par9) {
        super.doRenderLiving(entity, par2, par4, par6, par8, par9);
    }

	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
        renderFish((EntityAtlantisFish)par1EntityLiving, par2, par4, par6, par8, par9);
    }

	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
        renderFish((EntityAtlantisFish)par1Entity, par2, par4, par6, par8, par9);
    }

}
