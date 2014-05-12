package atlantismod.common.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelKraken extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer headc1;
    ModelRenderer body;
    ModelRenderer bodyc1;
    ModelRenderer bodyc2;
    ModelRenderer bodyc3;
    ModelRenderer bodyc4;
    ModelRenderer bodyc5;
    ModelRenderer bodyc6;
    ModelRenderer bodyc7;
    ModelRenderer tail;
    ModelRenderer tailc1;
  
  public ModelKraken()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      head = new ModelRenderer(this, 0, 32);
      head.addBox(0F, 0F, 0F, 10, 16, 16);
      head.setRotationPoint(1F, 8F, -8F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      headc1 = new ModelRenderer(this, 0, 64);
      headc1.addBox(0F, 0F, 0F, 10, 12, 16);
      headc1.setRotationPoint(-10F, 4F, 0F);
      headc1.setTextureSize(64, 32);
      headc1.mirror = true;
      setRotation(headc1, 0F, 0F, 0F);
      body = new ModelRenderer(this, 0, 0);
      body.addBox(0F, 0F, 0F, 16, 16, 16);
      body.setRotationPoint(11F, 0F, 0F);
      //body.setRotationPoint(12F, 8F, -8F);
      body.setTextureSize(64, 32);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      bodyc1 = new ModelRenderer(this, 0, 0);
      bodyc1.addBox(0F, 0F, 0F, 16, 16, 16);
      bodyc1.setRotationPoint(17F, 0F, 0F);
      //bodyc1.setRotationPoint(29F, 8F, -8F);
      bodyc1.setTextureSize(64, 32);
      bodyc1.mirror = true;
      setRotation(bodyc1, 0F, 0F, 0F);
      bodyc2 = new ModelRenderer(this, 0, 0);
      bodyc2.addBox(0F, 0F, 0F, 16, 16, 16);
      bodyc2.setRotationPoint(17F, 0F, 0F);
      //bodyc2.setRotationPoint(46F, 8F, -8F);
      bodyc2.setTextureSize(64, 32);
      bodyc2.mirror = true;
      setRotation(bodyc2, 0F, 0F, 0F);
      bodyc3 = new ModelRenderer(this, 0, 0);
      bodyc3.addBox(0F, 0F, 0F, 16, 16, 16);
      bodyc3.setRotationPoint(17F, 0F, 0F);
      //bodyc3.setRotationPoint(63F, 8F, -8F);
      bodyc3.setTextureSize(64, 32);
      bodyc3.mirror = true;
      setRotation(bodyc3, 0F, 0F, 0F);
      bodyc4 = new ModelRenderer(this, 0, 0);
      bodyc4.addBox(0F, 0F, 0F, 16, 16, 16);
      bodyc4.setRotationPoint(17F, 0F, 0F);
      //bodyc4.setRotationPoint(80F, 8F, -8F);
      bodyc4.setTextureSize(64, 32);
      bodyc4.mirror = true;
      setRotation(bodyc4, 0F, 0F, 0F);
      bodyc5 = new ModelRenderer(this, 0, 0);
      bodyc5.addBox(0F, 0F, 0F, 16, 16, 16);
      bodyc5.setRotationPoint(17F, 0F, 0F);
      //bodyc5.setRotationPoint(97F, 8F, -8F);
      bodyc5.setTextureSize(64, 32);
      bodyc5.mirror = true;
      setRotation(bodyc5, 0F, 0F, 0F);
      bodyc6 = new ModelRenderer(this, 0, 0);
      bodyc6.addBox(0F, 0F, 0F, 16, 16, 16);
      bodyc6.setRotationPoint(17F, 0F, 0F);
      //bodyc6.setRotationPoint(114F, 8F, -8F);
      bodyc6.setTextureSize(64, 32);
      bodyc6.mirror = true;
      setRotation(bodyc6, 0F, 0F, 0F);
      bodyc7 = new ModelRenderer(this, 0, 0);
      bodyc7.addBox(0F, 0F, 0F, 16, 16, 16);
      bodyc7.setRotationPoint(17F, 0F, 0F);
      //bodyc7.setRotationPoint(131F, 8F, -8F);
      bodyc7.setTextureSize(64, 32);
      bodyc7.mirror = true;
      setRotation(bodyc7, 0F, 0F, 0F);
      tail = new ModelRenderer(this, 64, 0);
      tail.addBox(0F, 0F, 0F, 10, 10, 10);
      tail.setRotationPoint(17F, 3F, 3F);
      //tail.setRotationPoint(148F, 11F, -5F);
      tail.setTextureSize(64, 32);
      tail.mirror = true;
      setRotation(tail, 0F, 0F, 0F);
      tailc1 = new ModelRenderer(this, 64, 20);
      tailc1.addBox(0F, 0F, 0F, 7, 6, 6);
      tailc1.setRotationPoint(10F, 2F, 2F);
      //tailc1.setRotationPoint(158F, 13F, -3F);
      tailc1.setTextureSize(64, 32);
      tailc1.mirror = true;
      setRotation(tailc1, 0F, 0F, 0F);
      
      head.addChild(headc1);
      head.addChild(body);
      body.addChild(bodyc1);
      bodyc1.addChild(bodyc2);
      bodyc2.addChild(bodyc3);
      bodyc3.addChild(bodyc4);
      bodyc4.addChild(bodyc5);
      bodyc5.addChild(bodyc6);
      bodyc6.addChild(bodyc7);
      bodyc7.addChild(tail);
      tail.addChild(tailc1);
  }
  
  public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
  {
	super.render(par1Entity, par2, par3, par4, par5, par6, par7);
	setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
    head.render(par7);
    //headc1.render(par7);
    //body.render(par7);
    //bodyc1.render(par7);
    //bodyc2.render(par7);
    //bodyc3.render(par7);
    //bodyc4.render(par7);
    //bodyc5.render(par7);
    //bodyc6.render(par7);
    //bodyc7.render(par7);
    //tail.render(par7);
    //tailc1.render(par7);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
	    super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
	    head.rotateAngleY = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
	    body.rotateAngleY = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
	    bodyc1.rotateAngleY = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
	    bodyc2.rotateAngleY = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
	    bodyc3.rotateAngleY = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
	    bodyc4.rotateAngleY = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
	    bodyc5.rotateAngleY = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
	    bodyc6.rotateAngleY = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
	    bodyc7.rotateAngleY = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
	    tail.rotateAngleY = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
  }

}
