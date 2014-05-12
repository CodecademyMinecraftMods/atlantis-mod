package atlantismod.common.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelMermaid extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer tail;
    ModelRenderer fin;
    ModelRenderer finc1;
    ModelRenderer finc2;
    ModelRenderer finc2c1;
    ModelRenderer finc2c2;
    ModelRenderer finc2c3;
    ModelRenderer finc2c4;
  
  public ModelMermaid()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-4F, -8F, -4F, 8, 8, 8);
      head.setRotationPoint(0F, 1F, 0F);
      head.setTextureSize(64, 64);
      head.mirror = true;
      setRotation(head, -0.0174533F, 0F, 0F);
      body = new ModelRenderer(this, 16, 16);
      body.addBox(-4F, 0F, -2F, 8, 12, 4);
      body.setRotationPoint(0F, 0F, 0F);
      body.setTextureSize(64, 64);
      body.mirror = true;
      setRotation(body, 0.3141593F, 0F, 0F);
      rightarm = new ModelRenderer(this, 40, 16);
      rightarm.addBox(-3F, -2F, -2F, 4, 12, 4);
      rightarm.setRotationPoint(-5F, 2F, 0F);
      rightarm.setTextureSize(64, 64);
      rightarm.mirror = true;
      setRotation(rightarm, 0F, 0F, 0F);
      leftarm = new ModelRenderer(this, 40, 16);
      leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
      leftarm.setRotationPoint(5F, 2F, 0F);
      leftarm.setTextureSize(64, 64);
      leftarm.mirror = true;
      setRotation(leftarm, 0F, 0F, 0F);
      tail = new ModelRenderer(this, 0, 32);
      tail.addBox(-4F, 0F, -1F, 8, 12, 3);
      tail.setRotationPoint(0F, 10F, 3F);
      tail.setTextureSize(64, 64);
      tail.mirror = true;
      setRotation(tail, 1.151917F, 0F, 0F);
      fin = new ModelRenderer(this, 32, 0);
      fin.addBox(-3F, 0F, 0F, 6, 1, 2);
      fin.setRotationPoint(0F, 14F, 13F);
      fin.setTextureSize(64, 64);
      fin.mirror = true;
      setRotation(fin, 0F, 0F, 0F);
      finc1 = new ModelRenderer(this, 32, 0);
      finc1.addBox(-4F, 0F, 2F, 8, 1, 1);
      finc1.setRotationPoint(0F, 0F, 0F);
      //finc1.setRotationPoint(0F, 14F, 13F);
      finc1.setTextureSize(64, 64);
      finc1.mirror = true;
      setRotation(finc1, 0F, 0F, 0F);
      finc2 = new ModelRenderer(this, 32, 0);
      finc2.addBox(-5F, 0F, 3F, 10, 1, 2);
      finc2.setRotationPoint(0F, 0F, 0F);
      //finc2.setRotationPoint(0F, 14F, 13F);
      finc2.setTextureSize(64, 64);
      finc2.mirror = true;
      setRotation(finc2, 0F, 0F, 0F);
      finc2c1 = new ModelRenderer(this, 32, 0);
      finc2c1.addBox(-6F, 0F, 5F, 3, 1, 3);
      finc2c1.setRotationPoint(0F, 0F, 0F);
      //finc2c1.setRotationPoint(0F, 14F, 13F);
      finc2c1.setTextureSize(64, 64);
      finc2c1.mirror = true;
      setRotation(finc2c1, 0F, 0F, 0F);
      finc2c2 = new ModelRenderer(this, 32, 0);
      finc2c2.addBox(3F, 0F, 5F, 3, 1, 3);
      finc2c2.setRotationPoint(0F, 0F, 0F);
      //finc2c2.setRotationPoint(0F, 14F, 13F);
      finc2c2.setTextureSize(64, 64);
      finc2c2.mirror = true;
      setRotation(finc2c2, 0F, 0F, 0F);
      finc2c3 = new ModelRenderer(this, 32, 0);
      finc2c3.addBox(-3F, 0F, 5F, 1, 1, 1);
      finc2c3.setRotationPoint(0F, 0F, 0F);
      //finc2c3.setRotationPoint(0F, 14F, 13F);
      finc2c3.setTextureSize(64, 64);
      finc2c3.mirror = true;
      setRotation(finc2c3, 0F, 0F, 0F);
      finc2c4 = new ModelRenderer(this, 32, 0);
      finc2c4.addBox(2F, 0F, 5F, 1, 1, 1);
      finc2c4.setRotationPoint(0F, 0F, 0F);
      //finc2c4.setRotationPoint(0F, 14F, 13F);
      finc2c4.setTextureSize(64, 64);
      finc2c4.mirror = true;
      setRotation(finc2c4, 0F, 0F, 0F);
      
      //tail.addChild(fin);
      fin.addChild(finc1);
      finc1.addChild(finc2);
      finc2.addChild(finc2c1);
      finc2.addChild(finc2c2);
      finc2.addChild(finc2c3);
      finc2.addChild(finc2c4);
  }
  
  public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
  {
	super.render(par1Entity, par2, par3, par4, par5, par6, par7);
	setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
    head.render(par7);
    body.render(par7);
    rightarm.render(par7);
    leftarm.render(par7);
    tail.render(par7);
    fin.render(par7);
    //finc1.render(par7);
    //finc2.render(par7);
    //finc2c1.render(par7);
    //finc2c2.render(par7);
    //finc2c3.render(par7);
    //finc2c4.render(par7);
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
    fin.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
  }

}
