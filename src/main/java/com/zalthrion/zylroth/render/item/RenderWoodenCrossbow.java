package com.zalthrion.zylroth.render.item;


public class RenderWoodenCrossbow {
	//TODO TileEntityRenderer
/*	private ModelCrossbow model;
	
	private Minecraft mc = Minecraft.getMinecraft();
	
	public RenderWoodenCrossbow() { 
		model = new ModelCrossbow();
	}
	
	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		switch (type) {
		
			case EQUIPPED: // render in third person
				GL11.glPushMatrix();
				GL11.glScalef(1.55F, 1.55F, 1.55F);
				mc.renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID.toLowerCase() + ":" + "textures/items/" + "woodenCrossbow.png"));
				GL11.glRotatef(145F, 1.0F, 0.0F, 0.0F);	   //rotate 0 � on X axis
				GL11.glRotatef(2F, 0.0F, 1.0F, 0.0F);	  // rotate -5 � on Y axis
				GL11.glRotatef(-20F, 0.0F, 0.0F, 1.0F);  // rotate -150 � on Z axis
				GL11.glTranslatef(0.25F, -0.2F, -0.4F);    //translate model to fit in the hand of the player
				//the entity argument can/could be passed to as null.
				model.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
				break;
			
			case EQUIPPED_FIRST_PERSON:
				GL11.glPushMatrix();
				GL11.glScalef(1F, 1F, 1F);
				mc.renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID.toLowerCase() + ":" + "textures/items/" + "woodenCrossbow.png"));
				GL11.glRotatef(110F, 1.0F, 0.0F, 0.0F);	   //rotate 0 � on X axis
				GL11.glRotatef(-50F, 0.0F, 1.0F, 0.0F);	  // rotate -5 � on Y axis
				GL11.glRotatef(-70F, 0.0F, 0.0F, 1.0F);  // rotate -150 � on Z axis
				GL11.glTranslatef(0.45F, -0.32F, -0.4F);    //translate model to fit in the hand of the player
				model.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
				break;
			
			case ENTITY:
				GL11.glPushMatrix();
				GL11.glScalef(1.5F, 1.5F, 1.5F);
				mc.renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID.toLowerCase() + ":" + "textures/items/" + "woodenCrossbow.png"));
				GL11.glRotatef(150F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(2F, 0.0F, 1.0F, 0.0F);
				GL11.glRotatef(0F, 0.0F, 0.0F, 1.0F);
				GL11.glTranslatef(0.25F, -0.2F, -0.4F); 
				model.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
				break;
			
			case INVENTORY:
				GL11.glPushMatrix();
				GL11.glScalef(1.5F, 1.5F, 1.5F);
				mc.renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID.toLowerCase() + ":" + "textures/items/" + "woodenCrossbow.png"));
				GL11.glRotatef(0F, 1.0F, 0.0F, 0.0F);	   //rotate 0 � on X axis
				GL11.glRotatef(0F, 0.0F, 1.0F, 0.0F);
				GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
				GL11.glTranslatef(0.4F, 0.2F, -0.4F); 
				model.render(0.0625F);
				GL11.glPopMatrix();
				break;
			
			default:
				break;
		}
	}
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}
	
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		
		switch (type) {
			case INVENTORY:
				return true;
			default:
				break;
		}
		
		return false;
		
	}*/
}