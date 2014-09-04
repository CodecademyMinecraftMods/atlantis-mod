package atlantismod.common.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelSharkman extends ModelBase
{
  //fields
    ModelRenderer headc1;
    ModelRenderer headc2;
    ModelRenderer headc3;
    ModelRenderer headc4;
    ModelRenderer headc5;
    ModelRenderer headc6;
    ModelRenderer headc7;
    ModelRenderer headc8;
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
  
  public ModelSharkman()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      headc1 = new ModelRenderer(this, 0, 0);
      headc1.addBox(0F, 0F, 0F, 8, 1, 11);
      headc1.setRotationPoint(-4F, -9F, -5F);
      //headc1.setRotationPoint(-4F, -2F, -7F);
      headc1.setTextureSize(64, 32);
      headc1.mirror = true;
      setRotation(headc1, 0F, 0F, 0F);
      headc2 = new ModelRenderer(this, 0, 0);
      headc2.addBox(0F, 0F, 0F, 8, 1, 11);
      headc2.setRotationPoint(0F, -1F, 0F);
      //headc2.setRotationPoint(-4F, -3F, -7F);
      headc2.setTextureSize(64, 32);
      headc2.mirror = true;
      setRotation(headc2, 0F, 0F, 0F);
      headc3 = new ModelRenderer(this, 0, 0);
      headc3.addBox(0F, 0F, 0F, 6, 1, 10);
      headc3.setRotationPoint(1F, -1F, 1F);
      //headc3.setRotationPoint(-3F, -4F, -6F);
      headc3.setTextureSize(64, 32);
      headc3.mirror = true;
      setRotation(headc3, 0F, 0F, 0F);
      headc4 = new ModelRenderer(this, 0, 0);
      headc4.addBox(0F, 0F, 0F, 4, 1, 9);
      headc4.setRotationPoint(1F, -1F, 1F);
      //headc4.setRotationPoint(-2F, -5F, -5F);
      headc4.setTextureSize(64, 32);
      headc4.mirror = true;
      setRotation(headc4, 0F, 0F, 0F);
      headc5 = new ModelRenderer(this, 0, 0);
      headc5.addBox(0F, 0F, 0F, 2, 1, 6);
      headc5.setRotationPoint(1F, -1F, 3F);
      //headc5.setRotationPoint(-1F, -6F, -2F);
      headc5.setTextureSize(64, 32);
      headc5.mirror = true;
      setRotation(headc5, 0F, 0F, 0F);
      headc6 = new ModelRenderer(this, 0, 0);
      headc6.addBox(0F, 0F, 0F, 2, 1, 5);
      headc6.setRotationPoint(0F, -1F, 1F);
      //headc6.setRotationPoint(-1F, -7F, -1F);
      headc6.setTextureSize(64, 32);
      headc6.mirror = true;
      setRotation(headc6, 0F, 0F, 0F);
      headc7 = new ModelRenderer(this, 0, 0);
      headc7.addBox(0F, 0F, 0F, 2, 1, 4);
      headc7.setRotationPoint(0F, -1F, 1F);
      //headc7.setRotationPoint(-1F, -8F, 0F);
      headc7.setTextureSize(64, 32);
      headc7.mirror = true;
      setRotation(headc7, 0F, 0F, 0F);
      headc8 = new ModelRenderer(this, 0, 0);
      headc8.addBox(0F, 0F, 0F, 2, 1, 3);
      headc8.setRotationPoint(0F, -1F, 1F);
      //headc8.setRotationPoint(-1F, -9F, 1F);
      headc8.setTextureSize(64, 32);
      headc8.mirror = true;
      setRotation(headc8, 0F, 0F, 0F);
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-4F, -8F, -4F, 8, 1, 10);
      head.setRotationPoint(0F, 7F, -2F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      body = new ModelRenderer(this, 16, 16);
      body.addBox(-4F, 0F, -2F, 8, 12, 4);
      body.setRotationPoint(0F, 0F, 0F);
      body.setTextureSize(64, 32);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      rightarm = new ModelRenderer(this, 40, 16);
      rightarm.addBox(-3F, -2F, -2F, 4, 12, 4);
      rightarm.setRotationPoint(-5F, 2F, 0F);
      rightarm.setTextureSize(64, 32);
      rightarm.mirror = true;
      setRotation(rightarm, 0F, 0F, 0F);
      leftarm = new ModelRenderer(this, 40, 16);
      leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
      leftarm.setRotationPoint(5F, 2F, 0F);
      leftarm.setTextureSize(64, 32);
      leftarm.mirror = true;
      setRotation(leftarm, 0F, 0F, 0F);
      rightleg = new ModelRenderer(this, 0, 16);
      rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
      rightleg.setRotationPoint(-2F, 12F, 0F);
      rightleg.setTextureSize(64, 32);
      rightleg.mirror = true;
      setRotation(rightleg, 0F, 0F, 0F);
      leftleg = new ModelRenderer(this, 0, 16);
      leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
      leftleg.setRotationPoint(2F, 12F, 0F);
      leftleg.setTextureSize(64, 32);
      leftleg.mirror = true;
      setRotation(leftleg, 0F, 0F, 0F);
      
      head.addChild(headc1);
      headc1.addChild(headc2);
      headc2.addChild(headc3);
      headc3.addChild(headc4);
      headc4.addChild(headc5);
      headc5.addChild(headc6);
      headc6.addChild(headc7);
      headc7.addChild(headc8);
  }
  
  public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
  {
	super.render(par1Entity, par2, par3, par4, par5, par6, par7);
	setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
    //headc1.render(par7);
    //headc2.render(par7);
    //headc3.render(par7);
    //headc4.render(par7);
    //headc5.render(par7);
    //headc6.render(par7);
    //headc7.render(par7);
    //headc8.render(par7);
    head.render(par7);
    body.render(par7);
    rightarm.render(par7);
    leftarm.render(par7);
    rightleg.render(par7);
    leftleg.render(par7);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
  {
	  super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
	  rightarm.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
	  leftarm.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
	  leftleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
	  rightleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
  }

}
