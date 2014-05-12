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
	private boolean valid = false;
	public static String validColors[] = {"red","green","yellow","brown","blue","orange","purple","silver"};
	
	public RenderFish(ModelBase par1ModelBase, float par2, String par3) {
		super(par1ModelBase, par2);
		this.model = (ModelFish)this.mainModel;
		this.color = par3;
		for(String x : RenderFish.validColors) {
			if(x.equals(this.color)) this.valid = true;
		}
		if(!this.valid) throw new IllegalArgumentException("Exception assigning a color to fish: '"+par3+"' is not a valid color.");
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
