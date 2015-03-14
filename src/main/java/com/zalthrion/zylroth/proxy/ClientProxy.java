package com.zalthrion.zylroth.proxy;

import com.zalthrion.zylroth.entity.EntityBird;
import com.zalthrion.zylroth.entity.EntityMutantTenebraeGolem;
import com.zalthrion.zylroth.entity.EntityPyroKnight;
import com.zalthrion.zylroth.entity.EntityTenebraeGolem;
import com.zalthrion.zylroth.entity.EntityUndeadMinion;
import com.zalthrion.zylroth.entity.EntityUndeadWarrior;
import com.zalthrion.zylroth.model.entity.ModelBird;
import com.zalthrion.zylroth.model.entity.ModelMutantTenebraeGolem;
import com.zalthrion.zylroth.model.entity.ModelTenebraeGolem;
import com.zalthrion.zylroth.model.entity.ModelUndead;
import com.zalthrion.zylroth.reference.RenderIDs;
import com.zalthrion.zylroth.render.BlockTESRRenderer;
import com.zalthrion.zylroth.render.entity.RenderBird;
import com.zalthrion.zylroth.render.entity.RenderMutantTenebraeGolem;
import com.zalthrion.zylroth.render.entity.RenderPyroKnight;
import com.zalthrion.zylroth.render.entity.RenderTenebraeGolem;
import com.zalthrion.zylroth.render.entity.RenderUndeadMinion;
import com.zalthrion.zylroth.render.entity.RenderUndeadWarrior;
import com.zalthrion.zylroth.render.tile.RenderTileEntityInfuser;
import com.zalthrion.zylroth.tile.TileEntityInfuser;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	
	@Override public void init() {
		super.init();
		this.registerRenderers();
		this.registerBlockRenderers();
	}
	
	public void registerRenderInformation() {}
	
	public void registerRenderers() {
		float shadowSize = 0.5F;
		
		// MOBS
		
		RenderingRegistry.registerEntityRenderingHandler(EntityMutantTenebraeGolem.class, new RenderMutantTenebraeGolem(new ModelMutantTenebraeGolem(), shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityPyroKnight.class, new RenderPyroKnight(new ModelUndead(), shadowSize, shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityUndeadWarrior.class, new RenderUndeadWarrior(new ModelUndead(), shadowSize, shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityUndeadMinion.class, new RenderUndeadMinion(new ModelUndead(), shadowSize, shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityBird.class, new RenderBird(new ModelBird(), shadowSize, shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityTenebraeGolem.class, new RenderTenebraeGolem(new ModelTenebraeGolem(), shadowSize));
		
	}
	
	public void registerBlockRenderers() {
		RenderIDs.setIDs();
		
		// BLOCKS
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityInfuser.class, new RenderTileEntityInfuser());
		RenderingRegistry.registerBlockHandler(new BlockTESRRenderer(new TileEntityInfuser(), RenderIDs.blockInfuserRI));
		
	}
	
}